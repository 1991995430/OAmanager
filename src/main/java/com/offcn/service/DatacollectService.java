package com.offcn.service;

import com.offcn.pojo.Datacollect;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-27 19:00
 */
public interface DatacollectService {

    int insert(List list);

    List selectByExcemple();

    List<Datacollect> selectAllDaname();

    Datacollect selectByPrimaryKey(Integer daid);

    List<Datacollect> selectByExample(String daname);

}
