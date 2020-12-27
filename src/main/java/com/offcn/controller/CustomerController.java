package com.offcn.controller;

import com.offcn.pojo.Customer;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-19 14:13
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/addCustomer")
    @ResponseBody
    public Msg addCustomer(Customer customer){
        int istate = customerService.insert(customer);
        Msg msg=new Msg();
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("添加失败!");
        }
        return msg;
    }

    @RequestMapping("/customerlist")
    @ResponseBody
    public List<Customer> customerList(Integer searchType,String key,String order){
        List<Customer> list = customerService.selectByExample(searchType,key,order);
        return list;
    }

    @RequestMapping("/customerdel")
    @ResponseBody
    public Msg customerDel(Integer[] ids){
        //调用批量删除

        Msg msg=new Msg();
        int i=0;
        try {
            i=customerService.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            msg.setMsg("操作错误");
            msg.setMsgCode(500);
        }
        return msg;
    }

    //修改页面跳转
    @RequestMapping("/customermodifyview")
    public ModelAndView customerModifyView(Integer id){
        Customer customer=customerService.selectByPrimaryKey(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer",customer);
        modelAndView.setViewName("customer-edit");
        return modelAndView;
    }

    @RequestMapping("/customermodify")
    @ResponseBody
    public Msg customerModify(Customer customer){
        int istate = customerService.updateByPrimaryKey(customer);
        Msg msg=new Msg();
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("修改失败");
        }
        return msg;
    }

    @RequestMapping("/customerbyproject")
    @ResponseBody
    public List<Customer> customerByProjectList(){
        List<Customer> list = customerService.selectByProjectExample();
        return list;
    }

    @RequestMapping("/customerinfobyproject")
    @ResponseBody
    public Customer customerInfoByProject(Integer id){
        Customer customer=customerService.selectByPrimaryKey(id);
        return customer;
    }

}
