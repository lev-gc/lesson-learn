/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.swaggerui.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>SwaggerUITemplateController</code></b>
 * <p/>
 * SwaggerUI Controller
 * <p/>
 * <b>Creation Time:</b> 2017/11/17 12:11.
 *
 * @author Elvis
 * @since lesson-learn 0.0.1
 */
@RestController
@Api(tags = "SwaggerUI", description = "SwaggerUI Template.")
public class SwaggerUITemplateController {

    /**
     * Template method response entity.
     *
     * @param param the param
     * @return the response entity
     */
    @RequestMapping(value = "/swagger", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Description of Method", notes = "Detail.", tags = "SwaggerUI")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success request"),
            @ApiResponse(code = 500, message = "internal server error")})
    public ResponseEntity<?> templateMethod(
            @ApiParam(value = "Description of parameter", required = true) @RequestParam String param) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>(t, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
