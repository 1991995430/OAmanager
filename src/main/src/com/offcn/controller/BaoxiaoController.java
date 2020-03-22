package com.offcn.controller;

import com.offcn.pojo.Baoxiao;
import com.offcn.pojo.Employee;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.BaoxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @author songmu
 * @create 2019-06-27 8:36
 */
@Controller
public class BaoxiaoController {
    @Autowired
    private BaoxiaoService baoxiaoService;
    @RequestMapping("/baoxiaoAdd")
    @ResponseBody
    public Msg baoxiaoAdd(Baoxiao baoxiao, HttpSession session){

        Employee employee = (Employee) session.getAttribute("employee");
        int empfk = 0;
        if(employee!=null){
            empfk = employee.getEid();
        }
        System.out.println("获取的eid:::"+empfk);
        Msg msg = new Msg();
        int i=0;

        baoxiao.setBxid(UUID.randomUUID().toString());
        baoxiao.setBxstatus(0);
        baoxiao.setEmpFk(empfk);
        int istate = baoxiaoService.insert(baoxiao);

        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("添加失败！");
        }
        return msg;
    }

    @RequestMapping("/getBaoxiaoList")
    @ResponseBody
    public List<Baoxiao> getBaoxiaoList(HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        int empfk = 0;
        if(employee!=null){
            empfk = employee.getEid();
        }
       return baoxiaoService.selectBaoxiaoPro(empfk);
    }


    @RequestMapping("/getBaoxiaoList1")
    @ResponseBody
    public List<Baoxiao> getBaoxiaoList1(){

        return baoxiaoService.selectBaoxiaoPro1();
    }



    @RequestMapping("/getBaoxiaoOne")
   // @ResponseBody
    public ModelAndView getBaoxiaoOne(String bxid){

        ModelAndView modelAndView = new ModelAndView();

        Baoxiao baoxiao = baoxiaoService.selectByPrimarykey(bxid);
        System.out.println(baoxiao);
        modelAndView.addObject("baoxiao",baoxiao);

        modelAndView.setViewName("/mybaoxiao-edit");

        return modelAndView;
    }

    @RequestMapping("/getBaoxiaoOne1")
    // @ResponseBody
    public ModelAndView getBaoxiaoOne1(String bxid){

        ModelAndView modelAndView = new ModelAndView();

        Baoxiao baoxiao = baoxiaoService.selectByPrimarykey(bxid);
        System.out.println(baoxiao);
        modelAndView.addObject("baoxiao",baoxiao);

        modelAndView.setViewName("/mybaoxiao-check");

        return modelAndView;
    }


    @RequestMapping("/editBaoxiao1")
    @ResponseBody
    public Msg editBaoxiaosp(Baoxiao baoxiao){
        Msg msg = new Msg();
        int istate = baoxiaoService.updateByExampleSelective1(baoxiao);
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("更新失败！");
        }
        return msg;
    }



    //editBaoxiao
    @RequestMapping("/editBaoxiao")
    @ResponseBody
    public Msg editBaoxiao(Baoxiao baoxiao){
        Msg msg = new Msg();
        int istate = baoxiaoService.updateByExampleSelective(baoxiao);
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("更新失败！");
        }
        return msg;
    }

    @RequestMapping("/baoxiaosp")
    public ModelAndView baoxiaosp(String bxid){

        Baoxiao baoxiao = baoxiaoService.selectByPrimarykey(bxid);
        baoxiao.setBxstatus(1);
        baoxiaoService.updateByExample(bxid,baoxiao);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mybaoxiao-base");
        return modelAndView;
    }

    @RequestMapping("/baoxiaoback")
    public ModelAndView baoxiaoback(String bxid){

        Baoxiao baoxiao = baoxiaoService.selectByPrimarykey(bxid);
        baoxiao.setBxstatus(2);
        baoxiaoService.updateByExample(bxid,baoxiao);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mybaoxiao-base");
        return modelAndView;
    }


}
