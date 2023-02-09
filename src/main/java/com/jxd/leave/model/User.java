package com.jxd.leave.model;

/**
 * @ClassName model
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/27
 * @Version 1.0
 */
public class User {
    private Integer uid;
    private String uname;
    private String pwd;
    private Integer role;
    private Integer peopleid;

    public User() {
    }

    public User(Integer uid, String uname, String pwd, Integer role, Integer peopleid) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.role = role;
        this.peopleid = peopleid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPeopleid() {
        return peopleid;
    }

    public void setPeopleid(Integer peopleid) {
        this.peopleid = peopleid;
    }
}
