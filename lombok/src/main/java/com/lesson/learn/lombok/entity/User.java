/*
 * Copyright (c) 2018. @author lev-gc
 */

package com.lesson.learn.lombok.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <b><code>User</code></b>
 * <p/>
 * User
 * <p/>
 * <b>Creation Time:</b> 2018/7/5 16:32.
 *
 * @author Elvis
 * @since lombok 0.1.0
 */
//@Data // include @ToString,@EqualsAndHashCode,@Getter on all fields,@Setter on all non-final fields,@RequiredArgsConstructor
@Getter // on all non-static fields
@Setter // on all non-static and non-final fields
//@ToString // generate a toString
//@Slf4j // private static final org.slf4j.Logger [fieldName] = org.slf4j.LoggerFactory.getLogger(LogExample.class);
public class User implements Serializable {

    private String id;
    private String name;
    private int age;

    // then we can use the getter and setter methods of this class after add the Annotation @Getter and @Setter
}
