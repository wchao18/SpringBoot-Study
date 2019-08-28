package com.it.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangchao
 * @description
 * @date 2019/08/27 17:21
 */
@Component
public class MyTask {

    /**
     * 默认的任务调度是串行的，如下代码，容易出现执行时间不对，改为并行执行！！！
     */

    @Scheduled(fixedRate = 5000)
    public void jobA() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("当前时间:" + simpleDateFormat.format(new Date()) + "A任务执行");
    }


    @Scheduled(cron = "* * * * * ?")
    public void jobB() throws Exception{
        Thread.sleep(5000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("当前时间:" + simpleDateFormat.format(new Date()) + "B任务执行");
    }
}
