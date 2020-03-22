package com.offcn.service;

import com.offcn.mapper.DatacollectMapper;
import com.offcn.pojo.Datacollect;
import com.offcn.pojo.DatacollectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-27 19:00
 */
@Service
public class DatacollectServiceImpl implements DatacollectService{

    @Autowired
    private DatacollectMapper datacollectMapper;


    @Override
    public int insert(List list) {
        int istate =0;
        for (int i = 0; i < list.size(); i++) {
            istate+=datacollectMapper.insert((Datacollect)list.get(i));
        }
        return istate;
    }

    @Override
    public List selectByExcemple() {
        return datacollectMapper.selectByExample(null);
    }

    @Override
    public List<Datacollect> selectAllDaname() {
        return datacollectMapper.selectAllDaname();
    }

    @Override
    public Datacollect selectByPrimaryKey(Integer daid) {
        return datacollectMapper.selectByPrimaryKey(daid);
    }

    @Override
    public List<Datacollect> selectByExample(String dacname) {
        DatacollectExample example = new DatacollectExample();
        example.setOrderByClause("datime");
        DatacollectExample.Criteria criteria = example.createCriteria();
        criteria.andDacnameEqualTo(dacname);
        return datacollectMapper.selectByExample(example);
    }
}
