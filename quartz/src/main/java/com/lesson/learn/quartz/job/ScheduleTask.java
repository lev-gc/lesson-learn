/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.job;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * <b><code>ScheduleTask</code></b>
 * <p/>
 * ScheduleTask
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 15:25.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
public class ScheduleTask implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS"));
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
