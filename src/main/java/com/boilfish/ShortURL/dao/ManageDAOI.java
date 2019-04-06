package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UrlM;

import java.util.Date;
import java.util.List;

public interface ManageDAOI {

    int selectNewUserCount();

    int selectUserCount();

    int selectUrlCount();

    int selectNewUrlCount();

    List<UrlM> selectUrlByLongURL(String longUrl);
}
