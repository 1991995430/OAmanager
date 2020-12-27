package com.offcn.controller;

import com.offcn.pojo.Notice;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author songmu
 * @create 2019-06-25 19:43
 */
@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/addNotice")
    @ResponseBody
    public Msg addNotice(Notice notice){
        Msg msg = new Msg();
        notice.setNdate(new Date());
        int istate = noticeService.insert(notice);
        if(istate!=1){
            msg.setMsgCode(500);
            msg.setMsg("添加失败！");
        }
        return msg;
    }

    @RequestMapping("/getNoticeList")
    @ResponseBody
    public List<Notice> getNoticeList(){
        return noticeService.selectByExample();
    }

    @RequestMapping("/getNoticeListOrder")
    @ResponseBody
    public List<Notice> getNoticeListOrder(){
        return noticeService.selectnoticeOrderByTime();
    }

    @RequestMapping("/getNoticeListOrderByNid")
    @ResponseBody
    public Notice getNoticeListOrderByNid(Integer nid){

         Notice notice = noticeService.selectnoticeOrderByNid(nid);
        return notice;
    }

}
