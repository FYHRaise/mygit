package com.jxd.leave.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.dao.IChildrenDao;
import com.jxd.leave.dao.IParentsDao;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Parents;
import com.jxd.leave.service.IParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParentsServiceImpl
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/2/1
 * @Version 1.0
 */
@Service
public class ParentsServiceImpl implements IParentsService {
    @Autowired
    private IParentsDao parentsDao;
    @Autowired
    private IChildrenDao childrenDao;

    @Override
    public Map<String, Object> getAllParents(Map<String, String> map) {
        String page = map.get("page");
        String limit = map.get("limit");
        String pname = map.get("pname");
        String relationship = map.get("relationship");
        String cname = map.get("cname");
        Children children = new Children();
        children.setCname(cname);
        int cid = childrenDao.selecrCid(children);

        Map<String,Object> map1 = new HashMap(5);
        if (page != null && limit != null){
            IPage<Parents> page1 = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Parents> pageRes = parentsDao.getAllParents(page1,pname,relationship,cid);
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
    public boolean addParents(Parents parents) {
        return parentsDao.addParents(parents);
    }

    @Override
    public boolean updParents(Parents parents) {
        return parentsDao.updParents(parents);
    }

    @Override
    public boolean delParents(List<Integer> pids) {
        return parentsDao.delParents(pids);
    }

    @Override
    public List<Parents> getParents(Integer cid) {
        return parentsDao.getParents(cid);
    }
}
