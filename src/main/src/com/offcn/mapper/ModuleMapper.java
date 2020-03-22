package com.offcn.mapper;

import com.offcn.pojo.Module;
import com.offcn.pojo.ModuleExample;
import com.offcn.pojo.ModuleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleMapper {
    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModuleWithBLOBs record);

    int insertSelective(ModuleWithBLOBs record);

    List<ModuleWithBLOBs> selectByExampleWithBLOBs(ModuleExample example);

    List<Module> selectByExample(ModuleExample example);

    ModuleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModuleWithBLOBs record, @Param("example") ModuleExample example);

    int updateByExampleWithBLOBs(@Param("record") ModuleWithBLOBs record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(ModuleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ModuleWithBLOBs record);

    int updateByPrimaryKey(Module record);
}