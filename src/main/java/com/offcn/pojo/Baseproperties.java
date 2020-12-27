package com.offcn.pojo;

import java.util.Date;

public class Baseproperties {
    private Integer bid;

    private String bname;

    private Integer bmodelcode;

    private String bmodelname;

    private Integer pbid;

    private Date addtime;

    private Integer adduser;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Integer getBmodelcode() {
        return bmodelcode;
    }

    public void setBmodelcode(Integer bmodelcode) {
        this.bmodelcode = bmodelcode;
    }

    public String getBmodelname() {
        return bmodelname;
    }

    public void setBmodelname(String bmodelname) {
        this.bmodelname = bmodelname == null ? null : bmodelname.trim();
    }

    public Integer getPbid() {
        return pbid;
    }

    public void setPbid(Integer pbid) {
        this.pbid = pbid;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getAdduser() {
        return adduser;
    }

    public void setAdduser(Integer adduser) {
        this.adduser = adduser;
    }
}