package com.jxd.leave.controller;

import com.jxd.leave.model.Class;
import com.jxd.leave.model.Leave;
import com.jxd.leave.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LeaveController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
@RestController
public class LeaveController {
    @Autowired
    private ILeaveService leaveService;

    @RequestMapping("/getAllLeaveType")
    public List<Leave> getAllClass(){
        List<Leave> list = leaveService.getAllLeaveType();
        return list;
    }

    @RequestMapping("/getAllLeave")
    public Map<String, Object> getLeave(@RequestBody Map<String,String> map){
        return leaveService.getAllLeave(map);
    }

    @RequestMapping("/addLeave")
    public String addLeave(@RequestBody Leave leave){
        if (leaveService.addLeave(leave)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updateLeave")
    public String updateLeave(@RequestBody Leave leave){
        if (leaveService.updateLeave(leave)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/delLeave")
    public String delLeave(@RequestBody List<Integer> lids){
        if (leaveService.delLeave(lids)){
            return "success";
        }else {
            return "error";
        }
    }
}
