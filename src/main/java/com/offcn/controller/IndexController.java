package com.offcn.controller;

import com.offcn.pojo.Employee;
import com.offcn.pojo.Sources;
import com.offcn.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author songmu
 * @create 2019-07-02 19:41
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu");
        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView menu(HttpSession session) {

        Employee employee = (Employee) session.getAttribute("employee");
        int eid = 0;
        if (employee != null) {
            eid = employee.getEid();
        }
        List<Sources> sources = indexService.selectByEid(eid);
        System.out.println("**************查询到的菜单数据******************");
        System.out.println(sources);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu");
        modelAndView.addObject("sources", sources);
        return modelAndView;
    }

}
