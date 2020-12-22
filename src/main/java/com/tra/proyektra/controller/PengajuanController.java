/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.lowagie.text.DocumentException;
import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.entities.Kendaraan;
import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.report.PerjalananPdfExporter;
import com.tra.proyektra.repository.RepoPengajuan;
import com.tra.proyektra.services.ApprovalInterface;
import com.tra.proyektra.services.KaryawanImplement;
import com.tra.proyektra.services.KaryawanInterface;
import com.tra.proyektra.services.KendaraanInterface;
import com.tra.proyektra.services.PengajuanImplement;
import com.tra.proyektra.services.PengajuanInterface;
import com.tra.proyektra.services.ReportService;
import com.tra.proyektra.services.TujuandinasInterface;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author asus
 */
@Controller
public class PengajuanController {

    @Autowired
    private PengajuanImplement pengajuanInterface;

//    @Autowired
//    private PengajuanInterface pengajuanInterface1;
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
    
    

//    @RequestMapping(value = "/pengajuan")
//    public ModelMap allpengajuan(Authentication currentUser){
//        ModelMap mm = new ModelMap();
//       
//        karyawanInterface.findKaryawan(currentUser.getName())
//                .ifPresent(p->{
//                    mm.addAttribute("listpengajuan", pengajuanInterface.findPengajuan(p));
//                });
//        return mm;
//       
////        pengajuanInterface.findPengajuan(currentUser.getName(karyawan_id));
//////       model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
////       model.addAttribute("listpengajuan", pengajuanInterface.findPengajuan(karyawan_id));
//////       
////       
////       return "/pengajuan";
//    }
    @RequestMapping(value = "/pengajuan")
    public String allpengajuan(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nama = auth.getName();
        System.out.println(nama);
        Iterable<Pengajuan> pengajuan = pengajuanInterface.findPengajuan(nama);
        model.addAttribute("listpengajuan", pengajuan);

//        String delete = "0";
//        Iterable<Pengajuan> softdelete = pengajuanInterface.allsoftdelete(nama, delete);
//        model.addAttribute("listpengajuan", softdelete);
//        @Override
//    public Iterable<Pengajuan> lihat(String lihat) {
//        return repoPengajuan.allapproval(lihat);
//    }
//
//    @Override
//    public void softDelete(Integer id) {
//        repoPengajuan.deleteById(id);
//    }
//        for (Pengajuan pengajuan1 : pengajuan) {
//            System.out.println("hasil");
//            System.out.println(pengajuan1.getKaryawanId().getKaryawanNama());
//            System.out.println(pengajuan1.getKendaraanId().getKendaraanNama());
//        }
//       model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
//       model.addAttribute("listpengajuan", pengajuanInterface.findPengajuan(karyawan_id);
//       model.addAttribute("listpengajuan", pengajuanInterface.findPengajuan(nama));
        return "/pengajuan";
    }

//    @RequestMapping("/dashboardUser")
//    public String dashboardPageList(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
//    User user = (User) repo.findUserByUsername(currentUser.getUsername());
//        model.addAttribute("currentStudent", user);
//
//        return "dashboardUser";
//    }
    @RequestMapping(value = "/addpengajuan", method = RequestMethod.GET)
    public String addpengajuan(Model model) {
//        Pengajuan hal = (Pengajuan) repoPengajuan.findUserByUsername(currentUser.getKaryawanId());
//        model.addAttribute("nama", hal);

        Pengajuan pengajuan = new Pengajuan();

//        @AuthenticationPrincipal Pengajuan hal = (Pengajuan)authentication.getPrincipal();
//        Karyawan userId = customUser.getKaryawanId();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Pengajuan hal = (Pengajuan)auth.getPrincipal();
////        Pengajuan hal = (Pengajuan) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       String nama = auth.getName();
//       Karyawan i = hal.getKaryawanId();
//       String i = hal.getUsername();
//       model.addAttribute("ini", i);
//        System.out.println(i);
//        System.out.println(nama);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nama = auth.getName();

        Integer hal = karyawanImplement.findId(nama).getKaryawanId();

        model.addAttribute("idkaryawan", nama);
        model.addAttribute("karyawan_id", hal);

//        Iterable<Pengajuan> pengajuan = pengajuanInterface.findPengajuan(nama);
//        model.addAttribute("listpengajuan", pengajuan);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String nama = auth.getName();
//        System.out.println(nama);
//        Pengajuan findId = pengajuanInterface.findId(nama);
//        model.addAttribute("id", findId);
        model.addAttribute("listkendaraan", kendaraanInterface.findAllkendaraan());

        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());

        model.addAttribute("listapproval", approvalInterface.findAllapproval());

        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());

        model.addAttribute("pengajuan", pengajuan);

        List<String> listWaktuBerangkat = Arrays.asList("00.00 - 06.00", "06.00 - 12.00", "12.00 - 18.00", "18.00 - 00.00");
        model.addAttribute("listWaktuBerangkat", listWaktuBerangkat);

        System.out.println("add");
//        System.out.println(pengajuan);
        return "/pengajuanadd";
    }

    @RequestMapping(value = "/savepengajuan", method = RequestMethod.POST)
    public String savepengajuan(
            @RequestParam("pengajuanId") Integer pengajuan_id,
            @RequestParam("karyawan_id") Integer karyawan_id,
            @RequestParam("tujuandinas") Integer tujuandinas_id,
            @RequestParam("jeniskendaraan") Integer jeniskendaraan_id,
            @RequestParam("pengajuankotaasal") String pengajuankotaasal,
            @RequestParam("pengajuankotatujuan") String pengajuankotatujuan,
            @RequestParam("pengajuanwaktuberangkat") String pengajuanwaktuberangkat,
            @RequestParam("pengajuanwaktupulang") String pengajuanwaktupulang,
            @RequestParam("pengajuantanggalberangkat") String pengajuantanggalberangkat,
            @RequestParam("pengajuantanggalpulang") String pengajuantanggalpulang,
            @RequestParam("pengajuanhotel") String pengajuanhotel) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalpengajuan = formatter.parse(pengajuantanggalberangkat);
        Date tanggalPulang = formatter.parse(pengajuantanggalpulang);

        Date dateBerangkat = new java.sql.Date(tanggalpengajuan.getTime());
        Date datePulang = new java.sql.Date(tanggalPulang.getTime());
        
        
        pengajuanInterface.savePengajuan(pengajuan_id, karyawan_id, tujuandinas_id,
                jeniskendaraan_id, pengajuankotaasal, pengajuankotatujuan, pengajuanwaktuberangkat,
                pengajuanwaktupulang, dateBerangkat, datePulang, pengajuanhotel);

        return "redirect:/pengajuan";
    }
//    @RequestMapping(value = "/savepengajuan", method = RequestMethod.POST)
//    public String savepengajuan(
//            @RequestParam("pengajuanId") Integer pengajuan_id,
//            @RequestParam("karyawan_id") Integer karyawan_id,
//            @RequestParam("tujuandinas") Integer tujuandinas_id,
//            @RequestParam("jeniskendaraan") Integer jeniskendaraan_id,
//            @RequestParam("pengajuankotaasal") String pengajuankotaasal,
//            @RequestParam("pengajuankotatujuan") String pengajuankotatujuan,
//            @RequestParam("pengajuanwaktuberangkat") String pengajuanwaktuberangkat,
//            @RequestParam("pengajuanwaktupulang") String pengajuanwaktupulang,
//            @RequestParam("pengajuantanggalberangkat") String pengajuantanggalberangkat,
//            @RequestParam("pengajuantanggalpulang") String pengajuantanggalpulang,
//            @RequestParam("pengajuanhotel") String pengajuanhotel,
//            @RequestParam("pengajuanKomentar") String pengajuanKomentar ) throws ParseException {
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggalpengajuan = formatter.parse(pengajuantanggalberangkat);
//        Date tanggalPulang = formatter.parse(pengajuantanggalpulang);
//
//        Date dateBerangkat = new java.sql.Date(tanggalpengajuan.getTime());
//        Date datePulang = new java.sql.Date(tanggalPulang.getTime());
//
//        pengajuanInterface.savePengajuan(pengajuan_id, karyawan_id, tujuandinas_id,
//                jeniskendaraan_id, pengajuankotaasal, pengajuankotatujuan, pengajuanwaktuberangkat,
//                pengajuanwaktupulang, dateBerangkat, datePulang, pengajuanhotel, pengajuanKomentar);
//
//        return "redirect:/pengajuan";
//    }
    
    
    
    @RequestMapping(value = "/saveeditpengajuan", method = RequestMethod.POST)
    public String saveeditpengajuan(Pengajuan pengajuan){
        
        pengajuanInterface.saveeditPengajuan(pengajuan);

        return "redirect:/pengajuan";
    }
    
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
//    public String updatepengajuan(@RequestBody Pengajuan pengajuan, @PathVariable String id){
//
//        
//        pengajuanInterface.updatePengajuan(pengajuan);
//        return "redirect:/persetujuan";
//    }

    @RequestMapping(value = "/editpengajuan/{id}")
    public String editpengajuan(@PathVariable(name = "id") int pengajuan_id, Model model) {
        Pengajuan pengajuan = pengajuanInterface.getPengajuan(pengajuan_id);
        
        Integer ini = pengajuanInterface.getPengajuan(pengajuan_id).getPengajuanId();
        System.out.println(ini);
        
        Integer kendaraanid = kendaraanInterface.listpengajuan(ini).getKendaraanId();
        model.addAttribute("kendaraan_id", kendaraanid);
        
        System.out.println(kendaraanid);
        
        Integer tujuandinasid = tujuandinasInterface.listpengajuan(ini).getTujuandinasId();
        model.addAttribute("tujuandinas_id", tujuandinasid);
        System.out.println(tujuandinasid);
        

        model.addAttribute("listkendaraan", kendaraanInterface.findAllkendaraan());

        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());

        model.addAttribute("listapproval", approvalInterface.findAllapproval());

        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nama = auth.getName();

        Integer hal = karyawanImplement.findId(nama).getKaryawanId();

        model.addAttribute("idkaryawan", nama);
        model.addAttribute("karyawan_id", hal);
        
        List<String> listWaktuBerangkat = Arrays.asList("00.00 - 06.00", "06.00 - 12.00", "12.00 - 18.00", "18.00 - 00.00");
        model.addAttribute("listWaktuBerangkat", listWaktuBerangkat);
        
        String tanggalberangkat1 = pengajuanInterface.getPengajuan(pengajuan_id).getPengajuanWaktuBerangkat();
        model.addAttribute("tanggalberankat", tanggalberangkat1);
        
        String tanggalpulang1 = pengajuanInterface.getPengajuan(pengajuan_id).getPengajuanWaktuPulang();
        model.addAttribute("tanggalpulang", tanggalpulang1);
        
        model.addAttribute("pengajuan", pengajuan);
        return "pengajuanedit";
    }
    
    
    

//    @RequestMapping(value = "/editpengajuan/{id}")
//    public ModelAndView editpengajuan(@PathVariable(name = "id") int pengajuan_id, Model model)
//            throws ParseException {
//        
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String nama = auth.getName();
//
//        Integer hal = karyawanImplement.findId(nama).getKaryawanId();
//
//        model.addAttribute("idkaryawan", nama);
//        model.addAttribute("karyawan_id", hal);
//        
////        Pengajuan pengajuan = new Pengajuan();
//        model.addAttribute("listkendaraan", kendaraanInterface.findAllkendaraan());
//
//        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());
//
//        model.addAttribute("listapproval", approvalInterface.findAllapproval());
////
////        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
//
//
//
////        model.addAttribute("pengajuan", pengajuan);
//        List<String> listWaktuBerangkat = Arrays.asList("00.00 - 06.00", "06.00 - 12.00", "12.00 - 18.00", "18.00 - 00.00");
//        model.addAttribute("listWaktuBerangkat", listWaktuBerangkat);
//
//        ModelAndView edit = new ModelAndView("pengajuanedit");
//        Pengajuan pengajuan = pengajuanInterface.getPengajuan(pengajuan_id);
//        edit.addObject("pengajuan", pengajuan);
//
//        return edit;
//    }
    @RequestMapping(value = "/deletepengajuan/{id}", method = RequestMethod.GET)
    public String deletepengajuan(@PathVariable(name = "id") int pengajuan_id) {
        pengajuanInterface.deletePengajuan(pengajuan_id);
        return "redirect:/pengajuan";
    }
    
    @RequestMapping(value = "/cancelpengajuan/{id}", method = RequestMethod.GET)
    public String cancelpengajuan(@PathVariable (value = "id") int pengajuan_id,
            @RequestParam (value = "approval") int approval_id,
            Model model){

//        model.addAttribute(status, model)
        System.out.println("approval" +approval_id);
        pengajuanInterface.updatePengajuan(pengajuan_id, approval_id);
//        pengajuanInterface.savePengajuan(pengajuan);
//        System.out.println(pengajuan);
        return "redirect:/pengajuan";
    }
    
    
    
    

    
}
