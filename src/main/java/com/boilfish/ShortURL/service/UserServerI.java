package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.model.UserM;

import java.util.HashMap;

public interface UserServerI {
    //返回1成功，2用户名不存在，3密码错误
    HashMap loginAuth(UserM user);

    int registerCheckUser(String username);

    void registUser(UserM user);
}
