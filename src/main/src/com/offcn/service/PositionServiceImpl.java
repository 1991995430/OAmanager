package com.offcn.service;

import com.offcn.mapper.PositionMapper;
import com.offcn.pojo.Position;
import com.offcn.pojo.PositionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 16:56
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> selectByExample(PositionExample example) {
        return positionMapper.selectByExample(example);
    }
}
