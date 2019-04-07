package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UrlM;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManageDAOI {

    int selectNewUserCount();

    int selectUserCount();

    int selectUrlCount();

    int selectNewUrlCount();

    Map<String,Object> selectUrlByLongURL(String longUrl, int page, int limit);

    Map<String,Object> selectUrlByShortURL(String shortUrl, int page, int limit);
}
