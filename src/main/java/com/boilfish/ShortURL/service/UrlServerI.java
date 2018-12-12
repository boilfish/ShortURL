package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.model.UrlM;

import javax.servlet.http.HttpSession;

public interface UrlServerI {
    String randomCode();

    UrlM packUrlM(String longUrl, HttpSession session);

    UrlM customPackUrlM(String longUrl, String shortUrl, HttpSession session);

    int checkShortUrl(String shortUrl);

    int insertUrl(UrlM urlM);

    String searchLongUrl(String shortUrl);
}
