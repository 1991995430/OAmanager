package com.offcn.service;

import com.offcn.mapper.ProjectMapper;
import com.offcn.pojo.Project;
import com.offcn.pojo.ProjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songmu
 * @create 2019-06-20 16:44
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public long countByExample(ProjectExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ProjectExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer pid) {
        return 0;
    }

    @Override
    public int insert(Project record) {
        return projectMapper.insert(record);
    }

    @Override
    public int insertSelective(Project record) {
        return 0;
    }

    @Override
    public List<Project> selectByExampleWithBLOBs(ProjectExample example) {
        return null;
    }

    @Override
    public List<Project> selectByExample(ProjectExample example) {
        return null;
    }

    @Override
    public Project selectByPrimaryKey(Integer pid) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Project record, ProjectExample example) {
        return 0;
    }

    @Override
    public int updateByExampleWithBLOBs(Project record, ProjectExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Project record, ProjectExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Project record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Project record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Project record) {
        return 0;
    }

    @Override
    public List<Project> selectByProEmpCus() {

        return projectMapper.selectByProEmpCus();

    }

    @Override
    public List<Project> selectProject() {
        return projectMapper.selectByExample(null);
    }

    @Override
    public List<Project> selectByKeyWord(String cid, String keyword, String orderby) {

            Map<String,String> map = new HashMap();
            map.put("cid",cid);
            map.put("keyword",keyword);
            map.put("orderby",orderby);
            System.out.println(map);
            List<Project> list = projectMapper.selectByProKeyWord(map);


        return list;
    }
}
