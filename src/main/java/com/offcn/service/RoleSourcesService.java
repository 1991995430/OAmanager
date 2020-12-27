package com.offcn.service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 15:05
 */
public interface RoleSourcesService {

    int insertByRidSid(Integer roleid,String sourcesid);

    List selectByExample(List list);
}
