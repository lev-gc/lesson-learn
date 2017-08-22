/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.kaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>Application</code></b>
 * <p/>
 * Application of Kaptcha
 * <p/>
 * <b>Creation Time:</b> 2017/8/21 10:18.
 *
 * @author Elvis
 * @since kaptcha 0.0.1
 */
@SpringBootApplication
public class KaptchaApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(KaptchaApplication.class, args);
    }

}
