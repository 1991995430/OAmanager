package com.offcn.controller;

import com.offcn.pojo.Employee;
import com.offcn.pojo.pojopv.Msg;
import com.offcn.utils.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author songmu
 * @create 2019-06-26 7:54
 */
@Controller
public class MsgController {

    @RequestMapping("/sendMsg")
    @ResponseBody
    public Msg sendMsg(com.offcn.pojo.Msg msg, HttpSession session){

        //创建定时任务
        //1)创建Scheduler
        SchedulerFactory factory=new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();

            //2)触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triger1")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule())
                    .startAt(msg.getMsgtime())
                    .build();

            //3)任务jobDetail
            JobDetail jobDetail= JobBuilder.newJob(MyJob.class)
                    .withIdentity("jobDetial1")
                    .build();

            //传递数据到job
            Employee employee = (Employee) session.getAttribute("employee");
            msg.setSendp(employee.getEid());
            msg.setMark(0);
            jobDetail.getJobDataMap().put("msg",msg);//将数据传递给Job

            //4)将触发器和任务注册到Scheduler
            scheduler.scheduleJob(jobDetail,trigger);
            //5)启动Scheduler
            if(!scheduler.isShutdown()) {
                scheduler.start();
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        Msg ajaxMsg=new Msg();
        return ajaxMsg;
    }
}
