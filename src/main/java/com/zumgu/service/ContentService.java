package com.zumgu.service;

import com.zumgu.model.Content;

/**
 * Created by kanghonggu on 2016-12-05.
 */
public interface ContentService {

    Content getContent(Long id);

    Content getContentByCache(Long id);

    void refreshCache(Long id);
}
