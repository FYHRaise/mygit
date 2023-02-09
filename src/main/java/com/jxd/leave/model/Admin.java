package com.jxd.leave.model;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/30
 * @Version 1.0
 */
public class Admin {
    private Integer aid;
    private String aname;
    private String ajob;
    private String pwd;

    public Admin() {
    }

    public Admin(Integer aid, String aname, String ajob, String pwd) {
        this.aid = aid;
        this.aname = aname;
        this.ajob = ajob;
        this.pwd = pwd;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAjob() {
        return ajob;
    }

    public void setAjob(String ajob) {
        this.ajob = ajob;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
