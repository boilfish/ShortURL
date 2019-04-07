package com.boilfish.ShortURL.service;

import com.boilfish.ShortURL.dao.ManageDAOI;
import com.boilfish.ShortURL.model.UrlM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String,Object> selectUrlByLongURL(String longUrl, int page, int limit){return manageDAO.selectUrlByLongURL(longUrl,page,limit);}

    @Override
    public Map<String,Object> selectUrlByShortURL(String shortUrl, int page, int limit){return manageDAO.selectUrlByShortURL(shortUrl,page,limit);}
}
