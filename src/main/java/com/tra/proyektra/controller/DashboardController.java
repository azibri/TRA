/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.tra.proyektra.config.PengajuanList;
import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.services.KaryawanInterface;
import com.tra.proyektra.services.PengajuanInterface;
import com.tra.proyektra.services.PerjalananInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class DashboardController {

    @Autowired
    private PengajuanInterface pengajuanInterface;

    @Autowired
    private KaryawanInterface karyawanInterface;

    @Autowired
    private PerjalananInterface perjalananInterface;

    @RequestMapping(value = "/jeniskelamin", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public List<Object[]> jeniskelamin(Model model) {
        model.addAttribute("jeniskelamin", karyawanInterface.jeniskelamin());;

        return karyawanInterface.jeniskelamin();
    }

    @RequestMapping(value = "/grafikperjalanan", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public List<Object[]> perjalanan(Model model) {
        model.addAttribute("perjalan", perjalananInterface.perjalanan());;

        return perjalananInterface.perjalanan();
    }

    @RequestMapping(value = "/indexadmin", method = RequestMethod.GET)
    public String indexadmin(Model model) {

        long totalkaryawan = karyawanInterface.karyawan();
        long totalditerima = pengajuanInterface.diterima();
        long telahdiproses = perjalananInterface.diproses();
        float rerata = perjalananInterface.rerata();

        model.addAttribute("totalkaryawan", totalkaryawan);
        model.addAttribute("totalditerima", totalditerima);
        model.addAttribute("telahdiproses", telahdiproses);
        model.addAttribute("rerata", rerata);

        return "indexadmin";
    }

    @RequestMapping(value = "/totalpengajuanuser", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public List<Object[]> totalpengajuanuser(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        model.addAttribute("totalpengajuanuser", pengajuanInterface.totalpengajuanuser(nama));;

        return pengajuanInterface.totalpengajuanuser(nama);
    }

    @RequestMapping(value = "/indexuser", method = RequestMethod.GET)
    public String indexuser(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        Iterable<Pengajuan> pengajuan = pengajuanInterface.findPengajuan(nama);
        model.addAttribute("listpengajuan", pengajuan);

        long totalpengajuan = pengajuanInterface.pengajuanuser(nama);
        model.addAttribute("totalpengajuan", totalpengajuan);

        return "indexuser";
    }

    @RequestMapping(value = "/totalpengajuan", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public List<Object[]> totalpengajuan(Model model) {
        model.addAttribute("totalpengajuan", pengajuanInterface.totalpengajuan());;

        return pengajuanInterface.totalpengajuan();
    }

    @RequestMapping(value = "/indexmanajer", method = RequestMethod.GET)
    public String indexmanajer(Model model) {

        long totalpengajuan = pengajuanInterface.hitung();

        long totalpending = pengajuanInterface.menunggu();

        long totalditerima = pengajuanInterface.diterima();

//        System.out.println("diterima " + totalditerima);
        long totalditolak = pengajuanInterface.ditolak();

//        List<String> month = new ArrayList<>();
//        List<Integer> profitChart = new ArrayList<>();
//        List<TanggalAndTotalharga> tahunProfit = transaksiService.getProfitByYear();
//        for (TanggalAndTotalharga tahunProfits : tahunProfit) {
//            month.add(tahunProfits.getBulan());
//            profitChart.add(tahunProfits.getLaba_Bersih());
//        }
//        List<Long> jumlahpengajuan = new ArrayList<>();
//        List<String> bulanpengajuan = new ArrayList<>();
//        
//        List<PengajuanList> pengajuan = pengajuanInterface.totalpengajuan();
//        for (PengajuanList pengajuanList : pengajuan) {
//            bulanpengajuan.add(pengajuanList.getBulan());
//            jumlahpengajuan.add(pengajuanList.getTotal_Pengajuan());
//        }
        model.addAttribute("totalpengajuan", totalpengajuan);
        model.addAttribute("totalmenunggu", totalpending);
        model.addAttribute("totalditerima", totalditerima);
        model.addAttribute("totalditolak", totalditolak);
//        model.addAttribute("bulanpengajuan", bulanpengajuan);
//        model.addAttribute("jumlahpengajuan", jumlahpengajuan);
        return "indexmanajer";
    }

}
