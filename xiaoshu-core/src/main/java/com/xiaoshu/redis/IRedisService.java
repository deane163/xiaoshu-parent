package com.xiaoshu.redis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

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
 * @Date : Create in 2017年12月12日下午7:45:06
 * 
 * Copyright (C)2013-2017 小树盛凯科技 All rights reserved.
 */
public abstract class IRedisService<T> {
    
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    
     
    
    @Resource
    protected HashOperations<String, String, T> hashOperations;
    
     /**
     * 存入redis中的key
     */
    protected abstract String getRedisKey();
    
     /**
     * 添加
     *
     * @param key    key
     * @param doamin 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    public void put(String key, T doamin, long expire) {
        hashOperations.put(getRedisKey(), key, doamin);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }
    
    /**
     * 删除
     *
     * @param key 传入key的名称
     */
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }
    
    /**
     * 查询
     *
     * @param key 查询的key
     * @return
     */
    public T get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }
    
    /**
     * 获取当前redis库下所有对象
     * @return
     */
    public List<T> getAll() {
        return hashOperations.values(getRedisKey());
    }
    
    /**
     * 查询查询当前redis库下所有key
     *
     * @return
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }
    
    /**
     * 判断key是否存在redis中
     *
     * @param key 传入key的名称
     * @return
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }
    
    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count() {
        return hashOperations.size(getRedisKey());
    }
    
    /**
     * 清空redis
     */
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(), key));
    }
}
