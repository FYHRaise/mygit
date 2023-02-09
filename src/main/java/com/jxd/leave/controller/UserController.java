package com.jxd.leave.controller;

import com.jxd.leave.model.User;
import com.jxd.leave.service.IChildrenService;
import com.jxd.leave.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/27
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;



    @RequestMapping("/login")
    public String login(@RequestBody User user){
        Integer role = userService.selectRole(user);
        if (role == null){
            return "error";
        }
        boolean flag = userService.login(user);
        if(role == 1 && flag){
            return "success1";
        } else if (role == 2 && flag) {
            return "success2";
        } else if (role == 3 && flag) {
            return "success3";
        }else {
            return "error";
        }
    }
}
