/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import com.tra.proyektra.repository.RepoPerjalanan;
import java.sql.Time;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class PerjalananImplement implements PerjalananInterface{

    @Autowired
    RepoPerjalanan repoPerjalanan;
    
    @Override
    public Iterable<Perjalanan> findAllperjalanan() {
        return repoPerjalanan.findAll();
    }

    @Override
    public Perjalanan getPerjalanan(Integer perjalanan_id) {
        return repoPerjalanan.findById(perjalanan_id).get();
    }

    
//    @Override
//    public void savePengajuan (Integer karyawan_id, Integer tujuandinas_id, Integer jeniskendaraan_id, String pengajuankotaasal,
//    String pengajuankotatujuan, String pengajuanwaktuberangkat, String pengajuanwaktupulang,
//    Date pengajuantanggalberangkat, Date pengajuantanggalpulang, String pengajuanhotel) {
//        
//        Pengajuan pengajuan = new Pengajuan(pengajuankotaasal, pengajuankotatujuan, pengajuanwaktuberangkat, 
//                pengajuanwaktupulang, pengajuantanggalberangkat, pengajuantanggalpulang, pengajuanhotel,
//                "0", new Karyawan(karyawan_id), new Kendaraan(jeniskendaraan_id), new Tujuandinas(tujuandinas_id), new Approval(3) );
//        repoPengajuan.save(pengajuan);
//    }
//    
//    
//    public Perjalanan(Pengajuan pengajuanId, String karyawan, String tujuandinas, String kendaraan, String kotaasal, String kotatujuan, Date waktuberangkat, Date waktupulang, Date tanggalberangkat, Date tanggalpulang, String hotel, Integer totaldiem) {
//        this.pengajuanId = pengajuanId;
//        this.perjalananKaryawan = karyawan;
//        this.perjalananTujuanDinas = tujuandinas;
//        this.perjalananKendaraan = kendaraan;
//        this.perjalananKotaAsal = kotaasal;
//        this.perjalananKotaTujuan = kotatujuan;
//        this.perjalananWaktuBerangkat = waktuberangkat;
//        this.perjalananWaktuPulang = waktupulang;
//        this.perjalananTanggalBerangkat = tanggalberangkat;
//        this.perjalananTanggalPulang = tanggalpulang;
//        this.perjalananHotel = hotel;
//        this.perjalananTotalDiem = totaldiem;
//    }
    
    
    @Override
    public void savePerjalanan(Integer pengajuan_id, String karyawan, String tujuandinas, 
            String kendaraan, String kotaasal, String kotatujuan, Date waktuberangkat, 
            Date waktupulang, Date tanggalberangkat, Date tanggalpulang, String hotel, 
            Integer totaldiem) {
        
        Perjalanan perjalanan = new Perjalanan(new Pengajuan(pengajuan_id), karyawan, tujuandinas, 
                kendaraan, kotaasal, kotatujuan, waktuberangkat, waktupulang, tanggalberangkat, 
                tanggalpulang, hotel, totaldiem);
        
        repoPerjalanan.save(perjalanan);
    }
    
//    @Override
//    public void savePerjalanan(Perjalanan perjalanan) {
//        repoPerjalanan.save(perjalanan);
//    }

    @Override
    public void deletePerjalanan(Integer perjalanan_id) {
        repoPerjalanan.deleteById(perjalanan_id);
    }

//    @Override
//    public Perjalanan caripengajuan(Integer pengajuanid) {
//        return repoPerjalanan.caripengajuan(pengajuanid);
//    }

    @Override
    public void savepengajuan(Perjalanan perjalanan) {
        repoPerjalanan.save(perjalanan);
    }



}
