package com.offcn.service;

import com.offcn.mapper.RoleMapper;
import com.offcn.pojo.Role;
import com.offcn.pojo.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 14:50
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public long countByExample(RoleExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(RoleExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer roleid) {
        return 0;
    }

    @Override
    public int insert(Role record) {
        return 0;
    }

    @Override
    public int insertSelective(Role record) {
        return 0;
    }

    @Override
    public List<Role> selectByExample(RoleExample example) {
        return null;
    }

    @Override
    public Role selectByPrimaryKey(Integer roleid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Role record, RoleExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Role record, RoleExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return 0;
    }

    @Override
    public int insertRoleFRid(Role role) {

        int istate = roleMapper.insertRoleFRid(role);

        return istate;
    }

    @Override
    public List<Role> selectRolePro() {
        return roleMapper.selectRolePro();
    }
}
