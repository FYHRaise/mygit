package com.jxd.leave.service;

import com.jxd.leave.model.Password;
import com.jxd.leave.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ITeacherService {

    Map<String, Object> getAllTeacher(Map<String,String> map);


    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean delTeacher(List<Integer> tids);
    Integer selecrTid(Teacher teacher);
    Integer selectCno(String tname);

    List<Teacher> getTeacher(Teacher teacher);

    boolean updTeacherPassword(Password password);

    boolean resetTeacher(List<Integer> tids);

}
