package com.offcn.controller;

import com.offcn.pojo.Task;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 17:38
 */
@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping("/addTask")
    @ResponseBody
    public Msg addTask(Task task){
        Msg msg = new Msg();
        int istate = taskService.insert(task);
        if(istate!=1){
            msg.setMsgCode(200);
            msg.setMsg("添加失败！");
        }
        return msg;
    }

    @RequestMapping("/selectEmpPos")
    @ResponseBody
    public List<Task> selectEmpPos(){
        return taskService.selectByProEmpPos();
    }

}
