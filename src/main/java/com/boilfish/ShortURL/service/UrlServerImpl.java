package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.dao.UrlDAOI;
import com.boilfish.ShortURL.model.UrlM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;


@Service("UrlServer")
public class UrlServerImpl implements UrlServerI {

    @Autowired
    private UrlDAOI UrlDAO;

    @Override
    public String randomCode(){
        StringBuffer s = new StringBuffer();
        Random random = new Random();
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        int N = alphabet.length();
        for(int i=0;i<6;i++){
            s.append(alphabet.charAt(random.nextInt(N)));
        }
        return s.toString();
    }

    @Override
    public UrlM packUrlM(String longUrl){
        UrlM tempUrl = new UrlM();

        tempUrl.setShortUrl(randomCode());

        while (checkShortUrl(tempUrl.getShortUrl()) != 0){
            tempUrl.setShortUrl(randomCode());
        }

        tempUrl.setLongUrl(longUrl);
        tempUrl.setUserId(0);
        tempUrl.setTimeStamp(new Date());
        return tempUrl;
    }

    @Override
    public UrlM customPackUrlM(String longUrl,String shortUrl){
        UrlM tempUrl = new UrlM();

        tempUrl.setShortUrl(shortUrl);
        System.out.println(shortUrl);
        System.out.println(checkShortUrl(shortUrl));
        System.out.println("-----------");
        if (checkShortUrl(shortUrl) != 0){
            return null;//校检用户输入的url是否重复，重复返回空
        }else {
            tempUrl.setLongUrl(longUrl);
            tempUrl.setUserId(0);
            tempUrl.setTimeStamp(new Date());
            return tempUrl;
        }
    }

    @Override
    public int checkShortUrl (String shortUrl){return UrlDAO.checkShortUrl(shortUrl);}

    @Override
    public int insertUrl(UrlM urlM){
        return UrlDAO.insertUrl(urlM);
    }

    @Override
    public String searchLongUrl(String shortUrl){return UrlDAO.searchLongUrl(shortUrl);}
}
