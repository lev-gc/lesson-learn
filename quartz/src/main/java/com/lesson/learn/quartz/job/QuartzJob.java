/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <b><code>QuartzJob</code></b>
 * <p/>
 * QuartzJob
 * <p/>
 * <b>Creation Time:</b> 2017/9/4 16:14.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@DisallowConcurrentExecution
public class QuartzJob implements Job {

    private String jobId;

    private long updateInterval;

    public QuartzJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("jobID:" + jobExecutionContext.getJobDetail().getJobDataMap().get("id") + "[start!]" + jobExecutionContext.getScheduledFireTime());
        System.out.println(jobExecutionContext.getTrigger().getKey().toString());
        ScheduleTask task = new ScheduleTask();
        task.run();
        System.out.println("jobID:" + jobExecutionContext.getJobDetail().getJobDataMap().get("id") + "[end!]");
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public long getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(long updateInterval) {
        this.updateInterval = updateInterval;
    }

}
