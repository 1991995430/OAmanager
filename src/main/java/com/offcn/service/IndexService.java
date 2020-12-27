package com.offcn.service;

import com.offcn.pojo.Sources;

import java.util.List;

/**
 * @author songmu
 * @create 2019-07-02 19:42
 */
public interface IndexService {

    List<Sources> selectByEid(Integer eid);

    List<Sources> selectByRoleId(List<Integer> roleid);

}
