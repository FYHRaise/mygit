package com.jxd.leave.service;

import com.jxd.leave.model.Parents;

import java.util.List;
import java.util.Map;

public interface IParentsService {
    Map<String, Object> getAllParents(Map<String,String> map);

    boolean addParents(Parents parents);

    boolean updParents(Parents parents);
    boolean delParents(List<Integer> pids);
    List<Parents> getParents(Integer cid);


}
