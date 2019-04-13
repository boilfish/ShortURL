package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.dao.UrlDAOI;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;


@Service("UrlServer")
public class UrlServerImpl implements UrlServerI {

    @Autowired
    private UrlDAOI UrlDAO;

    //发号器
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
    public UrlM packUrlM(String longUrl, HttpSession session){
        UrlM tempUrl = new UrlM();
        UserM user=(UserM) session.getAttribute("currUser");
        if(user == null) {
            //System.out.println("pack未登录");
            tempUrl.setUserId(0);
        }else {
            //System.out.println("pack已登录");
            tempUrl.setUserId(user.getId());
        }
        tempUrl.setShortUrl(randomCode());

        while (checkShortUrl(tempUrl.getShortUrl()) != 0){
            tempUrl.setShortUrl(randomCode());
        }

        tempUrl.setLongUrl(longUrl);

        tempUrl.setTimeStamp(new Date());//获取当前系统时间
        return tempUrl;
    }

    @Override
    public UrlM customPackUrlM(String longUrl,String shortUrl, HttpSession session){
        UrlM tempUrl = new UrlM();

        tempUrl.setShortUrl(shortUrl);

        UserM user=(UserM) session.getAttribute("currUser");
        if(user == null) {
            tempUrl.setUserId(0);
        }else {
            tempUrl.setUserId(user.getId());
        }

        if (checkShortUrl(shortUrl) != 0){
            return null;//校检用户输入的url是否重复，重复返回空
        }else {
            tempUrl.setLongUrl(longUrl);
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
