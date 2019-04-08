package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;

import java.util.List;
import java.util.Map;

public interface ManageServerI {

    Map<String,Object> getStatistics();

    Map<String,Object> selectUrlByLongURL(String longUrl, int page, int limit);

    Map<String,Object> selectUrlByShortURL(String shotrUrl, int page, int limit);

    Map<String,Object> selecrUserByUser(UserM user, int page, int limit);
}
