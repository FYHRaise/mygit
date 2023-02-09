package com.jxd.leave.service;

import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IChildrenService {
    Map<String, Object> getAllChildren(Map<String,String> map);
    Map<String, Object> getChildren(Map<String,String> map);

    boolean addChildren(Children children);

    Children selectChildren(String cid);

    boolean updateChildren(Children children);

    boolean delChildren(List<Integer> cids);
    Integer selecrCid(Children children);

    Integer selectCno(String cname);

    List<Children> getChild(Children children);
    boolean updChildPassword(Password password);

    boolean addPicture(String newName,Integer cid);

    boolean updChild(Children children);

    String selectImg(Integer cid);
    boolean resetPassword(List<Integer> cids);

}
