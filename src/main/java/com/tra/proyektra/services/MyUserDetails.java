/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Karyawan;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author asus
 */
public class MyUserDetails implements UserDetails{
    
    private String username;
    private String password;
    private Boolean active;
    private Integer id;
    private List<GrantedAuthority> authorities;
    
    
    public MyUserDetails (Karyawan karyawan) {
        this.username = karyawan.getKaryawanNama();
        this.password = karyawan.getKaryawanPassword();
        this.active = karyawan.getActive();
//        this.id = karyawan.getKaryawanId();
        this.authorities = Arrays.stream(karyawan.getKaryawanRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
    
//    public Integer id() {
//        return id;
//    }
    
}
