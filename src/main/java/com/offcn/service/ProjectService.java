package com.offcn.service;

import com.offcn.pojo.Project;
import com.offcn.pojo.ProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExampleWithBLOBs(ProjectExample example);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExampleWithBLOBs(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKeyWithBLOBs(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> selectByProEmpCus();

    List<Project> selectProject();

    List<Project> selectByKeyWord(String cid, String keyword, String orderby);
}