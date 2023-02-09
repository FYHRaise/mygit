package com.jxd.leave;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.leave.model.Class;
import com.jxd.leave.service.IChildrenService;
import com.jxd.leave.service.IClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
@SpringBootTest
public class ChildTest {

    @Autowired
    private IChildrenService childrenService;

    @Autowired
    private IClassService classService;


    @Test
    public void selectPage(){
        Map<String,String> map = new HashMap<>();
        IPage page1 = new Page(1,2);
        map.put("page","1");
        map.put("limit","10");
        map.put("cname","小红");
        map.put("cno","1");
        Map<String,Object> map1 = childrenService.getAllChildren(map);
        System.out.println(map1.toString());
        List<Class> list = classService.getAllClass();
        System.out.println(list.toString());

    }
}
