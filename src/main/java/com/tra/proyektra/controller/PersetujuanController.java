/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.repository.RepoPengajuan;
import com.tra.proyektra.services.ApprovalInterface;
import com.tra.proyektra.services.KaryawanImplement;
import com.tra.proyektra.services.KaryawanInterface;
import com.tra.proyektra.services.KendaraanInterface;
import com.tra.proyektra.services.PengajuanInterface;
import com.tra.proyektra.services.TujuandinasInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class PersetujuanController {
    
    @Autowired
    private PengajuanInterface pengajuanInterface;
    
    @Autowired
    private TujuandinasInterface tujuandinasInterface;

    @Autowired
    private KendaraanInterface kendaraanInterface;

    @Autowired
    private ApprovalInterface approvalInterface;

    @Autowired
    private KaryawanInterface karyawanInterface;

    @Autowired
    private KaryawanImplement karyawanImplement;

    @Autowired
    RepoPengajuan repoPengajuan;
    
    @RequestMapping(value = "/persetujuan")
    public String allpengajuan(Model model){
       
       model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
       
       return "/persetujuan";
    }
    
    
    @RequestMapping(value = "/komentar")
    @ResponseBody
    public Optional<Pengajuan> komentar(Integer pengajuan_id){
//        Pengajuan pengajuan = pengajuanInterface.getPengajuan(pengajuan_id);
//        
//        Integer ini = pengajuanInterface.getPengajuan(pengajuan_id).getPengajuanId();
//        System.out.println(ini);
//        
//        Integer kendaraanid = kendaraanInterface.listpengajuan(ini).getKendaraanId();
//        model.addAttribute("kendaraan_id", kendaraanid);
//        
//        System.out.println(kendaraanid);
//        
//        Integer tujuandinasid = tujuandinasInterface.listpengajuan(ini).getTujuandinasId();
//        model.addAttribute("tujuandinas_id", tujuandinasid);
//        System.out.println(tujuandinasid);
//        
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String nama = auth.getName();
//
//        Integer hal = karyawanImplement.findId(nama).getKaryawanId();
//
//        model.addAttribute("idkaryawan", nama);
//        model.addAttribute("karyawan_id", hal);
        
        return pengajuanInterface.komentar(pengajuan_id);
    }

//    @RequestMapping(value = "/simpanpengajuan", method = RequestMethod.POST)
//    public String simpanpengajuan(Pengajuan pengajuan, 
//            @RequestParam("pengajuanTanggalBerangkat") String tanggalberangkat,
//            @RequestParam("pengajuanTanggalPulang") String tanggalpulang) throws ParseException {
//        
//        
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggalpengajuan = formatter.parse(tanggalberangkat);
//        Date tanggalPulang = formatter.parse(tanggalpulang);
//
//        Date dateBerangkat = new java.sql.Date(tanggalpengajuan.getTime());
//        Date datePulang = new java.sql.Date(tanggalPulang.getTime());
//        
//        pengajuanInterface.simpanpengajuan(pengajuan, dateBerangkat, datePulang);
//        
//        return "redirect:/pengajuan";
//    }
    
//    @RequestMapping(value = "/savepengajuan", method = RequestMethod.POST)
//    public String savePengajuan(Pengajuan pengajuan) {
//        
//        pengajuanInterface.saveeditPengajuan(pengajuan);
//        
//        return "redirect:/pengajuan";
//    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatepengajuan(@PathVariable (value = "id") int pengajuan_id,
            @RequestParam (value = "approval") int approval_id,
            Model model){
        
//        model.addAttribute(status, model)
        System.out.println("approval" +approval_id);
        pengajuanInterface.updatePengajuan(pengajuan_id, approval_id);
//        pengajuanInterface.savePengajuan(pengajuan);
//        System.out.println(pengajuan);
        return "redirect:/persetujuan";
    }
    
}
