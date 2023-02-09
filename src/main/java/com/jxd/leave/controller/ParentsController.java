package com.jxd.leave.controller;

import com.jxd.leave.model.Children;
import com.jxd.leave.model.Parents;
import com.jxd.leave.service.IChildrenService;
import com.jxd.leave.service.IParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ParentsController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/2/1
 * @Version 1.0
 */
@RestController
public class ParentsController {
    @Autowired
    private IParentsService parentsService;
    @Autowired
    private IChildrenService childrenService;

    @RequestMapping("/getAllParents")
    public Map<String,Object> getAllParents(@RequestBody Map<String,String> map){
        return parentsService.getAllParents(map);
    }

    @RequestMapping("/addParents")
    public String addParents(@RequestBody Parents parents){
        Children children = new Children();
        children.setCname(parents.getCname());
        int cid = childrenService.selecrCid(children);
        parents.setCid(cid);
        boolean flag = parentsService.addParents(parents);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updParents")
    public String updParents(@RequestBody Parents parents){
        Children children = new Children();
        children.setCname(parents.getCname());
        int cid = childrenService.selecrCid(children);
        parents.setCid(cid);
        boolean flag = parentsService.updParents(parents);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/delParents")
    public String delParents(@RequestBody List<Integer> pids){
        boolean flag = parentsService.delParents(pids);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/getParents")
    public List<Parents> getParents(@RequestBody Map<String,String> map){
        Children children = new Children();
        children.setCname(map.get("uname"));
        int cid = childrenService.selecrCid(children);
        List<Parents> list = parentsService.getParents(cid);
        return list;
    }
}
