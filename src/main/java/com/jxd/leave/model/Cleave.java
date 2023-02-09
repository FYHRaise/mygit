package com.jxd.leave.model;

/**
 * @ClassName Cleave
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/31
 * @Version 1.0
 */
public class Cleave {
    private Integer clid;
    private String statrt;
    private String end;
    private Integer lid;
    private String reason;
    private Integer sid;
    private Integer cid;
    private Integer pid;
    private Integer cno;
    private Integer day;
    private Integer typeid;
    private String cname;

    private String refusereson;

    public Cleave() {
    }



    public Cleave(Integer clid, String statrt, String end, Integer lid, String reason, Integer sid, Integer cid, Integer pid, Integer cno, Integer day, Integer typeid, String cname, String refusereson) {
        this.clid = clid;
        this.statrt = statrt;
        this.end = end;
        this.lid = lid;
        this.reason = reason;
        this.sid = sid;
        this.cid = cid;
        this.pid = pid;
        this.cno = cno;
        this.day = day;
        this.typeid = typeid;
        this.cname = cname;
        this.refusereson = refusereson;
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public void setStatrt(String statrt) {
        this.statrt = statrt;
    }

    public String getStatrt() {
        return statrt;
    }

    public void setStart(String start) {
        this.statrt = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRefusereson() {
        return refusereson;
    }

    public void setRefusereson(String refusereson) {
        this.refusereson = refusereson;
    }
}
