/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.config;

import com.lesson.learn.quartz.job.JobFactory;
import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
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

    @Bean
    public Properties quartzProperties() throws IOException {
        Properties quartzProperties = new Properties();
        //
        quartzProperties.setProperty("org.quartz.scheduler.instanceName", "DefaultQuartzScheduler");
        quartzProperties.setProperty("org.quartz.scheduler.rmi.export", "false");
        quartzProperties.setProperty("org.quartz.scheduler.rmi.proxy", "false");
        quartzProperties.setProperty("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");
        //
        quartzProperties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        quartzProperties.setProperty("org.quartz.threadPool.threadCount", "5");
        quartzProperties.setProperty("org.quartz.threadPool.threadPriority", "5");
        quartzProperties.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
        //
        quartzProperties.setProperty("org.quartz.jobStore.misfireThreshold", "60000");
        quartzProperties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
        return quartzProperties;
    }

    @Bean
    public Scheduler scheduler(JobFactory jobFactory, Properties quartzProperties) throws Exception {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setSchedulerFactoryClass(StdSchedulerFactory.class);
//        schedulerFactoryBean.setAutoStartup(true);
//        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(false);
        schedulerFactoryBean.setJobFactory(jobFactory);
        schedulerFactoryBean.setQuartzProperties(quartzProperties);
        schedulerFactoryBean.afterPropertiesSet();
        return schedulerFactoryBean.getScheduler();
    }

}
