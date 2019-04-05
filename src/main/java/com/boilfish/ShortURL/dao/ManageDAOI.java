package com.boilfish.ShortURL.dao;

import java.util.Date;

public interface ManageDAOI {

    int selectNewUserCount();

    int selectUserCount();

    int selectUrlCount();

    int selectNewUrlCount();
}
