package com.offcn.service;

import com.offcn.pojo.EmpRole;
import com.offcn.pojo.Sources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author songmu
 * @create 2019-07-02 19:42
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Autowired
    private EmpRoleService empRoleService;
    @Autowired
    private SourcesService sourcesService;


    @Override
    public List<Sources> selectByEid(Integer eid) {
        //获取roleid
        List<EmpRole> empRoles = empRoleService.selectByEid(eid);
        List<Integer> roleid = empRoles.stream().map(EmpRole::getRoleFk).collect(Collectors.toList());
        //获取资源
        List<Sources> sources = selectByRoleId(roleid);
        //一级菜单
        List<Sources> parents = sources.stream().filter(p->p.getPid()==1).collect(Collectors.toList());
        //二级菜单
        for(Sources parent:parents){
            List<Sources> childs = sources.stream().filter(p->p.getPid()==parent.getId()).collect(Collectors.toList());
            parent.setChildren(childs);
        }
        return parents;
    }

    @Override
    public List<Sources> selectByRoleId(List<Integer> roleid) {
        return sourcesService.selectByRoleid(roleid);
    }
}
