package com.offcn.utils;

import com.offcn.pojo.Msg;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.*;

/**
 * @author songmu
 * @create 2019-06-26 7:57
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("*********************************************");
        System.out.println("执行定时任务中的业务操作");

        Msg msg = (Msg) jobExecutionContext.getMergedJobDataMap().get("msg");
        //JDBC执行sql语句
        //创建连接
        Connection connection=null;
        try {
            //获取驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/crmpro1?useUnicode=true&amp;characterEncoding=utf-8","root","123456");
            //执行sql语句
            PreparedStatement statement = connection.prepareStatement("insert into `crmpro1`.`msg`(`sendp`,`recvp`,mark,`msgcontent`,`msgtime`) values (?,?,?,?,?)");
            statement.setInt(1,msg.getSendp());
            statement.setInt(2,msg.getRecvp());
            statement.setInt(3,msg.getMark());
            statement.setString(4,msg.getMsgcontent());
            statement.setDate(5,new Date(msg.getMsgtime().getTime()));
            int istate = statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}