package com.jxd.leave.controller;

import com.jxd.leave.model.Children;
import com.jxd.leave.model.Cleave;
import com.jxd.leave.service.IAdminService;
import com.jxd.leave.service.IChildrenService;
import com.jxd.leave.service.ICleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CleaveController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/31
 * @Version 1.0
 */
@RestController
public class CleaveController {
    @Autowired
    private ICleaveService cleaveService;

    @Autowired
    private IChildrenService childrenService;

    @RequestMapping("/getAllCleave")
    public Map<String, Object> getAllCleave(@RequestBody Map<String,String> map){
        return cleaveService.getAllCleave(map);
    }

    @RequestMapping("/getCleave")
    public Map<String, Object> getCleave(@RequestBody Map<String,String> map){
        return cleaveService.getCleave(map);
    }

    @RequestMapping("/getAdminCleave")
    public Map<String, Object> getAdminCleave(@RequestBody Map<String,String> map){
        return cleaveService.getAdminCleave(map);
    }

    @RequestMapping("/addCleave")
    public String addCleave(@RequestBody Cleave cleave){

        String cname = cleave.getCname();
        Children children = new Children();
        children.setCname(cname);
        int cid = childrenService.selecrCid(children);
        int cno = childrenService.selectCno(cname);

        cleave.setCid(cid);
        cleave.setCno(cno);

        List<Integer> type = cleaveService.selectType(cleave);
        for (int i = 0; i < type.size(); i++) {
            if (type.get(i) == 1){
                return "error2";
            }
        }
        boolean flag = cleaveService.addLeave(cleave);

        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updCleave")
    public String updCleave(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);

        if (state == 2 || state == 3 || state == 4 || state == 5){
            return "error1";
        }


        boolean flag = cleaveService.updLeave(cleave);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/submitLeave")
    public String submitLeave(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);

        if (state == 2 || state == 3 || state == 4|| state == 5){
            return "error1";
        }
        boolean flag = cleaveService.submit(cleave);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/deleteLeave")
    public String deleteLeave(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);

        if (state == 2 || state == 3 || state == 4 || state == 5){
            return "error1";
        }

        boolean isSuccess = cleaveService.deleteLeave(cleave);
        if (isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/agree")
    public String agree(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);
        if (state == 2){
            boolean flag = cleaveService.agree(cleave);
            if (flag){
                return "success";
            }else {
                return "error";
            }
        }else {
            return "error1";
        }
    }

    @RequestMapping("/disagree")
    public String disagree(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);
        if (state == 2){
            return "success";
        }else {
            return "error";
        }

    }

    @RequestMapping("/logoutLeave")
    public String logoutLeave(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);
        if (state == 3){
            boolean flag = cleaveService.logoutLeave(cleave);
            if (flag){
                return "success";
            }else {
                return "error";
            }
        }else {
            return "error1";
        }
    }

    @RequestMapping("/updRefuseReason")
    public String updRefuseReason(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);
        if (state == 2){
            boolean flag = cleaveService.updRefuseReason(cleave);
            if (flag){
                return "success";
            }else {
                return "error";
            }
        }else {
            return "error1";
        }
    }

    @RequestMapping("/add")
    public String add(@RequestBody Cleave cleave){
        Children children = new Children();
        children.setCname(cleave.getCname());
        Integer cid = childrenService.selecrCid(children);
        cleave.setCid(cid);
        List<Integer> type = cleaveService.selectType(cleave);
        for (int i = 0; i < type.size(); i++) {
            if (type.get(i) == 1){
                return "error";
            }
        }
        return "success";
    }

    @RequestMapping("/upd")
    public String upd(@RequestBody Cleave cleave){
        Integer state = cleaveService.selectState(cleave);
        if (state == 2 || state == 3 || state == 4 || state == 5){
            return "error";
        }else {
            return "success";
        }
    }
}
