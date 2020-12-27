package com.offcn.service;

import com.offcn.mapper.FunctionMapper;
import com.offcn.pojo.Function;
import com.offcn.pojo.FunctionExample;
import com.offcn.pojo.FunctionWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 16:29
 */
@Service
public class FunctionServiceImpl implements FunctionService{
    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public int insert(FunctionWithBLOBs record) {
        return functionMapper.insert(record);
    }

    @Override
    public List<Function> selectByExample(Integer modeleFk) {
        FunctionExample example = new FunctionExample();
        FunctionExample.Criteria criteria = example.createCriteria();
        criteria.andModeleFkEqualTo(modeleFk);
        return functionMapper.selectByExample(example);
    }
}
