///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tra.proyektra.controller;
//
//import com.tra.proyektra.services.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// *
// * @author asus
// */
//public class EmailController {
//    
//    @Autowired
//    private EmailService emailService;
//    
////    @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
////    public String notif() {
////        return "sendemail";
////    }
//    
//    @RequestMapping(value = "/template")
//    public String email() throws Exception {
//        System.out.println("masuk send email");
//        String email = "azibrian66@gmail.com";
////        String name = "azibrian66@gmail.com";
//        
//        emailService.notif(email);
//        return "redirect:/pengajuan";
//    }
//    
//}
