package com.offcn.service;

import com.offcn.pojo.Position;
import com.offcn.pojo.PositionExample;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 16:56
 */
public interface PositionService {

    List<Position> selectByExample(PositionExample example);
}
