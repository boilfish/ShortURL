package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.model.UrlM;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

@Repository("UrlDAO")
public class UrlDAOImpl implements UrlDAOI{
    @Override
    public int insertUrl(UrlM urlM) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("com.boilfish.ShortURL.mapper.UrlMapper.insertUrl",urlM);
       // System.out.println(urlM.getId());
        sqlSession.commit();
        sqlSession.close();
        return urlM.getId();
    }

    @Override
    public String searchLongUrl(String shortUrl){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UrlM tempurl = new UrlM();
        tempurl.setShortUrl(shortUrl);
        System.out.println(tempurl.toString());
        UrlM url = sqlSession.selectOne("com.boilfish.ShortURL.mapper.UrlMapper.searchUrl",tempurl);
        sqlSession.close();
        if(url == null){
            return null;
        }else return url.getLongUrl();

    }
    @Override
    public int checkShortUrl (String shortUrl){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int temp = sqlSession.selectOne("com.boilfish.ShortURL.mapper.UrlMapper.checkShortUrl",shortUrl);
        sqlSession.close();
        return temp;
    }
}
