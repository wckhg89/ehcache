package com.zumgu.service.impl;

import com.zumgu.model.Content;
import com.zumgu.repository.ContentRepository;
import com.zumgu.service.ContentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kanghonggu on 2016-12-05.
 */
@Service
@EnableCaching
@Transactional
public class ContentServiceImpl implements ContentService{

    private static Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    @Autowired
    ContentRepository contentRepository;

    @Override
    public Content getContent(Long id) {
        return contentRepository.findOne(id);

    }

    @Override
    @Cacheable(value="getContentByCache", key="#id")
    public Content getContentByCache(Long id) {
        return contentRepository.findOne(id);
    }

    @CacheEvict(value = "getContentByCache", key="#id")
    public void refreshCache(Long id) {
        logger.info("CACHE CLEAR OF " + id);
    }
}
