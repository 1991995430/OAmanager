package com.offcn.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class Project {

    private Customer customer;

    private Employee employee;

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private Integer pid;

    private String pname;

    private Integer comname;

    private String comper;

    private Integer empFk1;

    private Integer empcount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date starttime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buildtime;

    private Integer cost;

    private Integer state;

    private String level;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endtime;

    private Integer empFk;

    private String remark;

    @Override
    public String toString() {
        return "Project{" +
                "customer=" + customer +
                ", employee=" + employee +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", comname=" + comname +
                ", comper='" + comper + '\'' +
                ", empFk1=" + empFk1 +
                ", empcount=" + empcount +
                ", starttime=" + starttime +
                ", buildtime=" + buildtime +
                ", cost=" + cost +
                ", level='" + level + '\'' +
                ", endtime=" + endtime +
                ", empFk=" + empFk +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getComname() {
        return comname;
    }

    public void setComname(Integer comname) {
        this.comname = comname;
    }

    public String getComper() {
        return comper;
    }

    public void setComper(String comper) {
        this.comper = comper == null ? null : comper.trim();
    }

    public Integer getEmpFk1() {
        return empFk1;
    }

    public void setEmpFk1(Integer empFk1) {
        this.empFk1 = empFk1;
    }

    public Integer getEmpcount() {
        return empcount;
    }

    public void setEmpcount(Integer empcount) {
        this.empcount = empcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}