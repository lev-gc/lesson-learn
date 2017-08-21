/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * <b><code>JavaMail</code></b>
 * <p/>
 * JavaMail
 * <p/>
 * <b>Creation Time:</b> 2017/4/17 19:14.
 *
 * @author Elvis
 * @since LessonLearn 0.1
 */
public class JavaMail {

    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
//        props.setProperty("mail.debug", "true");

        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.exmail.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(props);

        // Message Object
        Message msg = new MimeMessage(session);
        // Title
        msg.setSubject("From JavaMail");
        // Content
        msg.setText("Mail From JavaMail ! ");
        // From
        msg.setFrom(new InternetAddress("chenzechao@richstonedt.com"));

        Transport transport = session.getTransport();
        transport.connect("chenzechao@richstonedt.com", "RYlzz3OK2Z3r4oDX");
        transport.sendMessage(msg, new Address[]{new InternetAddress("chenzechao@richstonedt.com")});
        transport.close();
    }

}
