package com.zumgu.controller;

import com.zumgu.model.Content;
import com.zumgu.service.ContentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kanghonggu on 2016-12-05.
 */
@RestController
@RequestMapping("/api/v1/contents")
public class APIController {

    private static Logger logger = LoggerFactory.getLogger(APIController.class);

    @Autowired
    ContentService contentService;

    @GetMapping("/{id}")
    public Content getConetent (@PathVariable Long id) {

        logger.info("GET CONTENT : " + id + " Time : " + System.currentTimeMillis());

        return contentService.getContent(id);
    }

    @GetMapping("/cache/{id}")
    public Content getConetentByCache (@PathVariable Long id) {

        logger.info("GET CONTENT BY CACHE: " + id + " Time : " + System.currentTimeMillis());

        return contentService.getContentByCache(id);
    }

    @GetMapping("/refresh/{id}")
    public String refreshConetentByCache (@PathVariable Long id) {
        contentService.refreshCache(id);

        return "Cache Clear : " + id;
    }

}
