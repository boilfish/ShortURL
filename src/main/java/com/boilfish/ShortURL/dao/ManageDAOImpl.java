package com.boilfish.ShortURL.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

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

}
