package com.offcn.service;

import com.offcn.pojo.ModuleWithBLOBs;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 18:54
 */
public interface ModelService {

    int insert(ModuleWithBLOBs record);

    List<ModuleWithBLOBs> selectByExampleWithBLOBs(Integer analysisFk);
}
