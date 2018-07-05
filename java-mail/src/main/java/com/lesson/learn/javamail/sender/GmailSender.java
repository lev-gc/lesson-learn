/*
 * Copyright (c) 2017. @author lev-gc
 */

package com.lesson.learn.javamail.sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * <b><code>GmailSender</code></b>
 * <p/>
 * GmailSender
 * <p/>
 * <b>Creation Time:</b> 2017/9/21 10:20.
 *
 * @author Elvis
 * @since java-mail 0.1.0
 */
public class GmailSender {

    /**
     * The Template of Gmail Sender.
     *
     * @param args the input arguments
     * @throws MessagingException           the messaging exception
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {

        Properties props = new Properties();
//        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        // use Type SSL
        props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        // or use Type TLS
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sender@gmail.com", "********");
            }
        });

        Message message = new MimeMessage(session);
        // From
        message.setFrom(new InternetAddress("sender@gmail.com", "Alias of sender"));
        // TO
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{
                new InternetAddress("ToReceiver1@*****.com", "Alias of TO receiver1"),
                new InternetAddress("ToReceiver2@*****.com", "Alias of TO receiver2")
        });
        // CC
        message.setRecipients(Message.RecipientType.CC, new InternetAddress[]{
                new InternetAddress("CcReceiver@*****.com", "Alias of CC receiver")
        });
        // BCC
        message.setRecipients(Message.RecipientType.BCC, new InternetAddress[]{
                new InternetAddress("BccReceiver@*****.com", "Alias of BCC receiver")
        });

        // set Title
        message.setSubject("JavaMail Test");
        // set Send Date
        message.setSentDate(new Date());

        // set Content
        message.setText("Here is the mail send by JavaMail using Gmail!");
        // Note: or you can send email in html with setContent("html string","text/html")
//        message.setContent("<h1>Here is the mail send by JavaMail using Gmail!</h1>","text/html");

        Transport.send(message);
    }

}
