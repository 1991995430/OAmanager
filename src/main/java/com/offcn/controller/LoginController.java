package com.offcn.controller;

import com.offcn.pojo.Employee;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author songmu
 * @create 2019-06-25 8:26
 */


@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/login")
    @ResponseBody
    public Msg dologin(String username, String password, HttpSession session){
        Employee employee= employeeService.selectByUserNamePwdExample(username,password);
        Msg msg=new Msg();
        //如果查询出对象不为空
        if(employee!=null){
            session.setAttribute("employee",employee);
            msg.setMsg("登录成功!");
        }
        else {
            msg.setMsgCode(500);
            msg.setMsg("登陆失败");
        }
        return msg;

    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        System.out.println(session.getAttribute("employee"));
        session.removeAttribute("employee");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
