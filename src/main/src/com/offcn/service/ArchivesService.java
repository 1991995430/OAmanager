package com.offcn.service;

import com.offcn.pojo.Archives;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-26 15:58
 */
public interface ArchivesService {

    List<Archives> selectArchEmp();

    int insert(List list);
}
