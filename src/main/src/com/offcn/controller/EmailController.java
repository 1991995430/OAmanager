package com.offcn.controller;

import com.offcn.pojo.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author songmu
 * @create 2019-06-26 16:39
 */
@Controller
public class EmailController {

        @RequestMapping("/sendemail")
        public String sendEmail (@RequestParam("file") MultipartFile file, Email email, String em, HttpServletRequest request){
            //发件人信息（用户名和密码）
            String fromAccount = "s1991995430@163.com";
            String fromPwd = "shangsong199551";//邮箱登录密码

            //收件人
            String revAccount = em;

            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", "smtp.163.com");
            props.setProperty("mail.smtp.auth", "true");

            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //账号:登录账号,密码:授权码
                    return new PasswordAuthentication("s1991995430", "s1991995430");
                }
            };
            //javaMail提供连接发送邮件的服务器
            //pro配置连接服务器的信息
            //auth登录服务器的授权码
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);

            //邮件消息内容
            MimeMessage message = new MimeMessage(session);

            try {
                //发件人
                message.setFrom(new InternetAddress(fromAccount));
                //抄送给发件人
                message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(fromAccount));
                //收件人
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(revAccount));
                //消息头
                message.setSubject(email.getTitle(), "utf-8");

                //邮箱内容
                BodyPart bodyPart = new MimeBodyPart();
                bodyPart.setText(email.getContent());

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(bodyPart);

                //添加附件
                if (file.getSize() > 0) {
                    //上传到服务器
                    String realPath = request.getServletContext().getRealPath("upload");
                    String fielName = file.getOriginalFilename();
                    String filePath = realPath + "/" + fielName;
                    File file1 = new File(filePath);
                    try {
                        //将文件上传到指定路径下
                        file.transferTo(file1);

                        //添加到multipart中
                        DataSource dataSource = new FileDataSource(file1);
                        bodyPart = new MimeBodyPart();
                        bodyPart.setDataHandler(new DataHandler(dataSource));
                        bodyPart.setFileName(MimeUtility.encodeText(fielName));

                        multipart.addBodyPart(bodyPart);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                message.setContent(multipart);//发送邮件内容

                message.setSentDate(new Date());//发送时间
                message.saveChanges();//保存设置

                //邮件发送
                Transport transport = session.getTransport();
                //登录账号:邮箱账号,登录密码:邮箱密码
                transport.connect(fromAccount, fromPwd);//建立连接
                transport.sendMessage(message, message.getAllRecipients());//设置发送内容,和发送地址
                transport.close();

            } catch (MessagingException e) {
                e.printStackTrace();
            }

            return "email";
        }
    }
