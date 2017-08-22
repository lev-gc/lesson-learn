/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.kaptcha.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * <b><code>KaptchaConfig</code></b>
 * <p/>
 * Kaptcha config.
 * <p/>
 * <b>Creation Time:</b> 2017/8/21 12:04.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@Configuration
public class KaptchaConfig {

    /**
     * Producer default kaptcha.
     *
     * @return the default kaptcha
     * @see com.google.code.kaptcha.Constants
     * @since kaptcha 0.0.1
     */
    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
        properties.put(Constants.KAPTCHA_BORDER, "no");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH, "100");
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(new Config(properties));
        return defaultKaptcha;
    }

}
