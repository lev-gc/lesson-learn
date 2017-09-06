/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.config;

import com.lesson.learn.quartz.job.JobFactory;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * <b><code>QuartzConfig</code></b>
 * <p/>
 * QuartzConfig
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 15:26.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@Configuration
public class QuartzConfig {

    /**
     * Set properties of QuartzProperties.
     *
     * @return the properties
     */
    @Bean
    public Properties quartzProperties() {
        Properties quartzProperties = new Properties();

        quartzProperties.setProperty("org.quartz.scheduler.instanceName", "DefaultQuartzScheduler");
        quartzProperties.setProperty("org.quartz.scheduler.rmi.export", "false");
        quartzProperties.setProperty("org.quartz.scheduler.rmi.proxy", "false");
        quartzProperties.setProperty("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");

        quartzProperties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", "20");
        quartzProperties.setProperty("org.quartz.threadPool.threadPriority", "5");
        quartzProperties.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");

        quartzProperties.setProperty("org.quartz.jobStore.misfireThreshold", "1800000");
        quartzProperties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");

        return quartzProperties;
    }

    /**
     * set SchedulerFactoryBean to a Bean for auto init.
     *
     * @return the scheduler factory bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        return new SchedulerFactoryBean();
    }

    /**
     * Set a Bean of Scheduler.
     *
     * @param schedulerFactoryBean the scheduler factory bean
     * @param jobFactory           the job factory
     * @param quartzProperties     the quartz properties
     * @return the scheduler
     */
    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean, JobFactory jobFactory, Properties quartzProperties) {
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(false);
        return schedulerFactoryBean.getScheduler();
    }

}
