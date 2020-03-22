package com.offcn.service;

import com.offcn.pojo.Baoxiao;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-27 8:38
 */
public interface BaoxiaoService {

    int insert(Baoxiao record);

    List<Baoxiao> selectByExample();

    List<Baoxiao> selectBaoxiaoPro(Integer empFk);

    List<Baoxiao> selectBaoxiaoPro1();

    Baoxiao selectByPrimarykey(String bxid);

    int updateByExampleSelective(Baoxiao record);

    int updateByExampleSelective1(Baoxiao record);

    int updateByExample(String bxid,Baoxiao baoxiao);

}
