/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Perjalanan;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author asus
 */
public interface PerjalananInterface {
    Iterable<Perjalanan> findAllperjalanan();
    List<Perjalanan> Allpengajuan();
//    List<Perjalanan> findAllperjalanan();
    
    public Perjalanan getPerjalanan(Integer perjalanan_id);

    
    void savePerjalanan (Integer pengajuan_id, String karyawan, String tujuandinas, 
            String kendaraan, String kotaasal, String kotatujuan, Date waktuberangkat, 
            Date waktupulang, Date tanggalberangkat, Date tanggalpulang, String hotel, Integer totaldiem);
    
//    void savePerjalanan (Perjalanan perjalanan);
    
    void deletePerjalanan (Integer perjalanan_id);
    
    void savepengajuan(Perjalanan perjalanan);
    
    long diproses();
    
    long rerata();
    
//    public Perjalanan caripengajuan(Integer pengajuanid);
    
    
}
