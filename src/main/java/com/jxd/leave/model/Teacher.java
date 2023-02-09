package com.jxd.leave.model;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/29
 * @Version 1.0
 */
public class Teacher {
    private Integer tid;
    private String tname;
    private String pwd;
    private Integer cno;
    private Integer role;

    public Teacher() {
    }

    public Teacher(Integer tid, String tname, String pwd, Integer cno, Integer role) {
        this.tid = tid;
        this.tname = tname;
        this.pwd = pwd;
        this.cno = cno;
        this.role = role;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
}
