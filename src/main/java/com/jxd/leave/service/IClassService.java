package com.jxd.leave.service;

import com.jxd.leave.model.Class;

import java.util.List;
import java.util.Map;

public interface IClassService {
    List<Class> getAllClass();

    Map<String, Object> getAllCla(Map<String,String> map);

    boolean addClass(Class cla);

    boolean updateClass(Class cla);

    boolean delClass(List<Integer> cnos);

}
