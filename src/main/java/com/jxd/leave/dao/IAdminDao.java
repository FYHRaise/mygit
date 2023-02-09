package com.jxd.leave.dao;

import com.jxd.leave.model.Admin;
import com.jxd.leave.model.Password;

import java.util.List;

public interface IAdminDao {
    List<Admin> selectAdmin(String aname);

    boolean updAdmin(Admin admin);

    boolean updPassword(Password password);
}
