/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.job;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * <b><code>ScheduleListener</code></b>
 * <p/>
 * ScheduleListener
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 15:59.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@Component
public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {

    private final QuartzScheduler quartzScheduler;

    @Autowired
    public ScheduleListener(QuartzScheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            quartzScheduler.start();
        } catch (InterruptedException | SchedulerException e) {
            e.printStackTrace();
        }
    }

}
