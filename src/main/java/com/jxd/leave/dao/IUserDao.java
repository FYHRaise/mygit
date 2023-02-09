package com.jxd.leave.dao;


import com.jxd.leave.model.Password;
import com.jxd.leave.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    boolean login(User user);

    Integer selectRole(User user);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean delUser(@Param("uids") List<Integer> uids,@Param("role") Integer role);

    boolean updPassword(Password password);

    boolean resetPassword(@Param("uids") List<Integer> uids,@Param("role") Integer role);

}
