package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Children;
import com.jxd.leave.model.Password;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IChildrenDao {
    IPage<Children> getAllChildren(IPage<Children> page, @Param("cname") String cname,@Param("cno") int cno);
    IPage<Children> getChildren(IPage<Children> page, @Param("cname") String cname,@Param("cno") int cno);

    boolean addChildren(Children children);

    Children selectChildren(String cid);

    boolean updateChildren(Children children);

    boolean delChildren(List<Integer> cids);

    Integer selecrCid(Children children);

    Integer selectCno(String cname);

    List<Children> getChild(Children children);

    boolean updChild(Children children);

    boolean updChildPassword(Password password);

    boolean addPicture(@Param("newName") String newName,@Param("cid") Integer cid);

    String selectImg(Integer cid);

    boolean resetPassword(List<Integer> cids);
}
