package com.jxd.leave.controller;

import com.jxd.leave.model.Class;
import com.jxd.leave.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class ClassController {
    @Autowired
    private IClassService classService;

    @RequestMapping("/geAllClass")
    public List<Class> getAllClass(){
        List<Class> list = classService.getAllClass();
        return list;
    }

    @RequestMapping("/getAllCla")
    public Map<String, Object> getClass(@RequestBody Map<String,String> map){
        return classService.getAllCla(map);
    }

    @RequestMapping("/addClass")
    public String addClass(@RequestBody Class cla){
        if (classService.addClass(cla)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updateClass")
    public String updateClass(@RequestBody Class cla){
        if (classService.updateClass(cla)){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/delClass")
    public String delClass(@RequestBody List<Integer> cnos){
        if (classService.delClass(cnos)){
            return "success";
        }else {
            return "error";
        }
    }

}
