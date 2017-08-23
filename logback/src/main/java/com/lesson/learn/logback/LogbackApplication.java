/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.logback;

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
 * @since logback 0.0.1
 */
@SpringBootApplication
public class LogbackApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @since logback 0.0.1
     */
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

}
