package com.offcn.service;

import com.offcn.mapper.AnalysisMapper;
import com.offcn.pojo.AnalysisExample;
import com.offcn.pojo.AnalysisWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-23 14:27
 */
@Service
public class AnalysisServiceImpl implements AnalysisService{
    @Autowired
    private AnalysisMapper analysisMapper;


    @Override
    public int insert(AnalysisWithBLOBs analysisWithBLOBs) {

        return analysisMapper.insert(analysisWithBLOBs);
    }

    @Override
    public List<AnalysisWithBLOBs> selectByExampleWithBLOBs(String proname) {

        AnalysisExample example = new AnalysisExample();
       AnalysisExample.Criteria criteria =  example.createCriteria();
        criteria.andPronameEqualTo(proname);

        return analysisMapper.selectByExampleWithBLOBs(example);
    }
}
