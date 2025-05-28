package com.mjc813.gradle;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    static Properties prop;
    static Session session;
    static MimeMessage message;

    public static void main(String[] args) throws Exception {
        generateAndSendEmail();
        System.out.println("\n\n ====> Your Java Program has just sent an Email successfully. Check your email..");
    }
    public static void generateAndSendEmail() throws Exception {
        final String user = "@naver.com"; // 발신자의 이메일 아이디를 입력
        final String password = ""; // 발신자의 비밀번호

        // step1 프로퍼티 생성
        prop = new Properties();

        prop.put("mail.smtp.host", "smtp.naver.com");
        // mail smtp.host는 이메일 발송을 처리해줄 smtp 서버를 나타냄
        prop.put("mail.smtp.port", 465);

        prop.put ("mail.smtp.auth", "true");

        prop.put("mail.smtp.ssl.enable", "true");

        prop.put("mail.smtp.ssl.trust", "smtp.naver.com");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress("@gmail.com")); //수신자의메일주소

            //Subject
            message.setSubject("제목을 입력하세요");

            //text
            message.setText("내용을 입력하세요");

            Transport.send(message); // 전송
            System.out.println("message sent successfully....");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}