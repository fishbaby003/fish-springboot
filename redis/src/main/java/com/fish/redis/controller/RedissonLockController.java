package com.fish.redis.controller;

import com.fish.redis.utils.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁控制器
 * @author fish
 * @since 2021-07-30
 */
@RestController
//@Api(tags = "redisson", description = "redis分布式锁控制器" )
@RequestMapping("/redisson" )
@Slf4j
public class RedissonLockController {

    /**
     * 锁测试共享变量
     */
    private Integer lockCount = 10;
 
    /**
     * 无锁测试共享变量
     */
    private Integer count = 10;
 
    /**
     * 模拟线程数
     */
    private static int threadNum = 10;
 
    /**
     * 模拟并发测试加锁和不加锁
     * @return
     */
    @GetMapping("/test")
//    @ApiOperation(value = "模拟并发测试加锁和不加锁")
    public void lock(){
        // 计数器
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < threadNum; i ++) {
            MyRunnable myRunnable = new MyRunnable(countDownLatch);
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }
        // 释放所有线程
        countDownLatch.countDown();
    }
 
    /**
     * 加锁测试
     */
    private void testLockCount() {
        String lockKey = "lock-test";
        try {
            // 加锁，设置超时时间2s
            RedisLockUtil.lock(lockKey,2, TimeUnit.SECONDS);
            lockCount--;
            log.info("lockCount值："+lockCount);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }finally {
            // 释放锁
            RedisLockUtil.unlock(lockKey);
        }
    }
 
    /**
     * 无锁测试
     */
    private void testCount() {
        count--;
        log.info("count值："+count);
    }
 
 
    public class MyRunnable implements Runnable {
        /**
         * 计数器
         */
        final CountDownLatch countDownLatch;
 
        public MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }
 
        @Override
        public void run() {
            try {
                // 阻塞当前线程，直到计时器的值为0
                countDownLatch.await();
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
            // 无锁操作
            testCount();
            // 加锁操作
            testLockCount();
        }
 
    }
 
}