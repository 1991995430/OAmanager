package com.offcn.service;

import com.offcn.mapper.ModuleMapper;
import com.offcn.pojo.ModuleExample;
import com.offcn.pojo.ModuleWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 18:54
 */
@Service
public class ModelServiceImpl implements ModelService{
    @Autowired
    private ModuleMapper moduleMapper;


    @Override
    public int insert(ModuleWithBLOBs moduleWithBLOBs) {
        return moduleMapper.insert(moduleWithBLOBs);
    }



    @Override
    public List<ModuleWithBLOBs> selectByExampleWithBLOBs(Integer analysisFk) {

        ModuleExample example = new ModuleExample();
        ModuleExample.Criteria criteria = example.createCriteria();
        criteria.andAnalysisFkEqualTo(analysisFk);

        List<ModuleWithBLOBs> list = moduleMapper.selectByExampleWithBLOBs(example);
        return list;
    }
}
