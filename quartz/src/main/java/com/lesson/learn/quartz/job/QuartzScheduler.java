/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b><code>Scheduler</code></b>
 * <p/>
 * Scheduler
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 15:59.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@Component
public class QuartzScheduler {

    /**
     * The Scheduler.
     */
    private final Scheduler scheduler;

    /**
     * Instantiates a new Quartz scheduler.
     *
     * @param scheduler the scheduler
     */
    @Autowired
    public QuartzScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /**
     * Start.
     *
     * @throws InterruptedException the interrupted exception
     * @throws SchedulerException   the scheduler exception
     */
    public void start() throws InterruptedException, SchedulerException {
        System.out.println("Start! Creating Jobs...");
        for (int i = 0; i < 10; i++) {
            QuartzJob quartzJob = new QuartzJob();
            quartzJob.setJobId(String.valueOf(i + 1));
            quartzJob.setUpdateInterval(1);
            String id = quartzJob.getJobId();
            long updateInterval = quartzJob.getUpdateInterval();

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("id", id);
            jobDataMap.put("job", quartzJob);
            JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                    .usingJobData(jobDataMap)
                    .withIdentity(id)
                    .build();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule("0 0/" + updateInterval + " * * * ?")
                                    .withMisfireHandlingInstructionFireAndProceed()
                    )
                    .withIdentity(System.currentTimeMillis() + "" + id + "_trigger")
                    .build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
        }
        scheduler.start();
    }

    /**
     * Stop.
     */
    public void stop() {
        // TODO
    }

}
