///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tra.proyektra.config;
//
//import javax.activation.DataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.servlet.view.XmlViewResolver;
//
///**
// *
// * @author asus
// */
//@Configuration
//public class ReportConfig {
//
//    @Bean(name = "db")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return (DataSource) DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate jdbcTemplate(@Qualifier("db") DataSource ds) {
//        return new JdbcTemplate((javax.sql.DataSource) ds);
//    }
////@Bean
////public XmlViewResolver xmlViewResolver(){
////   XmlViewResolver xmlViewResolver=new XmlViewResolver();
////   xmlViewResolver.setOrder(0);
////   return xmlViewResolver;
////}
//}
