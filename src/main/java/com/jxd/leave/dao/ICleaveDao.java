package com.jxd.leave.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.leave.model.Cleave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICleaveDao {
    IPage<Cleave> getAllCleave(IPage<Cleave> page, @Param("uname") String uname,@Param("statrt") String statrt,@Param("cid") Integer cid);

    IPage<Cleave> getCleave(IPage<Cleave> page, @Param("cno") Integer cno,@Param("statrt") String statrt,@Param("cname") String cname);

    IPage<Cleave> getAdminCleave(IPage<Cleave> page, @Param("cno") Integer cno,@Param("cname") String cname);

    boolean addLeave(Cleave cleave);

    boolean updLeave(Cleave cleave);

    boolean submit(Cleave cleave);

    Integer selectState(Cleave cleave);
    List<Integer> selectType(Cleave cleave);

    boolean deleteLeave(Cleave cleave);

    boolean agree(Cleave cleave);

    boolean disagree(Cleave cleave);

    boolean logoutLeave(Cleave cleave);

    boolean updRefuseReason(Cleave cleave);
}
