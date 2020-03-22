package com.offcn.service;

import com.offcn.mapper.RoleSourcesMapper;
import com.offcn.pojo.RoleSources;
import com.offcn.pojo.RoleSourcesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 15:06
 */
@Service
public class RoleSourcesServiceImpl implements RoleSourcesService{
    @Autowired
    private RoleSourcesMapper roleSourcesMapper;


    @Override
    public int insertByRidSid(Integer roleid,String sourcesid) {

        String[] array = sourcesid.split(",");
        RoleSources roleSources = new RoleSources();
        int istate = 0;
        for (int i = 0; i < array.length; i++) {
            roleSources.setRoleid(roleid);
            roleSources.setSid(Integer.parseInt((array[i])));
            roleSources.setRsdis("角色资源信息描述");
            istate+=roleSourcesMapper.insertSelective(roleSources);
        }

        return istate;
    }

    @Override
    public List selectByExample(List list) {
        RoleSourcesExample example = new RoleSourcesExample();
        RoleSourcesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleidIn(list);
        return roleSourcesMapper.selectByExample1(example);
    }
}
