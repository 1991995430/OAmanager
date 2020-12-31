package com.offcn.controller;

import com.offcn.pojo.AnalysisWithBLOBs;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.AnalysisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author songmu
 * @create 2019-06-23 14:10
 */
@Controller
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    @RequestMapping("/addAnalysis")
    @ResponseBody
    public Msg addAnalysis(AnalysisWithBLOBs analysisWithBLOBs) {
        Msg msg = new Msg();

        int istate = analysisService.insert(analysisWithBLOBs);
        if (istate != 1) {
            msg.setMsgCode(500);
            msg.setMsg("添加失败");
        }
        msg.setMsgCode(200);
        msg.setMsg("添加成功");
        return msg;
    }


    @RequestMapping("/getAnalysis")
    @ResponseBody
    public List<AnalysisWithBLOBs> getAnalysis(@Param("proname") String proname) {


        List<AnalysisWithBLOBs> list = analysisService.selectByExampleWithBLOBs(proname);

        return list;
    }

}
