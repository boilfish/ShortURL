package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.dao.UserDAOI;
import com.boilfish.ShortURL.model.UrlM;
import com.boilfish.ShortURL.model.UserM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("UserServer")
public class UserServerImpl implements UserServerI {

    @Autowired
    private UserDAOI userDAO;

    //返回1成功，2用户名不存在，3密码错误
    @Override
    public HashMap loginAuth(UserM user){
        UserM tempUser = userDAO.selectUserByUsername(user.getName());
        HashMap map = new HashMap();
        int authStateCode=0;
        if(tempUser == null) authStateCode=2;
        if(tempUser.getPasswd().equals(user.getPasswd())){
            authStateCode=1;
        }else
            authStateCode=3;
        map.put("authStateCode",new Integer(authStateCode));
        map.put("currUser",tempUser);
        return map;
    }

    @Override
    public int registerCheckUser(String username){
        UserM tempUser = userDAO.selectUserByUsername(username);
        if(tempUser == null) return 1;
        else return 0;
    }

//    @Override
//    public UserM registerPackUser(String username, String passwd, String mail){
//        UserM tempUser = new UserM();
//        tempUser.setName(username);
//        tempUser.setPasswd(passwd);
//        tempUser.setMail(mail);
//        tempUser.setTimeStamp(new Date());
//        return tempUser;
//    }

    @Override
    public void registUser(UserM user){
        user.setTimeStamp(new Date());
        userDAO.insertUser(user);
    }

    @Override
    public List<UrlM> selectUrlByUser (UserM user) {return userDAO.selectUrlByUser(user);}

    @Override
    public void deleteUrlById(UrlM url){
        userDAO.delUrlById(url);
    }

}
