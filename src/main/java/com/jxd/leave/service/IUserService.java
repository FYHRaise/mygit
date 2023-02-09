package com.jxd.leave.service;

import com.jxd.leave.model.Password;
import com.jxd.leave.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IUserService {
    boolean login(User user);
    Integer selectRole(User user);

    boolean addUser(User user);

    boolean delUser(List<Integer> uids,Integer role);

    boolean updPassword(Password password);

    boolean updateUser(User user);

    boolean resetPassword(@Param("uids") List<Integer> uids,@Param("role") Integer role);
}
