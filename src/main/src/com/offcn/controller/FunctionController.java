package com.offcn.controller;


import com.offcn.pojo.Function;
import com.offcn.pojo.FunctionWithBLOBs;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 16:27
 */
@Controller
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    @RequestMapping("/functionAdd")
    @ResponseBody
    public Msg functionAdd(FunctionWithBLOBs record){
        int istate = functionService.insert(record);
        Msg msg = new Msg();
        if(istate!=1){
          msg.setMsgCode(200);
          msg.setMsg("添加失败");
        }
        return msg;
    }

    @RequestMapping("/getFunction")
    @ResponseBody
    public List<Function> getFunction(Integer modeleFk){

        List<Function> list =  functionService.selectByExample(modeleFk);

        return list;
    }

}
