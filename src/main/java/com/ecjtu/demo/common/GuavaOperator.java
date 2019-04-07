package com.ecjtu.demo.common;

import com.ecjtu.demo.entity.Area;
import com.google.common.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author wangheng
 * @date 2019-04-07 下午7:29
 * @description
 *
 * 使用谷歌  的 guava 框架  自定义存储
 *
 **/
public class GuavaOperator {

    private static Logger  logger = LoggerFactory.getLogger(GuavaOperator.class);
    private static Cache<String, String> dataCache  ;

    private GuavaOperator(){
            dataCache
            //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
            = CacheBuilder.newBuilder()
            //设置并发级别为8，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(8)
            //设置写缓存后8秒钟过期
            .expireAfterWrite(8, TimeUnit.SECONDS)
            //设置缓存容器的初始容量为10
            .initialCapacity(10)
            //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
            .maximumSize(100)
            //设置要统计缓存的命中率
            .recordStats()
            //设置缓存的移除通知
            .removalListener(new RemovalListener<Object, Object>() {
                @Override
                public void onRemoval(RemovalNotification<Object, Object> notification) {
                    logger.info(notification.getKey() + " was removed, cause is " + notification.getCause());
                }
            })
            //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
            .build();
    }

    private static GuavaOperator  guavaOperator = new GuavaOperator();

    public static GuavaOperator getInstance(){
        return guavaOperator;
    }

    public static  String getData(String key){
        return dataCache.getIfPresent(key);
    }

    public static void setData(String key ,String value){
        logger.info("set data pairs are {} ,{}",key ,value);
        dataCache.put(key,value);
    }


}
