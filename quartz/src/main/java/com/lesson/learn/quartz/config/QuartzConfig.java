/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.config;

import com.lesson.learn.quartz.job.JobFactory;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Properties;

/**
 * <b>QuartzConfig</b>
 * <p/>
 * QuartzConfig
 * <p/>
 *
 * @author lev-gc
 * @version 0.1.0
 * @date 2017/9/4 15:26
 */
@Configuration
public class QuartzConfig {

    /**
     * The Job factory.
     */
    private final JobFactory jobFactory;

    /**
     * Instantiates a new Quartz config.
     *
     * @param jobFactory the job factory
     */
    @Autowired
    public QuartzConfig(JobFactory jobFactory) {
        this.jobFactory = jobFactory;
    }

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
     * Scheduler factory bean scheduler factory bean.
     *
     * @return the scheduler factory bean
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(false);
        return schedulerFactoryBean;
    }

    /**
     * Set a Bean of Scheduler.
     *
     * @return the scheduler
     */
    @Bean
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }

}
