/**
 * 
 */
package com.xiaoshu.task;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.util.CollectionUtils;

import com.xiaoshu.task.impl.LogTask;

/**
 * 
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @Description : 
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:06:14
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
public abstract class Task <T> implements Runnable{

    public Queue<T> queues =  new ConcurrentLinkedQueue<T>();
    private ReentrantLock lock = new ReentrantLock();
    
    private static Task<?> task;
    /**
     * 使用当独线程时，线程的休眠时间
     */
    private static final long SLEEP_TIME = 5000;
    
    private DataHandler<T> handler ;
    
    public Task(DataHandler<T> handler){
        this.handler = handler;
    }
    
    
    public void addQueue(T t){
        System.out.println("异步加入队列");
        queues.add(t);
    }
    
    @SuppressWarnings("rawtypes")
    public static Task getInstance(DataHandler dataHandler) throws Exception{
        return getInstance(LogTask.class,dataHandler );
    }
    
    @SuppressWarnings("rawtypes")
    public static Task getInstance(Class<? extends Task> taskClass, DataHandler dataHandler) 
            throws NoSuchMethodException, SecurityException, InstantiationException, 
            IllegalAccessException, IllegalArgumentException, InvocationTargetException{
       if (task == null){
           Constructor<? extends Task> constructor = taskClass.getConstructor(DataHandler.class);
           task = constructor.newInstance(dataHandler);
       }
        return task;
    }
    
    /**
     * 执行异步操作
     */
    public void execute(){
        List<T> datas  = new ArrayList<T>();
        lock.lock();
        try{
            //讲数据取到ConcurrentArrayList中
            T t = queues.poll();
            while (t != null){
                System.out.println("//==================== +1" );
                datas.add(t);
                t = queues.poll();
            }
        }finally{
            lock.unlock();
        }
        // 批量处理数据
        if(!CollectionUtils.isEmpty(datas)){
            handler.handlerData(datas);
        }
    }
    
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(SLEEP_TIME);
                System.out.println("//===========> 每5秒进行日志的处理");
                execute();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
