package com.offcn.service;

import com.offcn.mapper.EmpRoleMapper;
import com.offcn.pojo.EmpRole;
import com.offcn.pojo.EmpRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-30 8:17
 */
@Service
public class EmpRoleServiceImpl implements EmpRoleService{
    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public int insertEmpRole(String[] roleid, Integer eid) {
        int istate = 0;
        //System.out.println("roleid::"+Arrays.asList(roleid)+"::"+"eid::"+eid);

        EmpRole empRole = new EmpRole();

        /*for (int j = 0; j < roleid.length; j++) {

            System.out.println("传过来的roleid：："+Integer.parseInt(roleid[j]));

        }*/

        for (int i = 0; i < roleid.length; i++) {
            empRole.setEmpFk(eid);
            empRole.setRoleFk(Integer.parseInt(roleid[i]));
            empRole.setErdis("adaed");
            istate += empRoleMapper.insertSelective(empRole);
        }

        return istate;
    }

    @Override
    public List selectByExample1(List list) {
        EmpRoleExample example = new EmpRoleExample();
        EmpRoleExample.Criteria criteria = example.createCriteria();
        criteria.andEmpFkIn(list);
        return empRoleMapper.selectByExample1(example);
    }

    //通过eid获取roleid
    @Override
    public List<EmpRole> selectByEid(Integer eid) {
        EmpRoleExample example = new EmpRoleExample();
        EmpRoleExample.Criteria criteria = example.createCriteria();
        criteria.andEmpFkEqualTo(eid);
        return  empRoleMapper.selectByExample(example);
    }
}
