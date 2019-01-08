/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>LogbackApplication</b>
 * <p/>
 * Application of Logback
 * <p/>
 *
 * @author lev-gc
 * @version 0.1.0
 * @date 2017/8/23 14:03
 */
@SpringBootApplication
public class LogbackApplication {

    /**
     * The constant LOG.
     */
    private final static Logger LOG = LoggerFactory.getLogger(LogbackApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOG.info("Application Start!");
        SpringApplication.run(LogbackApplication.class, args);
    }

}
