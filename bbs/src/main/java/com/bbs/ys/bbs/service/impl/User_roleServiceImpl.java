package com.bbs.ys.bbs.service.impl;

import com.bbs.ys.bbs.dao.User_roleDao;
import com.bbs.ys.bbs.empty.User_role;
import com.bbs.ys.bbs.service.User_roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_roleServiceImpl implements User_roleService {
    @Autowired
    User_roleDao user_roleDao;

    @Override
    public void add(int userid, int roleid) {
        user_roleDao.add(userid,roleid);
    }

    @Override
    public User_role queryByUserId(int userid) {
        return user_roleDao.queryByUserId(userid);
    }

    @Override
    public void update(int userid, int roleid) {
        user_roleDao.update(userid,roleid);
    }

    @Override
    public void delete(int userid) {
        user_roleDao.delete(userid);
    }

    @Override
    public void updateAll(int roleid) {
        user_roleDao.updateAll(roleid);
    }
}

