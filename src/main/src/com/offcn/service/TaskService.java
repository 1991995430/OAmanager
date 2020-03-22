package com.offcn.service;

import com.offcn.pojo.Task;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 18:25
 */
public interface TaskService {

    int insert(Task record);

    List<Task> selectByProEmpPos();
}
