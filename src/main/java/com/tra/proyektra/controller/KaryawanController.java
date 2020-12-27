/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Divisi;
import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.repository.RepoKaryawan;
import com.tra.proyektra.services.DivisiInterface;
import com.tra.proyektra.services.KaryawanInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author asus
 */
@Controller
public class KaryawanController {

    @Autowired
    private KaryawanInterface karyawanInterface;
    
    @Autowired
    private DivisiInterface divisiInterface;


    @RequestMapping(value = "/karyawan")
    public String allkaryawan(Model model) {
        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        
        return "/karyawan";
    }

    @RequestMapping(value = "/addkaryawan")
    public String addkaryawan(Model model) {
        Karyawan karyawan = new Karyawan();
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
        
        model.addAttribute("karyawan", karyawan);
        return "/karyawanadd";
    }

//    @RequestMapping(value = "/savekaryawan", method = RequestMethod.POST)
//    public String savekaryawan(Karyawan karyawan, @RequestParam("tanggallahir") String tanggallahir) throws ParseException {
//        
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggallahir1 = format.parse(tanggallahir);
//        
//        Date tanggallahir2 = new java.sql.Date(tanggallahir1.getTime());
//                
//        karyawanInterface.savekaryawan(karyawan, tanggallahir2);
//        return "redirect:/karyawan";
//    }
    
    @RequestMapping(value = "/savekaryawan", method = RequestMethod.POST)
    public String savekaryawan(
            @RequestParam("karyawan") Integer karyawan_id,
            @RequestParam("divisi") Integer divisi_id,
            @RequestParam("nama") String namakaryawan,
            @RequestParam("jeniskelamin") String jeniskelamin,
            @RequestParam("tanggallahir") String tanggallahir,
            @RequestParam("email") String email,
            @RequestParam("alamat") String alamat,
            @RequestParam("role") String role ) throws ParseException {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggallahir1 = format.parse(tanggallahir);
        
        Date tanggallahir2 = new java.sql.Date(tanggallahir1.getTime());
                
        karyawanInterface.savekaryawan(karyawan_id, divisi_id, namakaryawan, jeniskelamin, tanggallahir2,
                email, alamat, role);
        return "redirect:/karyawan";
    }
    
//    @RequestMapping(value = "/editkaryawan/{id}")
//    public ModelAndView editkaryawan(@PathVariable(name = "id") int karyawan_id, Model model) {
//        
//        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
//        ModelAndView edit = new ModelAndView("karyawanedit");
//        Karyawan karyawan = karyawanInterface.getKaryawan(karyawan_id);
//        edit.addObject("karyawan", karyawan);
//        
//        return edit;
//    }
    
    @RequestMapping(value = "/editkaryawan/{id}")
    public String editkaryawan(@PathVariable(name = "id") int karyawan_id, Model model) {
        Karyawan karyawan = karyawanInterface.getKaryawan(karyawan_id);
        model.addAttribute("karyawan", karyawan);
        
        Integer karyawanid = karyawanInterface.getKaryawan(karyawan_id).getKaryawanId();
        
        Integer divisiid = divisiInterface.caridivisi(karyawanid).getDivisiId();
        String nama = karyawanInterface.getKaryawan(karyawan_id).getKaryawanNama();
        String jeniskelamin = karyawanInterface.getKaryawan(karyawan_id).getKaryawanJenisKelamin();
        Date tanggallahir = karyawanInterface.getKaryawan(karyawan_id).getKaryawanTanggalLahir();
        String email = karyawanInterface.getKaryawan(karyawan_id).getKaryawanEmail();
        String alamat = karyawanInterface.getKaryawan(karyawan_id).getKaryawanAlamat();
        String role = karyawanInterface.getKaryawan(karyawan_id).getKaryawanRole();
        
        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
        
        model.addAttribute("karyawan_id", karyawanid);
        model.addAttribute("divisi_id", divisiid);
        model.addAttribute("karyawannama", nama);
        model.addAttribute("karyawanjeniskelamin", jeniskelamin);
        model.addAttribute("karyawantanggallahir", tanggallahir);
        model.addAttribute("karyawanemail", email);
        model.addAttribute("karyawanalamat", alamat);
        model.addAttribute("karyawanrole", role);
        System.out.println(karyawanid);
        System.out.println(divisiid);
        
        
//        model.addAttribute("listdivisi", divisiInterface.findAlldivisi());
//        ModelAndView edit = new ModelAndView("karyawanedit");
//        Karyawan karyawan = karyawanInterface.getKaryawan(karyawan_id);
//        edit.addObject("karyawan", karyawan);
        
//        return edit;
        return "karyawanedit";
    }
    
    @RequestMapping(value = "/deletekaryawan/{id}", method = RequestMethod.GET)
    public String deletekaryawan(@PathVariable(name = "id") int karyawan_id) {
        
        karyawanInterface.deletekaryawan(karyawan_id);
        return "redirect:/karyawan";
    }
    

}
