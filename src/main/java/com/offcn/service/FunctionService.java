package com.offcn.service;

import com.offcn.pojo.Function;
import com.offcn.pojo.FunctionWithBLOBs;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 16:29
 */
public interface FunctionService {

    int insert(FunctionWithBLOBs record);

    List<Function> selectByExample(Integer modeleFk);
}
