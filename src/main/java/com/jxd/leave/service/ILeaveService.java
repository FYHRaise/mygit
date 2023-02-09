package com.jxd.leave.service;

import com.jxd.leave.model.Leave;

import java.util.List;
import java.util.Map;

public interface ILeaveService {
    List<Leave> getAllLeaveType();

    Map<String, Object> getAllLeave(Map<String,String> map);

    boolean addLeave(Leave leave);

    boolean updateLeave(Leave leave);

    boolean delLeave(List<Integer> lids);

}
