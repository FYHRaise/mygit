package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.IChildrenDao;
import com.jxd.leave.dao.ITeacherDao;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import com.jxd.leave.service.IChildrenService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ChildrenServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@Service
public class ChildrenServiceImpl implements IChildrenService {
    @Autowired
    private IChildrenDao childrenDao;
    @Autowired
    private ITeacherDao teacherDao;

    @Override
    public Map<String, Object> getAllChildren(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String cname = map.get("cname");
        String cnos = map.get("cno");
        int cno = 0;
        if (!"".equals(cnos)){
            cno = Integer.parseInt(cnos);
        }

        Map<String,Object> map1 = new HashMap(4);
        if (page != null && limit != null){
            IPage<Children> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Children> pageRes = childrenDao.getAllChildren(page1,cname,cno);
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
    public Map<String, Object> getChildren(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String cname = map.get("cname");
        String tname = map.get("tname");
        int cno = teacherDao.selectCno(tname);


        Map<String,Object> map1 = new HashMap(4);
        if (page != null && limit != null){
            IPage<Children> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Children> pageRes = childrenDao.getChildren(page1,cname,cno);
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
    public boolean addChildren(Children children) {
        return childrenDao.addChildren(children);
    }

    @Override
    public Children selectChildren(String cid) {
        return childrenDao.selectChildren(cid);
    }

    @Override
    public boolean updateChildren(Children children) {
        return childrenDao.updateChildren(children);
    }

    @Override
    public boolean delChildren(List<Integer> cids) {
        return childrenDao.delChildren(cids);
    }

    @Override
    public Integer selecrCid(Children children) {
        return childrenDao.selecrCid(children);
    }

    @Override
    public Integer selectCno(String cname) {
        return childrenDao.selectCno(cname);
    }

    @Override
    public List<Children> getChild(Children children) {
        return childrenDao.getChild(children);
    }

    @Override
    public boolean updChildPassword(Password password) {
        return childrenDao.updChildPassword(password);
    }

    @Override
    public boolean addPicture(String newName,Integer cid) {
        return childrenDao.addPicture(newName,cid);
    }

    @Override
    public boolean updChild(Children children) {
        return childrenDao.updChild(children);
    }

    @Override
    public String selectImg(Integer cid) {
        return childrenDao.selectImg(cid);
    }

    @Override
    public boolean resetPassword(List<Integer> cids) {
        return childrenDao.resetPassword(cids);
    }
}
