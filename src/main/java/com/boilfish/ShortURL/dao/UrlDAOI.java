package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UrlM;

import java.io.IOException;

public interface UrlDAOI {
    int insertUrl(UrlM urlM);

    String searchLongUrl(String shortUrl);

    int checkShortUrl(String shortUrl);
}
