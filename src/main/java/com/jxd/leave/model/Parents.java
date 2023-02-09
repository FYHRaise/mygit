package com.jxd.leave.model;

/**
 * @ClassName Parents
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/2/1
 * @Version 1.0
 */
public class Parents {
    private Integer pid;
    private String pname;
    private String relationship;
    private Integer cid;
    private String phone;

    private String cname;

    public Parents(Integer pid, String pname, String relationship, Integer cid, String phone, String cname) {
        this.pid = pid;
        this.pname = pname;
        this.relationship = relationship;
        this.cid = cid;
        this.phone = phone;
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Parents() {
    }

    public Parents(Integer pid, String pname, String relationship, Integer cid, String phone) {
        this.pid = pid;
        this.pname = pname;
        this.relationship = relationship;
        this.cid = cid;
        this.phone = phone;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
