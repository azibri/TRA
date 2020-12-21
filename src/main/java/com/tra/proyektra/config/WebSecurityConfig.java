/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author asus
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/karyawa*", "/karyawan/", "/perjalana*", "/perjalanan/", "/tujuandina*", "/divis*", "/kendaraa*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/pengajua*", "/pengajuan/").access("hasRole('ROLE_USER')")
                .antMatchers("/persetujuan*", "/persetujuan/").access("hasRole('ROLE_MANAJER')")
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/index")
                .successHandler(customSuccessHandler)
                .and()
//                .anonymous().disable()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .addLogoutHandler(new Logout())
                .logoutSuccessUrl("/login")
                .permitAll();

    }

//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//// getUsername() - Returns the username used to authenticate the user.
//    System.out.println("User name: " + userDetails.getUsername());
//
//// getAuthorities() - Returns the authorities granted to the user.
//    System.out.println("User has authorities: " + userDetails.getAuthorities());
    
    
}
