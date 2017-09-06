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

    /**
     * The Quartz scheduler.
     */
    private final QuartzScheduler quartzScheduler;

    /**
     * Instantiates a new Schedule listener.
     *
     * @param quartzScheduler the quartz scheduler
     */
    @Autowired
    public ScheduleListener(QuartzScheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }

    /**
     * On application event.
     *
     * @param contextRefreshedEvent the context refreshed event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            quartzScheduler.start();
        } catch (SchedulerException | InterruptedException e) {
            // TODO: exception handler
            e.printStackTrace();
        }
    }

}
