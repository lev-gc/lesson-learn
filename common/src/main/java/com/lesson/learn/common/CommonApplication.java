/*
 * Copyright (c) 2018. @author lev-gc
 */

package com.lesson.learn.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>CommonApplication</code></b>
 * <p/>
 * Application of the module Common
 * <p/>
 * <b>Creation Time:</b> 2018/7/4 12:14.
 *
 * @author Elvis
 * @since common 0.1.0
 */
@SpringBootApplication
public class CommonApplication {

    /**
     * The constant LOG.
     */
    private final static Logger LOG = LoggerFactory.getLogger(CommonApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOG.info("Application Start!");
        SpringApplication.run(CommonApplication.class, args);
    }

}
