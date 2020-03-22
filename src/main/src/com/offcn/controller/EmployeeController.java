package com.offcn.controller;

import com.offcn.pojo.Employee;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.EmpRoleService;
import com.offcn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-19 14:13
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmpRoleService empRoleService;

    //employeebyproject
    @RequestMapping("/employeebyproject")
    @ResponseBody
    public List<Employee> employeebyproject(){

        List<Employee> list =employeeService.selectByExample();

        return list;
    }


    @RequestMapping("/getEmpoyeePosition")
    @ResponseBody
    public List<Employee> getEmpoyeePosition(){

        return employeeService.selectEmpPos();

    }

    @RequestMapping("/addEmployee")
    @ResponseBody
    public Msg addEmployee(Employee employee, @RequestParam("roleid")String[] roleid){
        Msg msg = new Msg();
        /*System.out.println("employee::"+employee);
        System.out.println("role:::"+ Arrays.asList(roleid));*/
        int istate = employeeService.insertSelectiveReturnEmpid(employee);
        if(istate!=1){
            msg.setMsg("添加失败");
            msg.setMsgCode(500);
        }
        empRoleService.insertEmpRole(roleid,employee.getEid());

        return msg;
    }


    @RequestMapping("/getUserName")
    @ResponseBody
    public Msg getUserName(String username){
        Msg msg = new Msg();
        List<Employee> employees = employeeService.selectByUserName(username);
        if(employees.size()>0){
            msg.setMsgCode(500);
        }
        return msg;
    }

}
