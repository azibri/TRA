/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.repository.RepoKaryawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private RepoKaryawan repoKaryawan;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Karyawan karyawan = repoKaryawan.findKaryawan(username);
        
        if (karyawan == null) throw new UsernameNotFoundException(username);
        
        return new MyUserDetails(karyawan);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
