package com.boilfish.ShortURL.dao;

import com.boilfish.ShortURL.controller.UserController;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("ManageDAO")
public class ManageDAOImpl implements ManageDAOI {

    @Override
    public int selectNewUserCount(){
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

        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectNewUserCount");
        sqlSession.close();
        return count;
    }

    @Override
    public int selectUserCount(){
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

        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectUserCount");
        sqlSession.close();
        return count;
    }

    @Override
    public int selectUrlCount(){
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

        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectUrlCount");
        sqlSession.close();
        return count;
    }

    @Override
    public int selectNewUrlCount(){
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

        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectNewUrlCount");
        sqlSession.close();
        return count;
    }

    @Override
    public Map<String,Object> selectUrlByLongURL(String longUrl, int page, int limit){
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

        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map1.put("longUrl",longUrl);
        map1.put("page",page);
        map1.put("limit",limit);


        List<UrlM> urlList = sqlSession.selectList("com.boilfish.ShortURL.mapper.ManageMapper.selectUrlByUrl",map1);
        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectUrlByUrlCount",map1);
        sqlSession.close();
        map2.put("urlList",urlList);
        map2.put("count",count);
        return map2;
    }

    @Override
    public Map<String,Object> selectUrlByShortURL(String shortUrl, int page, int limit){
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

        //带分页的就得返回map
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map1.put("shortUrl",shortUrl);
        map1.put("page",page);
        map1.put("limit",limit);

        List<UrlM> urlList = sqlSession.selectList("com.boilfish.ShortURL.mapper.ManageMapper.selectUrlByUrl",map1);
        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectUrlByUrlCount",map1);
        sqlSession.close();
        map2.put("urlList",urlList);
        map2.put("count",count);
        return map2;
    }

    @Override
    public Map<String,Object> selecrUserByUser(UserM user,int page,int limit){
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

        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();

        map1.put("data",user);
        map1.put("page",page);
        map1.put("limit",limit);

        List<UrlM> userList = sqlSession.selectList("com.boilfish.ShortURL.mapper.ManageMapper.selectUserByUserM",map1);
        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.ManageMapper.selectUserCountByUserM",map1);

        sqlSession.close();
        map2.put("userList",userList);
        map2.put("count",count);
        return map2;
    }

}
