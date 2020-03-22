package com.offcn.mapper;

import com.offcn.pojo.Baseproperties;
import com.offcn.pojo.BasepropertiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasepropertiesMapper {
    long countByExample(BasepropertiesExample example);

    int deleteByExample(BasepropertiesExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Baseproperties record);

    int insertSelective(Baseproperties record);

    List<Baseproperties> selectByExample(BasepropertiesExample example);

    Baseproperties selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Baseproperties record, @Param("example") BasepropertiesExample example);

    int updateByExample(@Param("record") Baseproperties record, @Param("example") BasepropertiesExample example);

    int updateByPrimaryKeySelective(Baseproperties record);

    int updateByPrimaryKey(Baseproperties record);
}