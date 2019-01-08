/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.kaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>KaptchaApplication</b>
 * <p/>
 * Application of Kaptcha
 * <p/>
 *
 * @author lev-gc
 * @version 0.1.0
 * @date 2017/8/21 10:18
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
