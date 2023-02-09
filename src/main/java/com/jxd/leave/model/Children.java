package com.jxd.leave.model;

import ch.qos.logback.core.net.ssl.SSL;

/**
 * @ClassName Children
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/28
 * @Version 1.0
 */
public class Children {
    private Integer cid;
    private String cname;
    private Integer cno;
    private Integer role;
    private String sex;
    private String pwd;
    private String birthday;
    private String picture;

    public Children() {
    }

    public Children(Integer cid, String cname, Integer cno, Integer role, String sex, String pwd, String birthday, String picture) {
        this.cid = cid;
        this.cname = cname;
        this.cno = cno;
        this.role = role;
        this.sex = sex;
        this.pwd = pwd;
        this.birthday = birthday;
        this.picture = picture;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
