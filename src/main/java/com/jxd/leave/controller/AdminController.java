package com.jxd.leave.controller;

import com.jxd.leave.model.Admin;
import com.jxd.leave.model.Password;
import com.jxd.leave.service.IAdminService;
import com.jxd.leave.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/30
 * @Version 1.0
 */
@RestController
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/getAdmin")
    public List<Admin> getAdmin(@RequestBody Admin admin){
        String aname = admin.getAname();
        List<Admin> list = adminService.selectAdmin(aname);
        return list;
    }

    @RequestMapping("/updAdmin")
    public String updAdmin(@RequestBody Admin admin){
        boolean flag = adminService.updAdmin(admin);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updPassword")
    public String updPassword(@RequestBody Password password){
        boolean flag = adminService.updPassword(password);
        password.setRole(1);
        boolean isSuccess = userService.updPassword(password);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }
}
