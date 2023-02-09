package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Class;
import com.jxd.leave.model.Leave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILeaveDao {
    List<Leave> getAllLeaveType();

    IPage<Leave> getAllLeave(IPage<Leave> page, @Param("lname") String lname);

    boolean addLeave(Leave leave);

    boolean updateLeave(Leave leave);

    boolean delLeave(List<Integer> lids);
}
