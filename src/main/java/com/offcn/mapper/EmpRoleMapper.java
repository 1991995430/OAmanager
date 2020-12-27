package com.offcn.mapper;

import com.offcn.pojo.EmpRole;
import com.offcn.pojo.EmpRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpRoleMapper {
    long countByExample(EmpRoleExample example);

    int deleteByExample(EmpRoleExample example);

    int deleteByPrimaryKey(Integer erid);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    List<EmpRole> selectByExample(EmpRoleExample example);

    EmpRole selectByPrimaryKey(Integer erid);

    int updateByExampleSelective(@Param("record") EmpRole record, @Param("example") EmpRoleExample example);

    int updateByExample(@Param("record") EmpRole record, @Param("example") EmpRoleExample example);

    int updateByPrimaryKeySelective(EmpRole record);

    int updateByPrimaryKey(EmpRole record);

    List selectByExample1(EmpRoleExample example);

}