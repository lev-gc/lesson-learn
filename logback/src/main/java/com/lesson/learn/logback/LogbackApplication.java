/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>LogbackApplication</code></b>
 * <p/>
 * Application of Logback
 * <p/>
 * <b>Creation Time:</b> 2017/8/23 14:03.
 *
 * @author Elvis
 * @since logback 0.1.0
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
