package com.offcn.pojo;

import java.util.List;

public class Sources {
    private Integer id;

    private String name;

    private String url;

    private String remark;

    private Integer pid;

    private String icon;

    private List<Sources> children;

    private boolean open=true;

    private RoleSources roleSources;

    private EmpRole empRole;

    private Employee employee;

    public RoleSources getRoleSources() {
        return roleSources;
    }

    public void setRoleSources(RoleSources roleSources) {
        this.roleSources = roleSources;
    }

    public EmpRole getEmpRole() {
        return empRole;
    }

    public void setEmpRole(EmpRole empRole) {
        this.empRole = empRole;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Sources{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                ", pid=" + pid +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                ", open=" + open +
                '}';
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Sources> getChildren() {
        return children;
    }

    public void setChildren(List<Sources> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}