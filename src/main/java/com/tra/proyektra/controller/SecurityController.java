/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.services.KaryawanImplement;
import com.tra.proyektra.services.PengajuanInterface;
import com.tra.proyektra.services.PerjalananInterface;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class SecurityController {

//    @Autowired
//    KaryawanImplement karyawanImplement;
    @Autowired
    PengajuanInterface pengajuanInterface;

    @Autowired
    KaryawanImplement karyawanImplement;

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> hal = auth.getAuthorities();
//        List<String> roles = new ArrayList<String>();
//        
//        for (GrantedAuthority a : hal) {
//            roles.add(a.getAuthority());
//        }
//        
////        System.out.println("ini " +hal);
//        if(auth == null || auth instanceof AnonymousAuthenticationToken){
////            System.out.println("ini "+auth);
//           return "login"; 
//        }
//        else if (roles.contains("ROLE_USER")) {
//            return "/indexuser";
//        } else if (roles.contains("ROLE_ADMIN")) {
//            return "/indexadmin";
//        } 
//        else if (roles.contains("ROLE_MANAJER")) {
//            return "/indexmanajer";
//        }
////        return "login";
//        return "redirect:/";
//    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        System.out.println("ini " +hal);
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
//            System.out.println("ini "+auth);
            return "login";
        }

//        return "login";
        return "redirect:/404";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        
//        return "login";
//    }
//    
    @RequestMapping(value = "/")
    public String unmaping(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        System.out.println("ini " +hal);
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
//            System.out.println("ini "+auth);
            return "login";
        }

//        return "login";
        return "redirect:/404";
    }

    @RequestMapping(value = "/404")
    public String error() {
        return "404";
    }
//    @RequestMapping(value = "/indexadmin", method = RequestMethod.GET)
//    public String indexadmin() {
//        return "indexadmin";
//    }
//
//    @RequestMapping(value = "/indexuser", method = RequestMethod.GET)
//    public String indexuser(Model model) {
//        
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String nama = auth.getName();
//        System.out.println(nama);
//        Iterable<Pengajuan> pengajuan = pengajuanInterface.findPengajuan(nama);
//        model.addAttribute("listpengajuan", pengajuan);
//        
//        return "indexuser";
//    }
//
//    @RequestMapping(value = "/indexmanajer", method = RequestMethod.GET)
//    public String indexmanajer() {
//        return "indexmanajer";
//    }

//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    public String currentUserName(@AuthenticationPrincipal MyUserDetails userDetails, Model model) {
//        return principal.getName();
//    }
//    @RequestMapping(value = "/username", method = RequestMethod.GET)
////    @ResponseBody
//    public String currentUserName(ModelMap model) {
//      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//      String name = auth.getName();
//      model.addAttribute("username", name);
//      return "username";
//    }
//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Principal principal) {
//        
//        return principal.getName();
//    }
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public String currentUserName() {
        return "username";
    }

//    @RequestMapping(value = "/rincianpengajuan")
//    @ResponseBody
//    public String rincianpengajuan(Model model){
//       
//       model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
//       
//       return "/persetujuan";
//    }
//    
//    @RequestMapping(value = "/editkendaraan")
//    @ResponseBody
//    public Optional<Kendaraan> findKendaraan(Integer kendaraan_id){
//        return kendaraanInterface.findKendaraan(kendaraan_id);
//    }
}
