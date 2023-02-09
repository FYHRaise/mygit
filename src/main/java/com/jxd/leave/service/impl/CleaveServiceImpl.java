package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.IChildrenDao;
import com.jxd.leave.dao.ICleaveDao;
import com.jxd.leave.dao.ITeacherDao;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Class;
import com.jxd.leave.model.Cleave;
import com.jxd.leave.model.Teacher;
import com.jxd.leave.service.ICleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CleaveServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/31
 * @Version 1.0
 */
@Service
public class CleaveServiceImpl implements ICleaveService {
    @Autowired
    private ICleaveDao cleaveDao;
    @Autowired
    private ITeacherDao teacherDao;
    @Autowired
    private IChildrenDao childrenDao;
    @Override
    public Map<String, Object> getAllCleave(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String uname = map.get("uname");
        String statrt = map.get("statrt");
        Children children = new Children();
        children.setCname(uname);
        Integer cid = childrenDao.selecrCid(children);
        Map<String,Object> map1 = new HashMap(5);
        if (page != null && limit != null){
            IPage<Cleave> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Cleave> pageRes = cleaveDao.getAllCleave(page1,uname,statrt,cid);
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
    public Map<String, Object> getCleave(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String tname = map.get("tname");
        String cname = map.get("cname");
        String statrt = map.get("statrt");
        Integer cno = teacherDao.selectCno(tname);
        Map<String,Object> map1 = new HashMap(5);
        if (page != null && limit != null){
            IPage<Cleave> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Cleave> pageRes = cleaveDao.getCleave(page1,cno,statrt,cname);
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
    public Map<String, Object> getAdminCleave(Map<String, String> map) {
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
            IPage<Cleave> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Cleave> pageRes = cleaveDao.getAdminCleave(page1,cno,cname);
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
    public boolean addLeave(Cleave cleave) {
        return cleaveDao.addLeave(cleave);
    }

    @Override
    public boolean updLeave(Cleave cleave) {
        return cleaveDao.updLeave(cleave);
    }

    @Override
    public boolean submit(Cleave cleave) {
        return cleaveDao.submit(cleave);
    }

    @Override
    public Integer selectState(Cleave cleave) {
        return cleaveDao.selectState(cleave);
    }

    @Override
    public boolean deleteLeave(Cleave cleave) {
        return cleaveDao.deleteLeave(cleave);
    }

    @Override
    public List<Integer> selectType(Cleave cleave) {
        return cleaveDao.selectType(cleave);
    }

    @Override
    public boolean agree(Cleave cleave) {
        return cleaveDao.agree(cleave);
    }

    @Override
    public boolean disagree(Cleave cleave) {
        return cleaveDao.disagree(cleave);
    }

    @Override
    public boolean logoutLeave(Cleave cleave) {
        return cleaveDao.logoutLeave(cleave);
    }

    @Override
    public boolean updRefuseReason(Cleave cleave) {
        return cleaveDao.updRefuseReason(cleave);
    }
}
