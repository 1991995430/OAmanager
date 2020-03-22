package com.offcn.controller;

import com.offcn.pojo.Project;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.ProjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-20 16:12
 */
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/projectadd")
    @ResponseBody
    public Msg projectAdd(Project project){
        int istate =projectService.insert(project);
        Msg msg=new Msg();
        if(istate!=1) {
            msg.setMsgCode(500);
            msg.setMsg("添加失败");

        }
        return msg;
    }

    @RequestMapping("/getProjects")
    @ResponseBody
    public List<Project> getProjects(){

        List<Project> list =projectService.selectProject();
        System.out.println("查询到数据为：：："+list);
        return list;
    }
    //getProjectListByKeyWord
    @RequestMapping("/getProjectList")
    @ResponseBody
    public List<Project> getProjectList(){

        List<Project> list =projectService.selectByProEmpCus();
        System.out.println("查询到数据为：：："+list);
        return list;
    }

    @RequestMapping("/getProjectListByKeyWord")
    @ResponseBody
    public List<Project> getProjectListByKeyWord(@Param("cid")String cid,@Param("keyword")String keyword,@Param("orderby")String orderby){

        System.out.println("获取表单数据:::cid:"+cid+",keyword："+keyword+",orderby:"+orderby);
        List<Project> list =projectService.selectByKeyWord(cid,keyword,orderby);

        /*for (int i = 0; i <list.size() ; i++) {
            System.out.println("查到新数据为：：："+list.get(i));
        }*/
        return list;
    }





}
