/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

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

    /**
     * Execute.
     *
     * @param jobExecutionContext the job execution context
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // TODO: you can get something you need from JobDataMap by JobExecutionContext
        ScheduleTask task = new ScheduleTask();
        task.run();
    }

}
