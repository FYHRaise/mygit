package com.jxd.leave.service.impl;

import com.jxd.leave.dao.IAdminDao;
import com.jxd.leave.model.Admin;
import com.jxd.leave.model.Password;
import com.jxd.leave.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/30
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Override
    public List<Admin> selectAdmin(String aname) {
        return adminDao.selectAdmin(aname);
    }

    @Override
    public boolean updAdmin(Admin admin) {
        return adminDao.updAdmin(admin);
    }

    @Override
    public boolean updPassword(Password password) {
        return adminDao.updPassword(password);
    }
}
