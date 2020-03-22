package com.offcn.controller;

import com.offcn.pojo.*;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.EmpRoleService;
import com.offcn.service.EmployeeService;
import com.offcn.service.RoleSourcesService;
import com.offcn.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author songmu
 * @create 2019-06-28 19:29
 */
@Controller
public class SourcesController {

    @Autowired
    private SourcesService sourcesService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpRoleService empRoleService;
    @Autowired
    private RoleSourcesService roleSourcesService;

    //不同角色获取不同菜单
    @RequestMapping("/getRootSources1")
    @ResponseBody
    public Sources getRootSources1(HttpSession session) {

        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("*********************************");
        System.out.println(employee);
        System.out.println("*********************************");
        if(employee!=null){

        List list1 = employeeService.selectByExample1(employee);
        List eids = new ArrayList();
        for (int i = 0; i < list1.size(); i++) {
            Employee e = (Employee) list1.get(i);
            eids.add(e.getEid());
        }
        // System.out.println("list1::::"+list1);
        // System.out.println("eids::::"+eids);
        List list2 = empRoleService.selectByExample1(eids);
        List roleFks = new ArrayList();
        System.out.println("list2:::" + list2);
        for (int i = 0; i < list2.size(); i++) {
            EmpRole empRole = (EmpRole) list2.get(i);
            roleFks.add(empRole.getRoleFk());
        }
        System.out.println("roleFks:::" + roleFks);
        List roleidlist3 = roleSourcesService.selectByExample(roleFks);
        List sids = new ArrayList();
        for (int i = 0; i < roleidlist3.size(); i++) {
            RoleSources roleSources = (RoleSources) roleidlist3.get(i);
            sids.add(roleSources.getSid());
        }
        System.out.println("sids:::" + sids);

        SourcesExample example = new SourcesExample();
        SourcesExample.Criteria c = example.createCriteria();
        c.andPidEqualTo(0);
        c.andIdIn(sids);
        List<Sources> parentSource = sourcesService.selectByExample(example);
        Sources source = parentSource.get(0);
        getChildern1(source, sids);
            return source;
    }else{
            SourcesExample example=new SourcesExample();
            SourcesExample.Criteria c = example.createCriteria();
            c.andPidEqualTo(0);
            List<Sources> parentSource = sourcesService.selectByExample(example);
            Sources source = parentSource.get(0);
            getChildern(source);
            return source;
        }


        }

    public void getChildern1(Sources sources,List list){

        SourcesExample example=new SourcesExample();
        SourcesExample.Criteria c = example.createCriteria();
        c.andPidEqualTo(sources.getId());
        c.andIdIn(list);
        List<Sources> childerSource= sourcesService.selectByExample(example);
        for(Sources info : childerSource){
            getChildern1(info,list);
        }
        sources.setChildren(childerSource);
    }


    //获取资源数据
    @RequestMapping("/getRootSources")
    @ResponseBody
    public Sources getRootSources(){
        SourcesExample example=new SourcesExample();
        SourcesExample.Criteria c = example.createCriteria();
        c.andPidEqualTo(0);
        List<Sources> parentSource= sourcesService.selectByExample(example);
        Sources source = parentSource.get(0);
        getChildern(source);
        return source;
    }

    public void getChildern(Sources sources){

        SourcesExample example=new SourcesExample();
        SourcesExample.Criteria c = example.createCriteria();
        c.andPidEqualTo(sources.getId());

        List<Sources> childerSource= sourcesService.selectByExample(example);

        for (Sources info : childerSource){
            getChildern(info);
        }
        sources.setChildren(childerSource);
    }


    @RequestMapping("/sourceEditorView")
    @ResponseBody
    public ModelAndView sourceEditorView(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Sources sources = sourcesService.selectByPrimaryKey(id);
        modelAndView.addObject("sources",sources);
        modelAndView.setViewName("pm-edit");
        return modelAndView;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public Msg updateInfo(Sources sources){
        Msg msg = new Msg();
        int istate = sourcesService.updateByPrimaryKeySelective(sources);
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("更新失败！");
        }
        return msg;
    }

    @RequestMapping("/toAddpage")
    @ResponseBody
    public ModelAndView toAddpage(@RequestParam("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("parma",id);
        modelAndView.setViewName("pm-add");
        return modelAndView;
    }

    @RequestMapping("/sourcesAdd")
    public String sourcesAdd(Sources sources, HttpServletResponse response){
        System.out.println(sources);
        sourcesService.insertSelective(sources);
        return "pm";
    }


}
