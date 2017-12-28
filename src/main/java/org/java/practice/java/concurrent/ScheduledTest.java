package org.java.practice.java.concurrent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 晋阳 on 2017/12/28.
 */
public class ScheduledTest {

    /**
     * 以固定周期频率执行任务
     * 按指定频率周期执行某个任务。
     初始化延迟0ms开始执行，每隔100ms重新执行一次任务。
     间隔指的是连续两次任务开始执行的间隔。
     对于scheduleAtFixedRate方法，当执行任务的时间大于我们指定的间隔时间时，它并不会在指定间隔时开辟
     一个新的线程并发执行这个任务。而是等待该线程执行完毕。
     */
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("执行任务");
                    }
                },
                0,
                100,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 以固定延迟时间进行执行
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     * 按指定频率间隔执行某个任务。
     初始化时延时0ms开始执行，本次执行结束后延迟100ms开始下次执行。
     */
    public static void executeFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("执行任务");
                    }
                },
                0,
                100,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 每天晚上8点执行一次
     * 每天定时安排任务进行执行
     */
    public static void executeEightAtNightPerDay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("20:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        executor.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("执行任务");
                    }
                },
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
