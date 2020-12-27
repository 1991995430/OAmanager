package com.offcn.service;

import com.offcn.mapper.SourcesMapper;
import com.offcn.pojo.Sources;
import com.offcn.pojo.SourcesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-28 19:59
 */
@Service
public class SourcesServiceImpl implements SourcesService {
    @Autowired
    private SourcesMapper sourcesMapper;

    @Override
    public long countByExample(SourcesExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(SourcesExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Sources record) {
        return 0;
    }

    @Override
    public int insertSelective(Sources record) {
        return sourcesMapper.insertSelective(record);
    }

    @Override
    public List<Sources> selectByExample(SourcesExample example) {
        return sourcesMapper.selectByExample(example);
    }

    @Override
    public Sources selectByPrimaryKey(Integer id) {
        return sourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Sources record, SourcesExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Sources record, SourcesExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Sources record) {
        SourcesExample example = new SourcesExample();
        SourcesExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(record.getId());
        return sourcesMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByPrimaryKey(Sources record) {
        return 0;
    }

    @Override
    public List<Sources> selectByRoleid(List<Integer> sid) {

        return sourcesMapper.selectByRoleid(sid);
    }
}
