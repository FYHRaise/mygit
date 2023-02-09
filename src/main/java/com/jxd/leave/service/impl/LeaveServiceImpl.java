package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.ILeaveDao;
import com.jxd.leave.model.Class;
import com.jxd.leave.model.Leave;
import com.jxd.leave.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LeaveServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
@Service
public class LeaveServiceImpl implements ILeaveService {
    @Autowired
    private ILeaveDao leaveDao;

    @Override
    public List<Leave> getAllLeaveType() {
        return leaveDao.getAllLeaveType();
    }

    @Override
    public Map<String, Object> getAllLeave(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String lname = map.get("lname");

        Map<String,Object> map1 = new HashMap(3);
        if (page != null && limit != null){
            IPage<Leave> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Leave> pageRes = leaveDao.getAllLeave(page1,lname);
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
    public boolean addLeave(Leave leave) {
        return leaveDao.addLeave(leave);
    }

    @Override
    public boolean updateLeave(Leave leave) {
        return leaveDao.updateLeave(leave);
    }

    @Override
    public boolean delLeave(List<Integer> lids) {
        return leaveDao.delLeave(lids);
    }
}
