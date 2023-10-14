package com.example.dp_spring_backend.controller;


import com.example.dp_spring_backend.domain.entity.ObdReading;
import com.example.dp_spring_backend.service.ObdReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/obd")
public class ObdReadingController {

    private static final Logger log = LoggerFactory.
            getLogger(ObdReadingController.class);
    private static final String DEFAULT_PAGE_NUM = "0";
    private static final String DEFAULT_PAGE_SIZE = "100";

    @Autowired
    private ObdReadingService obdReadingService;

    @RequestMapping(method = GET)
    Page<ObdReading> page(
            @RequestParam(value = "vin", required = true) final String vin,
            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUM) final Integer page,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) final Integer size) {
        return obdReadingService.getAllReadingsFromVin(vin, page, size);
    }

    @RequestMapping(method = POST)
    void add(@RequestBody final ObdReading reading) {
        obdReadingService.createReading(reading);
    }

}
