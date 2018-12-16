package com.boilfish.ShortURL.dao;

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

@Repository("UserDAO")
public class UserDAOImpl implements UserDAOI{

    @Override
    public UserM selectUserByUsername(String username){
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

        UserM tempUser = new UserM();
        tempUser.setName(username);
        UserM user = sqlSession.selectOne("com.boilfish.ShortURL.mapper.UserMapper.selectUser",tempUser);
        sqlSession.close();
        return user;
    }

    @Override
    public void insertUser(UserM user){
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

        sqlSession.insert("com.boilfish.ShortURL.mapper.UserMapper.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<UrlM> selectUrlByUser(UserM user, int page, int limit){
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

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",user.getId());
        map.put("page",page);
        map.put("limit",limit);

        List<UrlM> urlList = sqlSession.selectList("com.boilfish.ShortURL.mapper.UserMapper.selectUrlByUser",map);
        sqlSession.close();
        return urlList;
    }

    @Override
    public int selectUrlCountByUser(UserM user){
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

        int count = sqlSession.selectOne("com.boilfish.ShortURL.mapper.UserMapper.selectUrlCountByUser",user);
        sqlSession.close();
        return count;
    }

    @Override
    public void delUrlById(UrlM url){
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

        sqlSession.delete("com.boilfish.ShortURL.mapper.UserMapper.deleteUrlById",url);
        sqlSession.commit();
        sqlSession.close();
    }
}
