package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Class;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClassDao {

    List<Class> getAllClass();

    IPage<Class> getAllCla(IPage<Class> page, @Param("clname") String clname);

    boolean addClass(Class cla);

    boolean updateClass(Class cla);

    boolean delClass(List<Integer> cnos);
}
