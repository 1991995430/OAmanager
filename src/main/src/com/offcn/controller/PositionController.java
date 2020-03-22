package com.offcn.controller;

import com.offcn.pojo.Position;
import com.offcn.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-29 16:56
 */
@Controller
public class PositionController {

    @Autowired
    private PositionService positionService;
    @RequestMapping("/getPositionList")
    @ResponseBody
    public List<Position> getPositionList(){
        return positionService.selectByExample(null);
    }


}
