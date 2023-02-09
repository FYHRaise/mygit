package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Parents;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IParentsDao {
    IPage<Parents> getAllParents(IPage<Parents> page, @Param("pname") String pname, @Param("relationship") String relationship,@Param("cid") Integer cid);

    boolean addParents(Parents parents);
    boolean updParents(Parents parents);
    boolean delParents(List<Integer> pids);

    List<Parents> getParents(Integer cid);
}
