package com.offcn.service;

import com.offcn.pojo.EmpRole;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-30 8:17
 */
public interface EmpRoleService {

    int insertEmpRole(String[] roleid,Integer eid);

    List selectByExample1(List list);

    List<EmpRole> selectByEid(Integer eid);
}
