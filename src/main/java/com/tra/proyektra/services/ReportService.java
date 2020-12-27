/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import com.tra.proyektra.repository.RepoPengajuan;
import com.tra.proyektra.repository.RepoPerjalanan;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author asus
 */
@Service
@Transactional
public class ReportService {
    
    @Autowired
    private RepoPerjalanan repoPerjalanan;
    
    public List<Perjalanan> listAll() {
        return (List<Perjalanan>) repoPerjalanan.findAll();
    }
    
//    public List<Perjalanan> perperjalanan(Integer perjalanan_id) {
//        return repoPerjalanan.perperjalanan(perjalanan_id);
//    }
    
//    @Autowired
//    private PengajuanInterface pengajuanInterface;
//    
//   
//    
//    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
//        String path="";
//        List<Pengajuan> pengajuan = (List<Pengajuan>) pengajuanInterface.findAllpengajuan();
//        
//        //load file and compile it
//        File file = ResourceUtils.getFile(resourceLocation: "classpath:reportpertrip.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pengajuan);
//        Map<String, Object> parameters = new HashMap();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//        
//        if (reportFormat.equalsIgnoreCase(anotherString:"html")) {
//            JasperPrint.exportReportToHtmlFile(jasperPrint, destFileName: path + "\\reportpertrip.html");
//        }
//        if (reportFormat.equalsIgnoreCase(anotherString:"pdf")) {
//            JasperPrint.exportReportToPdfFile(jasperPrint, destFileName: path + "\\reportpertrip.pdf");
//        }
//        
//        return "report generate in path: " + path;
//    }
    
}
