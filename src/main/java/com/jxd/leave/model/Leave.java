package com.jxd.leave.model;

/**
 * @ClassName Leave
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Leave {
    private Integer lid;
    private String lname;

    public Leave() {
    }

    public Leave(Integer lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
