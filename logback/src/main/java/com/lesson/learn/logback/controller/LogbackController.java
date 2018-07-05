/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>LogbackController</code></b>
 * <p/>
 * LogbackController
 * <p/>
 * <b>Creation Time:</b> 2017/8/23 16:45.
 *
 * @author Elvis
 * @since logback 0.1.0
 */
@RestController
public class LogbackController {

    /**
     * The constant LOG.
     */
    private final static Logger LOG = LoggerFactory.getLogger(LogbackController.class);

    /**
     * To log something response entity.
     *
     * @return the response entity
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> toLogSomething() {
        try {
            LOG.debug("LOG DEBUG");
            LOG.info("LOG INFO");
            LOG.warn("LOG WARN");
            LOG.error("LOG ERROR");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            // TODO: exception handler
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
