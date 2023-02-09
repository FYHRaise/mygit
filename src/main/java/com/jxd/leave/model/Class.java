package com.jxd.leave.model;

import com.jxd.leave.dao.IClassDao;

/**
 * @ClassName Class
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Class {
    private Integer cno;
    private String clname;

    public Class() {
    }

    public Class(Integer cno, String clname) {
        this.cno = cno;
        this.clname = clname;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }
}
