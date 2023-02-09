package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.IClassDao;
import com.jxd.leave.model.Class;
import com.jxd.leave.model.Teacher;
import com.jxd.leave.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;

    @Override
    public List<Class> getAllClass() {
        return classDao.getAllClass();
    }

    @Override
    public Map<String, Object> getAllCla(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String clname = map.get("clname");

        Map<String,Object> map1 = new HashMap(3);
        if (page != null && limit != null){
            IPage<Class> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Class> pageRes = classDao.getAllCla(page1,clname);
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
    public boolean addClass(Class cla) {
        return classDao.addClass(cla);
    }

    @Override
    public boolean updateClass(Class cla) {
        return classDao.updateClass(cla);
    }

    @Override
    public boolean delClass(List<Integer> cnos) {
        return classDao.delClass(cnos);
    }
}
