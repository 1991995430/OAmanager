package com.offcn.mapper;

import com.offcn.pojo.Analysis;
import com.offcn.pojo.AnalysisExample;
import com.offcn.pojo.AnalysisWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnalysisMapper {
    long countByExample(AnalysisExample example);

    int deleteByExample(AnalysisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AnalysisWithBLOBs record);

    int insertSelective(AnalysisWithBLOBs record);

    List<AnalysisWithBLOBs> selectByExampleWithBLOBs(AnalysisExample example);

    List<Analysis> selectByExample(AnalysisExample example);

    AnalysisWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AnalysisWithBLOBs record, @Param("example") AnalysisExample example);

    int updateByExampleWithBLOBs(@Param("record") AnalysisWithBLOBs record, @Param("example") AnalysisExample example);

    int updateByExample(@Param("record") Analysis record, @Param("example") AnalysisExample example);

    int updateByPrimaryKeySelective(AnalysisWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnalysisWithBLOBs record);

    int updateByPrimaryKey(Analysis record);
}