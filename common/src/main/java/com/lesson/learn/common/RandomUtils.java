/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.common;

import java.util.Date;

/**
 * <b><code>RandomUtils</code></b>
 * <p/>
 * RandomUtils
 * <p/>
 * <b>Creation Time:</b> 2016/5/30 11:10.
 *
 * @author lev -gc
 * @version $Revision$ 2016/5/30 11:10.
 * @since LessonLearn 1.0
 */
public class RandomUtils {

    /**
     * Generate a random String (a TimeStamp with some random number).
     *
     * @param length length of random number without TimeStamp.
     * @return a random string.
     */
    public static String generateRandomString(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * 10);
            s.append(number);
        }
        return (new Date()).getTime() + s.toString();
    }

}
