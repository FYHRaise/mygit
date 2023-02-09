package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.ITeacherDao;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import com.jxd.leave.model.Teacher;
import com.jxd.leave.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;

    @Override
    public Map<String, Object> getAllTeacher(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String tname = map.get("tname");
        String cnos = map.get("cno");
        int cno = 0;
        if (!"".equals(cnos)){
            cno = Integer.parseInt(cnos);
        }

        Map<String,Object> map1 = new HashMap(4);
        if (page != null && limit != null){
            IPage<Teacher> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Teacher> pageRes = teacherDao.getAllTeacher(page1,tname,cno);
            map1.put("count",pageRes.getTotal());
            map1.put("data",pageRes.getRecords());
            map1.put("code",0);
            return map1;
        }else {
            map1.put("data",(Object)null);
            map1.put("code","500");
            map1.put("msg","参数不符");
            map1.put("count",(Object)null);
            return map1;
        }
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public boolean delTeacher(List<Integer> tids) {
        return teacherDao.delTeacher(tids);
    }

    @Override
    public Integer selecrTid(Teacher teacher) {
        return teacherDao.selecrTid(teacher);
    }

    @Override
    public Integer selectCno(String tname) {
        return teacherDao.selectCno(tname);
    }

    @Override
    public List<Teacher> getTeacher(Teacher teacher) {
        return teacherDao.getTeacher(teacher);
    }

    @Override
    public boolean updTeacherPassword(Password password) {
        return teacherDao.updTeacherPassword(password);
    }

    @Override
    public boolean resetTeacher(List<Integer> tids) {
        return teacherDao.resetTeacher(tids);
    }
}
