package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.dao.ManageDAOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("ManageServer")
public class ManageServerImpl implements ManageServerI {

    @Autowired
    private ManageDAOI manageDAO;

    @Override
    public Map<String,Object> getStatistics(){
        Map<String,Object> map = new HashMap<>();
        map.put("regNum",manageDAO.selectUserCount());
        map.put("urlNum",manageDAO.selectUrlCount());
        map.put("tdNewUrl",manageDAO.selectNewUrlCount());
        map.put("tdNewUser",manageDAO.selectNewUserCount());
        return map;
    }
}
