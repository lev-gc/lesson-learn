/*
 * Copyright (c) 2018. @author lev-gc
 */

package com.lesson.learn.lombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>LombokApplication</code></b>
 * <p/>
 * Application of Lombok
 * <p/>
 * <b>Creation Time:</b> 2018/7/4 12:14.
 *
 * @author lev-gc
 * @since lombok 0.1.0
 */
@SpringBootApplication
public class LombokApplication {

    /**
     * The constant LOG.
     */
    private final static Logger LOG = LoggerFactory.getLogger(LombokApplication.class);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOG.info("Application Start!");
        SpringApplication.run(LombokApplication.class, args);
    }

}
