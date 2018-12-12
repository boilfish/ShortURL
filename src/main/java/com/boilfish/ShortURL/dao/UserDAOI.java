package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;

import java.util.List;

public interface UserDAOI {
    UserM selectUserByUsername(String username);

    void insertUser(UserM user);

    List<UrlM> selectUrlByUser(UserM user);

    void delUrlById(UrlM url);
}
