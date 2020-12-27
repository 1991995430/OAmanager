package com.offcn.controller;

import com.offcn.pojo.ModuleWithBLOBs;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-24 18:52
 */
@Controller
public class ModelController {
    @Autowired
    private ModelService modelService;

    @RequestMapping("/modelAdd")
    @ResponseBody
    public Msg modelAdd(ModuleWithBLOBs moduleWithBLOBs){

        int istate = modelService.insert(moduleWithBLOBs);
        Msg msg = new Msg();
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("添加失败！");
        }
        return msg;
    }

    @RequestMapping("/getModel")
    @ResponseBody
    public List<ModuleWithBLOBs> getModel(Integer analysisFk){

       List<ModuleWithBLOBs> list = modelService.selectByExampleWithBLOBs(analysisFk);

       return list;
    }
}
