package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.IChildrenDao;
import com.jxd.leave.dao.IUserDao;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import com.jxd.leave.model.User;
import com.jxd.leave.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/27
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public Integer selectRole(User user) {
        return userDao.selectRole(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean delUser(List<Integer> uids, Integer role) {
        return userDao.delUser(uids,role);
    }

    @Override
    public boolean updPassword(Password password) {
        return userDao.updPassword(password);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean resetPassword(List<Integer> uids, Integer role) {
        return userDao.resetPassword(uids,role);
    }
}
