package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.model.UrlM;

public interface UrlServerI {
    String randomCode();

    UrlM packUrlM(String longUrl);

    UrlM customPackUrlM(String longUrl, String shortUrl);

    int checkShortUrl(String shortUrl);

    int insertUrl(UrlM urlM);

    String searchLongUrl(String shortUrl);
}
