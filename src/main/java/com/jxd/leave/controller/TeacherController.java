package com.jxd.leave.controller;

import com.jxd.leave.model.Password;
import com.jxd.leave.model.Teacher;
import com.jxd.leave.model.User;
import com.jxd.leave.service.ITeacherService;
import com.jxd.leave.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
@RestController
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IUserService userService;


    @RequestMapping("/getTeacher")
    public Map<String, Object> getTeacher(@RequestBody Map<String,String> map){
        return teacherService.getAllTeacher(map);
    }

    @RequestMapping("/addTeacher")
    @Transactional
    public String addTeacher(@RequestBody Teacher teacher){
        boolean flag = teacherService.addTeacher(teacher);
        int peopleid = teacherService.selecrTid(teacher);
        User user = new User(null,teacher.getTname(),teacher.getPwd(),2,peopleid);
        boolean isSuccess = userService.addUser(user);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updateTeacher")
    @Transactional
    public String updateTeacher(@RequestBody Teacher teacher){
        boolean flag = teacherService.updateTeacher(teacher);
        User user = new User();
        user.setUname(teacher.getTname());
        user.setRole(2);
        Integer id = teacherService.selecrTid(teacher);
        user.setPeopleid(id);
        boolean isSuccess = userService.updateUser(user);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/delTeacher")
    @Transactional
    public String delTeacher(@RequestBody List<Integer> tids){
        boolean flag = teacherService.delTeacher(tids);
        List<Integer> uids = tids;
        boolean isSuccess = userService.delUser(uids,2);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/getTea")
    public List<Teacher> getTeacher(@RequestBody Teacher teacher){
        List<Teacher> list = teacherService.getTeacher(teacher);
        return list;
    }

    @RequestMapping("/updTeacherPassword")
    @Transactional
    public String updTeacherPassword(@RequestBody Password password){
        boolean flag = teacherService.updTeacherPassword(password);
        password.setRole(2);
        boolean isSuccess = userService.updPassword(password);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/resetTeacherPassword")
    @Transactional
    public String resetTeacherPassword(@RequestBody List<Integer> tids){
        boolean flag = teacherService.resetTeacher(tids);
        List<Integer> uids = tids;
        boolean isSuccess = userService.resetPassword(uids,2);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }
}
