package com.offcn.service;

import com.offcn.mapper.TaskMapper;
import com.offcn.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 18:26
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public int insert(Task record) {

        int istate = taskMapper.insert(record);

        return istate;
    }

    @Override
    public List<Task> selectByProEmpPos() {
        return taskMapper.selectByProEmpPos();
    }
}
