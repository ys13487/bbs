package com.bbs.ys.bbs.service.impl;

import com.bbs.ys.bbs.dao.Role_perDao;
import com.bbs.ys.bbs.empty.Role_per;
import com.bbs.ys.bbs.service.Role_perService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Role_perServiceImpl implements Role_perService {
    @Autowired
    Role_perDao role_perDao;

    @Override
    public List<Role_per> selectPermission(int roleid) {
        return role_perDao.selectPermission(roleid);
    }

    @Override
    public void addPermission(int roleid, int perid) {
        role_perDao.addPermission(roleid,perid);
    }

    @Override
    public void editPermission(int roleid, int preperid, String afterperid) {
        role_perDao.editPermission(roleid,preperid,afterperid);
    }

    @Override
    public void deletePermission(int roleid, int perid) {
        role_perDao.deletePermission(roleid,perid);
    }

    @Override
    public void deleteAll(int roleid) {
        role_perDao.deleteAll(roleid);
    }
}

