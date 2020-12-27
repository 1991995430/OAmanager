package com.offcn.service;

import com.offcn.mapper.BaoxiaoMapper;
import com.offcn.pojo.Baoxiao;
import com.offcn.pojo.BaoxiaoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-27 8:39
 */
@Service
public class BaoxiaoServiceImpl implements BaoxiaoService{

    @Autowired
    private BaoxiaoMapper baoxiaoMapper;
    @Override
    public int insert(Baoxiao record) {

        return baoxiaoMapper.insert(record);
    }

    @Override
    public List<Baoxiao> selectByExample() {
        return baoxiaoMapper.selectByExample(null);

    }

    @Override
    public List<Baoxiao> selectBaoxiaoPro(Integer empFk) {
        return baoxiaoMapper.selectBaoxiaoPro(empFk);
    }

    @Override
    public List<Baoxiao> selectBaoxiaoPro1() {
        return baoxiaoMapper.selectBaoxiaoPro1();
    }


    @Override
    public Baoxiao selectByPrimarykey(String bxid) {
        return baoxiaoMapper.selectByPrimaryKey(bxid);
    }

    @Override
    public int updateByExampleSelective(Baoxiao record) {
        BaoxiaoExample example = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = example.createCriteria();
        record.setBxstatus(0);
        criteria.andBxidEqualTo(record.getBxid());
        return baoxiaoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExampleSelective1(Baoxiao record) {
        BaoxiaoExample example = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = example.createCriteria();
        criteria.andBxidEqualTo(record.getBxid());
        return baoxiaoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(String bxid,Baoxiao baoxiao) {
        BaoxiaoExample baoxiaoExample = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = baoxiaoExample.createCriteria();
        criteria.andBxidEqualTo(bxid);
        return baoxiaoMapper.updateByExample(baoxiao,baoxiaoExample);
    }
}
