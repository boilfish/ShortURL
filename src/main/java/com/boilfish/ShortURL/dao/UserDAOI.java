package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UserM;

public interface UserDAOI {
    UserM selectUserByUsername(String username);

    void insertUser(UserM user);
}
