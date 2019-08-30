package com.bbs.ys.bbs.service.impl;


import com.bbs.ys.bbs.dao.RoleDao;
import com.bbs.ys.bbs.empty.Role;
import com.bbs.ys.bbs.service.RoleService;
import com.bbs.ys.bbs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> selectAllRole() {
        return roleDao.selectAllRole();
    }

    @Override
    public List<Role> selectAllRoleByPage(int page) {
        return roleDao.selectAllRoleByPage(page);
    }

    @Override
    public Role selectRoleById(int id) {
        return roleDao.selectRoleById(id);
    }

    @Override
    public void addRole(String role, int level) {
        roleDao.addRole(role,level);
    }

    @Override
    public void editRole(int id, String role, int level) {
        roleDao.editRole(id,role,level);
    }

    @Override
    public void deleteRole(int id) {
        roleDao.deleteRole(id);
    }
}

