/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import com.lowagie.text.DocumentException;
import com.tra.proyektra.entities.Perjalanan;
import com.tra.proyektra.report.PerjalananPdfExporter;
import com.tra.proyektra.services.EmailService;
import com.tra.proyektra.services.KaryawanInterface;
import com.tra.proyektra.services.KendaraanInterface;
import com.tra.proyektra.services.PengajuanInterface;
import com.tra.proyektra.services.PerjalananImplement;
import com.tra.proyektra.services.PerjalananInterface;
import com.tra.proyektra.services.ReportService;
import com.tra.proyektra.services.TujuandinasInterface;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
public class PerjalananController {

    @Autowired
    PerjalananInterface perjalananInterface;

    @Autowired
    PengajuanInterface pengajuanInterface;

    @Autowired
    PerjalananImplement perjalananImplement;

    @Autowired
    KaryawanInterface karyawanInterface;

    @Autowired
    TujuandinasInterface tujuandinasInterface;

    @Autowired
    KendaraanInterface kendaraanInterface;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    ReportService reportService;
    

    @RequestMapping(value = "/perjalanan")
    public String allperjalanan(Model model) {

        model.addAttribute("listperjalanan", perjalananInterface.findAllperjalanan());
        return "/perjalanan";
    }

    @RequestMapping(value = "/listpengajuan")
    public String listpengajuan(Model model) {
//        String status = "accept";
        model.addAttribute("listpengajuan", pengajuanInterface.allapproval());
//        System.out.println(status);
//        model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
        return "/listpengajuan";
    }

    @RequestMapping(value = "/tambahperjalanan/{id}")
    public String tambahperjalanan(@PathVariable(name = "id") int pengajuan, Model model) {

        Perjalanan perjalanan = new Perjalanan();
        model.addAttribute("perjalanan", perjalanan);
        

        Integer cariperjalanan = pengajuanInterface.pilih(pengajuan).getPengajuanId();

//        Integer caripengajuan = pengajuanInterface.pilih(pengajuan).getPengajuanId();
//
//        System.out.println(caripengajuan);
        String carinama = karyawanInterface.carinama(cariperjalanan).getKaryawanNama();
        String caritujuan = tujuandinasInterface.caritujuan(cariperjalanan).getTujuandinasNama();
        String carikendaraan = kendaraanInterface.carikendaraan(cariperjalanan).getKendaraanNama();

        String kotaasal1 = pengajuanInterface.pilih(pengajuan).getPengajuanKotaAsal();
        String kotatujuan1 = pengajuanInterface.pilih(pengajuan).getPengajuanKotaTujuan();
        String waktuberangkat1 = pengajuanInterface.pilih(pengajuan).getPengajuanWaktuBerangkat();
        String waktupulang1 = pengajuanInterface.pilih(pengajuan).getPengajuanWaktuPulang();
        Date tanggalberangkat1 = pengajuanInterface.pilih(pengajuan).getPengajuanTanggalBerangkat();
        Date tanggalpulang1 = pengajuanInterface.pilih(pengajuan).getPengajuanTanggalPulang();
        String hotel1 = pengajuanInterface.pilih(pengajuan).getPengajuanHotel();

        model.addAttribute("pengajuanid", cariperjalanan);
        model.addAttribute("namakaryawan", carinama);
        model.addAttribute("namatujuan", caritujuan);
        model.addAttribute("namakendaraan", carikendaraan);
        model.addAttribute("kotaasal", kotaasal1);
        model.addAttribute("kotatujuan", kotatujuan1);
        model.addAttribute("waktuberangkat", waktuberangkat1);
        model.addAttribute("waktupulang", waktupulang1);
        model.addAttribute("tanggalberangkat", tanggalberangkat1);
        model.addAttribute("tanggalpulang", tanggalpulang1);
        model.addAttribute("hotel", hotel1);
        

//        Iterable<Pengajuan> baik = pengajuanInterface.simpanperjalanan(perjalanan);
//        model.addAttribute("perjalanan", baik);
//        System.out.println(status);
//        model.addAttribute("listpengajuan", pengajuanInterface.findAllpengajuan());
        return "/perjalananadd";
    }

    @RequestMapping(value = "/addperjalanan")
    public String addperjalanan(Model model) {
        Perjalanan perjalanan = new Perjalanan();

        model.addAttribute("perjalanan", perjalanan);
        return "/perjalanantambah";
    }

//    @RequestMapping(value = "/editpengajuan/{id}")
//    public ModelAndView editpengajuan(@PathVariable(name = "id")int pengajuan_id, Model model) {
//        
////        Pengajuan pengajuan = new Pengajuan();
//        
//        model.addAttribute("listkendaraan", kendaraanInterface.findAllkendaraan());
//        
//        model.addAttribute("listtujuandinas", tujuandinasInterface.findAllTujuandinas());
//        
//        model.addAttribute("listapproval", approvalInterface.findAllapproval());
//        
//        model.addAttribute("listkaryawan", karyawanInterface.findAllKaryawan());
//        
////        model.addAttribute("pengajuan", pengajuan);
//
//        List<String> listWaktuBerangkat = Arrays.asList("00.00 - 06.00", "06.00 - 12.00", "12.00 - 18.00", "18.00 - 00.00");
//        model.addAttribute("listWaktuBerangkat", listWaktuBerangkat);
//        
//        ModelAndView edit = new ModelAndView("pengajuanedit");
//        Pengajuan pengajuan = pengajuanInterface.getPengajuan(pengajuan_id);
//        edit.addObject("pengajuan", pengajuan);
//        
//        return edit;
//    }
//    @RequestMapping(value = "/tambahperjalanan/{id}")
//    public ModelAndView tambahperjalanan(@PathVariable(name = "id")int pengajuan_id) {
//        
//        ModelAndView edit = new ModelAndView("perjalananadd");
////        Perjalanan perjalanan = perjalananInterface.getPerjalanan(pengajuan_id);
////        edit.addObject("perjalanan", perjalanan);
//        
//        Pengajuan pengajuan = pengajuanInterface.getPengajuan(pengajuan_id);
//        edit.addObject("perjalanan", pengajuan);
//        
//        return edit;
//    }
    @RequestMapping(value = "/editperjalanan")
    public ModelAndView editperjalanan(@PathVariable(name = "id") int perjalanan_id) {

        ModelAndView edit = new ModelAndView("perjalananedit");
        Perjalanan perjalanan = perjalananInterface.getPerjalanan(perjalanan_id);
        edit.addObject("perjalanan", perjalanan);

        return edit;
    }

//    @RequestMapping(value = "/savepengajuan", method = RequestMethod.POST)
//    public String savepengajuan(
//            @RequestParam("karyawan_id") Integer karyawan_id,
//            @RequestParam("tujuandinas") Integer tujuandinas_id,
//            @RequestParam("jeniskendaraan") Integer jeniskendaraan_id,
//            @RequestParam("pengajuankotaasal") String pengajuankotaasal,
//            @RequestParam("pengajuankotatujuan") String pengajuankotatujuan,
//            @RequestParam("pengajuanwaktuberangkat") String pengajuanwaktuberangkat,
//            @RequestParam("pengajuanwaktupulang") String pengajuanwaktupulang,
//            @RequestParam("pengajuantanggalberangkat") String pengajuantanggalberangkat,
//            @RequestParam("pengajuantanggalpulang") String pengajuantanggalpulang,
//            @RequestParam("pengajuanhotel") String pengajuanhotel) throws ParseException {
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggalpengajuan = formatter.parse(pengajuantanggalberangkat);
//        Date tanggalPulang = formatter.parse(pengajuantanggalpulang);
//
//        Date dateBerangkat = new java.sql.Date(tanggalpengajuan.getTime());
//        Date datePulang = new java.sql.Date(tanggalPulang.getTime());
//
//        pengajuanInterface.savePengajuan(karyawan_id, tujuandinas_id,
//                jeniskendaraan_id, pengajuankotaasal, pengajuankotatujuan, pengajuanwaktuberangkat,
//                pengajuanwaktupulang, dateBerangkat, datePulang, pengajuanhotel);
//
//        return "redirect:/pengajuan";
//    }
    @RequestMapping(value = "/saveperjalanan", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveperjalanan(
            @RequestParam("perjalananpengajuan") Integer pengajuan_id,
            @RequestParam("perjalanankaryawan") String karyawan,
            @RequestParam("perjalanantujuandinas") String tujuandinas,
            @RequestParam("perjalanankendaraan") String kendaraan,
            @RequestParam("perjalanankotaasal") String kotaasal,
            @RequestParam("perjalanankotatujuan") String kotatujuan,
            @RequestParam("perjalananwaktuberangkat") String waktuberangkat,
            @RequestParam("perjalananwaktupulang") String waktupulang,
            @RequestParam("perjalanantanggalberangkat") String tanggalberangkat,
            @RequestParam("perjalanantanggalpulang") String tanggalpulang,
            @RequestParam("perjalananhotel") String hotel,
            @RequestParam("perjalanantotaldiem") Integer totaldiem
    ) throws ParseException {
        
        pengajuanInterface.deletePengajuan(pengajuan_id);
        
        //parse String to Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalpengajuan = formatter.parse(tanggalberangkat);
        Date tanggalPulang = formatter.parse(tanggalpulang);

        Date dateBerangkat = new java.sql.Date(tanggalpengajuan.getTime());
        Date datePulang = new java.sql.Date(tanggalPulang.getTime());

        //parse string to time
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date waktupengajuan = format.parse(waktuberangkat);
        Date waktukepulangan = format.parse(waktupulang);

        Date timeBerangkat = new java.sql.Date(waktupengajuan.getTime());
        Date timePulang = new java.sql.Date(waktukepulangan.getTime());

        LocalDate d1 = LocalDate.parse(tanggalberangkat, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(tanggalpulang, DateTimeFormatter.ISO_LOCAL_DATE);
//        LocalDate d1 = LocalDate.parse(tanggalberangkat, DateTimeFormatter.ISO_LOCAL_DATE);
//        LocalDate d2 = LocalDate.parse(tanggalpulang, DateTimeFormatter.ISO_LOCAL_DATE);
//        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
//        long diffDays = diff.toDays();
//        Date diff = new Date(waktukepulangan.getTime() - waktukepulangan.getTime());
//        Period diff = Period.between(LocalDate.MIN, LocalDate.MAX);
//        Duration diff = Duration.between(timeBerangkat, timePulang);
        Integer diem = tujuandinasInterface.caridiem(tujuandinas).getTujuandinasDiem();
        long selisih1 = ChronoUnit.DAYS.between(d1, d2);
        int selisih = (int)selisih1;
        
        System.out.println("selisih = " + selisih);
        System.out.println("tujuan dinas = " + tujuandinas);
        totaldiem = selisih * diem;
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
//        Time waktupengajuan = (Time) formatter.parse(waktuberangkat);
//        Time waktupengajuan = formatter.parse(waktuberangkat);
//        
//        Time timeberangkat = new java.sql.Time.valueOf(waktupengajuan);
//        Time timepulang = new java.sql.Time.valueOf(waktupulang);
//        perjalananImplement.savePerjalanan(pengajuan_id, karyawan, tujuandinas, kendaraan, kotaasal, kotatujuan, dateBerangkat, datePulang, timeBerangkat, tanggalPulang, hotel, totaldiem);
        perjalananImplement.savePerjalanan(pengajuan_id, karyawan, tujuandinas,
                kendaraan, kotaasal, kotatujuan, timeBerangkat, timePulang,
                dateBerangkat, datePulang, hotel, totaldiem);

        return "redirect:/perjalanan";
    }

//    @RequestMapping(value = "/saveperjalanan/{id}", method = RequestMethod.POST, params = "action/delete")
//    public String softdeletepengajuan(@PathVariable(name = "id") int pengajuan_id) {
//        pengajuanInterface.deletePengajuan(pengajuan_id);
//        
//        return "redirect:/perjalanan";
//    }
//    @RequestMapping(value = "/deletepengajuan/{id}", method = RequestMethod.POST)
//    public void softdeletepengajuan(@PathVariable(name = "id") int pengajuan_id) {
//        pengajuanInterface.deletePengajuan(pengajuan_id);
//    }
    
    
//    @RequestMapping(value = "/deletepengajuan/{id}", method = RequestMethod.GET)
//    public String deletepengajuan(@PathVariable(name = "id") int pengajuan_id) {
//        pengajuanInterface.deletePengajuan(pengajuan_id);
//        return "redirect:/pengajuan";
//    }

    @RequestMapping(value = "/template/{id}")
    public String email(@PathVariable(name = "id") int email, Model model) throws Exception {

        Integer perjalanan = perjalananInterface.getPerjalanan(email).getPerjalananId();

        String name = perjalananInterface.getPerjalanan(email).getPerjalananKaryawan();
        String tujuandinas = perjalananInterface.getPerjalanan(email).getPerjalananTujuanDinas();
        String kendaraan = perjalananInterface.getPerjalanan(email).getPerjalananKendaraan();
        String kotaasal = perjalananInterface.getPerjalanan(email).getPerjalananKotaAsal();
        String kotatujuan = perjalananInterface.getPerjalanan(email).getPerjalananKotaTujuan();
        Date waktuberangkat1 = perjalananInterface.getPerjalanan(email).getPerjalananWaktuBerangkat();
        Date waktupulang1 = perjalananInterface.getPerjalanan(email).getPerjalananWaktuPulang();
        Date tanggalberangkat1 = perjalananInterface.getPerjalanan(email).getPerjalananTanggalBerangkat();
        Date tanggalpulang1 = perjalananInterface.getPerjalanan(email).getPerjalananTanggalPulang();
        String hotel = perjalananInterface.getPerjalanan(email).getPerjalananHotel();
        Integer diem = perjalananInterface.getPerjalanan(email).getPerjalananTotalDiem();

        String totaldiem = String.valueOf(diem);
        String waktuberangkat = waktuberangkat1.toString();
        String waktupulang = waktupulang1.toString();
        String tanggalberangkat = tanggalberangkat1.toString();
        String tanggalpulang = tanggalpulang1.toString();

        System.out.println(name);
        System.out.println(perjalanan);

        Integer pengajuan = pengajuanInterface.caripengajuan(perjalanan).getPengajuanId();

        System.out.println(pengajuan);

        String hasilemail = karyawanInterface.cariemail(pengajuan).getKaryawanEmail();

        System.out.println(hasilemail);

        Map<String, Object> tulisan = new HashMap();
        tulisan.put("name", name);
        tulisan.put("tujuandinas", tujuandinas);
        tulisan.put("kendaraan", kendaraan);
        tulisan.put("kotaasal", kotaasal);
        tulisan.put("kotatujuan", kotatujuan);
        tulisan.put("waktuberangkat", waktuberangkat);
        tulisan.put("waktupulang", waktupulang);
        tulisan.put("tanggalberangkat", tanggalberangkat);
        tulisan.put("tanggalpulang", tanggalpulang);
        tulisan.put("hotel", hotel);
        tulisan.put("diem", totaldiem);

        System.out.println("masuk send email");
        String kirimemail = hasilemail;
        String subject = "Keputusan Pengajuan Ijin Dinas";
        String from = "azibrian.id@gmail.com";
//        String name = "azibrian66@gmail.com";

        emailService.notif(kirimemail, subject, from, tulisan);
        return "redirect:/perjalanan";
    }
    
//    @RequestMapping(value = "/report", method = RequestMethod.GET)
//    public String report(Model model, HttpServletResponse httpServletResponse) {
//        List<Perjalanan> perjalanan = perjalananInterface.findAllperjalanan();
//        JRDataSource dataSource=new JRBeanCollectionDataSource(perjalanan);
//        
//        model.addAttribute("dataSource", dataSource);
//        
//        return "pdfreport";
//    }
    
    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public void exportToPdf(HttpServletResponse httpServletResponse) throws DocumentException, IOException{
        httpServletResponse.setContentType("application/pdf");
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report_" + currentDateTime + ".pdf";
        
        httpServletResponse.setHeader(headerKey, headerValue);
        
        List<Perjalanan> listperjalanan = reportService.listAll();
        
        PerjalananPdfExporter exporter = new PerjalananPdfExporter(listperjalanan);
        exporter.export(httpServletResponse);
    }
    

}
