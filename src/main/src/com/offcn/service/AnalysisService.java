package com.offcn.service;

import com.offcn.pojo.AnalysisWithBLOBs;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-23 14:27
 */
public interface AnalysisService {

    int insert(AnalysisWithBLOBs analysisWithBLOBs);

    List<AnalysisWithBLOBs> selectByExampleWithBLOBs(String proname);

}
