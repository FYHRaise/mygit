package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Password;
import com.jxd.leave.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITeacherDao {
    IPage<Teacher> getAllTeacher(IPage<Teacher> page, @Param("tname") String tname, @Param("cno") int cno);

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean delTeacher(List<Integer> tids);

    Integer selecrTid(Teacher teacher);

    Integer selectCno(String tname);

    List<Teacher> getTeacher(Teacher teacher);

    boolean updTeacherPassword(Password password);
    boolean resetTeacher(List<Integer> tids);

}
