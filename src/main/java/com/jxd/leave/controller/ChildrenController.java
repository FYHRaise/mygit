package com.jxd.leave.controller;

import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import com.jxd.leave.model.User;
import com.jxd.leave.service.IChildrenService;
import com.jxd.leave.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName ChildrenController
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@RestController
public class ChildrenController {
    @Autowired
    private IChildrenService childrenService;
    @Autowired
    private IUserService userService;
    @Value("${file.address}")
    String address;

    @RequestMapping("/getChildren")
    public Map<String, Object> getChildren(@RequestBody Map<String,String> map){
        return childrenService.getAllChildren(map);
    }

    @RequestMapping("/getNotAllChildren")
    public Map<String, Object> getNotAllChildren(@RequestBody Map<String,String> map){
        return childrenService.getChildren(map);
    }

    @RequestMapping("/addChildren")
    @Transactional
    public String addChildren(@RequestBody Children children){
        boolean flag = childrenService.addChildren(children);
        int peopleid = childrenService.selecrCid(children);
        User user = new User(null,children.getCname(),children.getPwd(),3,peopleid);
        boolean isSuccess = userService.addUser(user);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updateChildren")
    @Transactional
    public String updateChildren(@RequestBody Children children){
        boolean flag = childrenService.updateChildren(children);
        User user = new User();
        user.setUname(children.getCname());
        user.setRole(3);
        Integer id = childrenService.selecrCid(children);
        user.setPeopleid(id);
        boolean isSuccess = userService.updateUser(user);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/delChildren")
    @Transactional
    public String delChildren(@RequestBody List<Integer> cids){
        boolean flag = childrenService.delChildren(cids);
        List<Integer> uids = cids;
        boolean isSuccess = userService.delUser(uids,3);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/getChild")
    public List<Children> getChild(@RequestBody Children children){

        List<Children> list = childrenService.getChild(children);
        return childrenService.getChild(children);
    }

    @RequestMapping("/updChild")
    public String updChild(@RequestBody Children children){
        boolean flag = childrenService.updChild(children);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping("/updChildPassword")
    @Transactional
    public String updChildPassword(@RequestBody Password password){
        boolean flag = childrenService.updChildPassword(password);
        password.setRole(3);
        boolean isSuccess = userService.updPassword(password);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }

    //获取配置文件中的对象
    @RequestMapping("/uploadImg/{uname}")
    @Transactional
    public String uploadImg(@RequestParam("image") MultipartFile upload,@PathVariable("uname") String cname) {
        ApplicationHome home = new ApplicationHome(getClass());
        File fileJar = home.getSource();
        String savePath = fileJar.getParent().toString() + address;

        File file = new File(savePath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
        String oldName = upload.getOriginalFilename();
        String newName = UUID.randomUUID() + "_" + oldName;
        File saveFile = new File(savePath, newName);

        try {
            upload.transferTo(saveFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Children children = new Children();
        children.setCname(cname);
        Integer cid = childrenService.selecrCid(children);
        if (childrenService.addPicture(newName,cid)){
            return address + newName;
        }else {
            return "error";
        }
    }

    @RequestMapping("/selectImg/{uname}")
    public String selectImg(@PathVariable("uname") String cname){
        Children children = new Children();
        children.setCname(cname);
        Integer cid = childrenService.selecrCid(children);
        String img = childrenService.selectImg(cid);
        return address + img;
    }

    @RequestMapping("/resetChildrenPassword")
    @Transactional
    public String resetChildrenPassword(@RequestBody List<Integer> cids){
        boolean flag = childrenService.resetPassword(cids);
        List<Integer> uids = cids;
        boolean isSuccess = userService.resetPassword(uids,3);
        if (flag && isSuccess){
            return "success";
        }else {
            return "error";
        }
    }
}
