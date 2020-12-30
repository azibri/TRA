/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    UserDetailsService userDetailsService;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // configure AuthenticationManager so that it knows from where to load
//        // user for matching credentials
//        // Use BCryptPasswordEncoder
//
//        auth.userDetailsService(userDetailsService);
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService);
////    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //dont authenticate this particular request
//                .authorizeRequests().antMatchers("/ini").permitAll()
//                //all other request need to be authentication
//                .anyRequest().authenticated()
//                .and()
                //make sure we use stateless session; session won't be used to
                //store user's state
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)                
//                .and()
                                .authorizeRequests()
                                .antMatchers("/indexadmin", "/karyawa*", "/karyawan/", "/perjalana*", "/perjalanan/", "/tujuandina*", "/divis*", "/kendaraa*").access("hasRole('ROLE_ADMIN')")
                                .antMatchers("/indexuser", "/pengajua*", "/pengajuan/").access("hasRole('ROLE_USER')")
                                .antMatchers("/indexmanajer", "/persetujuan*", "/persetujuan/").access("hasRole('ROLE_MANAJER')")
                                .antMatchers("/index").permitAll()
                                //                .antMatchers("/", "/index").permitAll()
                                .antMatchers("/").permitAll()
                                .antMatchers("/login").permitAll()
                                .antMatchers("/logout").permitAll()
                                .and()
                                .formLogin()
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginProcessingUrl("/dologin")
                                .defaultSuccessUrl("/")
                                .successHandler(customSuccessHandler)
                                .and()
                                //                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                                //                    @Override
                                //                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                                //                        response.sendError(403, "Forbidden");
                                //                    }
                                //                })
                                //                                .exceptionHandling().defaultAuthenticationEntryPointFor(new Http403ForbiddenEntryPoint(), new AntPathRequestMatcher("/index"))
                                //                                .authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                                //                                .and()
                                //                                .anonymous().disable()
                                //                .and()
                                .logout()
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .addLogoutHandler(new Logout())
                                .logoutSuccessUrl("/login")
                                .permitAll()
                ;

//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

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
