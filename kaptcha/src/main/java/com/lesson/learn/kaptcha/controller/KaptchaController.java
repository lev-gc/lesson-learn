/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.kaptcha.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * <b>KaptchaController</b>
 * <p/>
 * KaptchaController
 * <p/>
 *
 * @author lev-gc
 * @version 0.1.0
 * @date 2017/8/21 11:48
 */
@RestController
public class KaptchaController {

    /**
     * The Producer.
     *
     * @since lesson-learn 0.0.1
     */
    private final Producer producer;

    @Autowired
    public KaptchaController(Producer producer) {
        this.producer = producer;
    }

    /**
     * Gets kaptcha.
     *
     * @return the kaptcha
     * @since lesson-learn 0.0.1
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getKaptcha() {
        try {
            // generate image
            String text = producer.createText();
            BufferedImage image = producer.createImage(text);

            // transform to byte
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", stream);
            byte[] result = stream.toByteArray();

            // modify header of response
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.IMAGE_JPEG);
            header.setCacheControl("no-store, no-cache");

            return new ResponseEntity<>(result, header, HttpStatus.OK);
        } catch (Throwable t) {
            // TODO: exception handler
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
