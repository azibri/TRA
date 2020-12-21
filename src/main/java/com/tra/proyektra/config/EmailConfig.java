///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tra.proyektra.config;
//
//import java.util.Properties;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
///**
// *
// * @author asus
// */
//@Configuration
//public class EmailConfig {
//    @Value("smtp.gmail.com")
//    private String host;
//    
//    @Value("587")
//    private Integer port;
//    
//    
//    public JavaMailSender javaMailSender() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        
//        javaMailSender.setHost(host);
//        javaMailSender.setPort(port);
//        javaMailSender.setUsername("Enter your gmail username");
//        javaMailSender.setPassword("enter your gmail password");
//        
//        javaMailSender.setJavaMailProperties(getMailProperties());
//        return javaMailSender;
//    }
//    
//    private Properties getMailProperties() {
//        
//        Properties properties = new Properties();
//        properties.setProperty("mail.transport.protocol", "smtp");
//        properties.setProperty("mail.smpt.auth", "true");
//        properties.setProperty("mail.smpt.starttls.enable", "true");
//        properties.setProperty("mail.smpt.socketFactory.class", "java.net.ssl.SSLSocketFactory");
//        properties.setProperty("mai.debug", "true");
//        
//        
//        return  properties;
//        
//    }
//    
//}
