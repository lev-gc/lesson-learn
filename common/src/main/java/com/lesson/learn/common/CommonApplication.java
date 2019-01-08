/*
 * Copyright (c) 2018. @author lev-gc
 */

package com.lesson.learn.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>CommonApplication</b>
 * <p/>
 * Application of the module Common
 * <p/>
 *
 * @author lev-gc
 * @version 0.1.0
 * @date 2018/7/4 12:14
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
