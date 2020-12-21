/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author asus
 */
public interface PengajuanInterface {
    
    Iterable<Pengajuan> findAllpengajuan();
    
    public Pengajuan getPengajuan(Integer pengajuan_id);

    
    public void savePengajuan (Integer pengajuan_id, Integer karyawan_id, Integer tujuandinas_id, Integer jeniskendaraan_id, 
            String pengajuankotaasal, String pengajuankotatujuan, String pengajuanwaktuberangkat, 
            String pengajuanwaktupulang, Date pengajuantanggalberangkat, Date pengajuantanggalpulang, 
            String pengajuanhotel);
    
    public void saveeditPengajuan (Pengajuan pengajuan);
    
    void deletePengajuan (Integer pengajuan_id);
    
    public void updatePengajuan (Integer pengajuan_id, Integer approval_id);
    
    public Iterable<Pengajuan> findPengajuan(String nama);
    
    public Iterable<Pengajuan> allapproval();
    
    public Iterable<Pengajuan> simpanperjalanan(Integer perjalanan);
    
    public Pengajuan caripengajuan(Integer pengajuanid);
    
    Optional<Pengajuan> findpengajuan(Integer pengajuan_id);
    
    public Pengajuan pilih (Integer pengajuanid);
    
    
    
//    public void simpanpengajuan(Pengajuan pengajuan, Date tanggalberangkat, Date tanggalpulang);
    
    
//    
//    public Iterable<Pengajuan> allsoftdelete(String nama, String delete);
    
//    public Pengajuan findId(String idlog);
    
    
//    public Iterable<Pengajuan> lihat(String lihat);
//
//    public void softDelete(Integer id); 
//    public Pengajuan loadUserByUsername(String username);
        
}
