package com.chenfei.cfgo.test.schedule;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/5/17 16:45
 */
@Slf4j
public class ScheduleFixedDelayTest {

    static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2); // Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        executorService.scheduleAtFixedRate(() -> {
            try {
                log.info("线程名：{}|i:{} 开始", Thread.currentThread().getName(), 1);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("线程名：{}|i:{} 结束", Thread.currentThread().getName(), 1);
        }, 1000, 5000, TimeUnit.MICROSECONDS);

        executorService.scheduleAtFixedRate(() -> {
            try {
                log.info("线程名：{}|i:{} 开始", Thread.currentThread().getName(), 2);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("线程名：{}|i:{} 结束", Thread.currentThread().getName(), 2);
        }, 1000, 3000, TimeUnit.MICROSECONDS);

        executorService.scheduleAtFixedRate(() -> {
            try {
                log.info("线程名：{}|i:{} 开始", Thread.currentThread().getName(), 3);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("线程名：{}|i:{} 结束", Thread.currentThread().getName(), 3);
        }, 1000, 2000, TimeUnit.MICROSECONDS);
    }

    static void doTask(int id) {

    }
}
