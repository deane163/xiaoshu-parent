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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Description : 基于线程处理任务，批量的数据处理。（适合批量的日志数据处理）
 * ---------------------------------
 * @Author : deane.administrator
 * @Date : Create in 2018年1月13日 下午4:06:14
 * 
 * Copyright (C)2013-2018 小树盛凯科技 All rights reserved.
 */
public abstract class Task <T> implements Runnable{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public Queue<T> queues =  new ConcurrentLinkedQueue<T>();
    private ReentrantLock lock = new ReentrantLock();
    
    
    private AtomicBoolean async = new AtomicBoolean(false);
    protected static Task<?> task;
    /**
     * 使用当独线程时，线程的休眠时间
     */
    private static final long SLEEP_TIME = 5000;
    
    protected DataHandler<T> handler ;
    
    public Task(DataHandler<T> handler){
        this.handler = handler;
    }
    
    public AtomicBoolean getAsync() {
		return async;
	}

	public void setAsync(Boolean isboolean) {
		this.async.set(isboolean);
	}

	public void addQueue(T t){
        System.out.println("异步加入队列");
        queues.add(t);
    }
    
    @SuppressWarnings("rawtypes")
    public  Task getInstance(DataHandler dataHandler) throws Exception{
        return getInstance(LogTask.class,dataHandler );
    }
    
    @SuppressWarnings("rawtypes")
    public  abstract Task getInstance(Class<? extends Task> taskClass, DataHandler dataHandler);
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
            	logger.info("// ===============> 任务队列 +1");
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
    
    // 持续从任务队列中取任务，并执行任务
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(SLEEP_TIME);
                logger.info("//===========> 每5秒进行日志的处理");
                execute();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
