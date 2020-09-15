package com.mycompany.myapp.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MapResource controller
 */
@RestController
@RequestMapping("/api/map")
public class MapResource {

    private final Logger log = LoggerFactory.getLogger(MapResource.class);

    /**
    * GET show
    */
    @GetMapping("/show")
    public String show() {

        return "show";

    }

}
