package com.jxd.leave.service;

import com.jxd.leave.model.Cleave;

import java.util.List;
import java.util.Map;

public interface ICleaveService {

    Map<String, Object> getAllCleave(Map<String,String> map);

    Map<String, Object> getCleave(Map<String,String> map);

    Map<String, Object> getAdminCleave(Map<String,String> map);


    boolean addLeave(Cleave cleave);
    boolean updLeave(Cleave cleave);
    boolean submit(Cleave cleave);

    Integer selectState(Cleave cleave);

    boolean deleteLeave(Cleave cleave);

    List<Integer> selectType(Cleave cleave);
    boolean agree(Cleave cleave);
    boolean disagree(Cleave cleave);

    boolean logoutLeave(Cleave cleave);

    boolean updRefuseReason(Cleave cleave);
}
