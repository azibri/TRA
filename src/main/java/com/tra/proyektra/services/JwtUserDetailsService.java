///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tra.proyektra.services;
//
//import java.util.ArrayList;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author asus
// */
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("bambang".equals(username)) {
//            return new User("bambang", "$2b$10$is9U2n06VpSaHQwpBi7M4eUTo9n8JK0bE5WxNczWFUq6MKDIbNtyS", 
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("user not found with username" + username);
//        }
//    }
//    
//}
