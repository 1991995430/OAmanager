package com.offcn.mapper;

import com.offcn.pojo.RoleSources;
import com.offcn.pojo.RoleSourcesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleSourcesMapper {
    long countByExample(RoleSourcesExample example);

    int deleteByExample(RoleSourcesExample example);

    int deleteByPrimaryKey(Integer rsid);

    int insert(RoleSources record);

    int insertSelective(RoleSources record);

    List<RoleSources> selectByExample(RoleSourcesExample example);

    RoleSources selectByPrimaryKey(Integer rsid);

    int updateByExampleSelective(@Param("record") RoleSources record, @Param("example") RoleSourcesExample example);

    int updateByExample(@Param("record") RoleSources record, @Param("example") RoleSourcesExample example);

    int updateByPrimaryKeySelective(RoleSources record);

    int updateByPrimaryKey(RoleSources record);

    List selectByExample1(RoleSourcesExample example);


}