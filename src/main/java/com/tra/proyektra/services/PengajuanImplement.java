/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.config.PengajuanList;
import com.tra.proyektra.entities.Approval;
import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.entities.Kendaraan;
import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import com.tra.proyektra.entities.Tujuandinas;
import com.tra.proyektra.repository.RepoPengajuan;
import com.tra.proyektra.repository.RepoPerjalanan;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class PengajuanImplement implements PengajuanInterface {

    @Autowired
    private RepoPengajuan repoPengajuan;
    
//    @Autowired
//    private RepoPerjalanan repoPerjalanan;

//    @Autowired
//    EntityManager entityManager;

    @Override
    public Iterable<Pengajuan> findAllpengajuan() {
        return repoPengajuan.findAllpengajuan();
    }

    @Override
    public Pengajuan getPengajuan(Integer pengajuan_id) {
        return repoPengajuan.findById(pengajuan_id).get();
    }

//    String pengajuanKotaAsal, String pengajuanKotaTujuan, 
//            String pengajuanWaktuBerangkat, String pengajuanWaktuPulang, 
//                    Date pengajuanTanggalBerangkat, Date pengajuanTanggalPulang, 
//                            String pengajuanHotel, String deleted, Approval approvalId, 
//                                    Karyawan karyawanId, Kendaraan kendaraanId, Tujuandinas tujuandinasId

    
    @Override
    public void savePengajuan (Integer pengajuan_id, Integer karyawan_id, Integer tujuandinas_id, Integer jeniskendaraan_id, 
            String pengajuankotaasal, String pengajuankotatujuan, String pengajuanwaktuberangkat, 
            String pengajuanwaktupulang, Date pengajuantanggalberangkat, Date pengajuantanggalpulang, 
            String pengajuanhotel) {
        
        Pengajuan pengajuan = new Pengajuan(pengajuankotaasal, pengajuankotatujuan, pengajuanwaktuberangkat, 
                pengajuanwaktupulang, pengajuantanggalberangkat, pengajuantanggalpulang, pengajuanhotel,
                "0", pengajuan_id, new Karyawan(karyawan_id), new Kendaraan(jeniskendaraan_id), new Tujuandinas(tujuandinas_id), new Approval(3));
        repoPengajuan.save(pengajuan);
    }

    @Override
    public void deletePengajuan(Integer pengajuan_id) {
        repoPengajuan.deleteById(pengajuan_id);
    }

//    @Override
//    public void updatePengajuan(Pengajuan pengajuan) {
//        repoPengajuan.save(pengajuan);
//    }
    
//    @Override
//    public Kendaraan getKendaraan(Integer kendaraan_id) {
//        return repoKendaraan.findById(kendaraan_id).get();
//    }
    @Override
    public void updatePengajuan(Integer pengajuan_id, Integer approval_id) {
//        Perjalanan perjalanan = new Perjalanan();
        Pengajuan p = repoPengajuan.findById(pengajuan_id).get();
        p.setApprovalId(new Approval(approval_id));
        
        repoPengajuan.save(p);
    }
//    @Override
//    public void updatePengajuan(Integer pengajuan_id, Integer approval_id) {
////        Perjalanan perjalanan = new Perjalanan();
//        Pengajuan z = repoPengajuan.findById(pengajuan_id).get();
//        Pengajuan p = repoPengajuan.findById(pengajuan_id).get();
//        p.setApprovalId(new Approval(approval_id));
//        z.getPengajuanId();
//        z.getKaryawanId().getKaryawanNama();
//        z.getKendaraanId().getKendaraanNama();
//        z.getTujuandinasId().getTujuandinasNama();
//        z.getPengajuanKotaAsal();
//        z.getPengajuanKotaTujuan();
//        z.getPengajuanTanggalBerangkat();
//        z.getPengajuanTanggalPulang();
//        z.getPengajuanWaktuBerangkat();
//        z.getPengajuanWaktuPulang();
//        System.out.println("ini " +z);
//        repoPerjalanan.save(z);
//        repoPengajuan.save(p);
//
//    }

//    @Override
//    public Pengajuan findPengajuan(String username) {
//        return repoPengajuan.findPengajuan(username);
//    }
//    @OverrideS
//    public Pengajuan findPengajuan(Pengajuan p) {
//        return repoPengajuan.findPengajuan(karyawan_id);
//    }
    @Override
    public Iterable<Pengajuan> findPengajuan(String nama) {
        System.out.println("service" + nama);
        return repoPengajuan.findPengajuan(nama);
    }

    @Override
    public Iterable<Pengajuan> allapproval() {
        System.out.println("Service");
        return repoPengajuan.allapproval();
    }

//    public Iterable<Pengajuan> findAllFilter(boolean isDeleted) {
//        Session session = entityManager.unwrap(Session.class);
//        org.hibernate.Filter filter = session.enableFilter("deletedUserFilter");
//        filter.setParameter("isDeleted", isDeleted);
//        Iterable<Pengajuan> pengajuan = repoPengajuan.findAll();
//        session.disableFilter("deletedUserFilter");
//        return pengajuan;
//    }
//    @Override
//    public Iterable<Pengajuan> lihat(String lihat) {
//        return repoPengajuan.allapproval(lihat);
//    }
//
//    @Override
//    public void softDelete(Integer id) {
//        repoPengajuan.deleteById(id);
//    }
//    @Override
//    public Pengajuan loadUserByUsername(String username) {
//        return repoPengajuan.findUserByUsername(username);
//    }
//    
//    @Override
//    public Pengajuan findId(String idlog) {
//        System.out.println("id" +idlog);
//        return repoPengajuan.findId(idlog);
//S    }
//    @Override
//    public Iterable<Pengajuan> allsoftdelete(String nama, String delete) {
//        System.out.println("delete" + delete);
//        return repoPengajuan.allsoftdelete(nama, delete);
//    }

    @Override
    public void saveeditPengajuan(Pengajuan pengajuan) {
        repoPengajuan.save(pengajuan);
    }

    @Override
    public Iterable<Pengajuan> simpanperjalanan(Integer perjalanan) {
        return repoPengajuan.simpanperjalanan(perjalanan);
    }

    @Override
    public Pengajuan caripengajuan(Integer pengajuanid) {
        return  repoPengajuan.caripengajuan(pengajuanid);
    }

    @Override
    public Optional<Pengajuan> komentar(Integer pengajuan_id) {
        return repoPengajuan.findById(pengajuan_id);
    }

//    @Override
//    public void simpanpengajuan(Pengajuan pengajuan) {
//        repoPengajuan.save(pengajuan);
//    }

//    @Override
//    public void simpanpengajuan(Pengajuan pengajuan, Date tanggalberangkat, Date tanggalpulang) {
//        Pengajuan pengajuan = new Pengajuan(tanggalberangkat, tanggalpulang);
//        
//        repoPengajuan.save(pengajuan);
//    }

    @Override
    public Pengajuan pilih(Integer pengajuanid) {
        return repoPengajuan.pilih(pengajuanid);
    }

    @Override
    public long hitung() {
        return repoPengajuan.hitung();
    }

    @Override
    public long diterima() {
        return repoPengajuan.diterima();
    }

    @Override
    public long ditolak() {
        return repoPengajuan.ditolak();
    }

    @Override
    public long menunggu() {
        return repoPengajuan.menunggu();
    }

    @Override
    public List<Pengajuan> Allpengajuan() {
        return (List<Pengajuan>) repoPengajuan.findAll();
    }

    @Override
    public long pengajuanuser(String usernama) {
        return repoPengajuan.pengajuanuser(usernama);
    }

    @Override
    public List<Object[]> totalpengajuan() {
        return repoPengajuan.totalpengajuan();
    }
//    @Override
//    public List<PengajuanList> totalpengajuan() {
//        return repoPengajuan.totalpengajuan();
//    }

    @Override
    public List<Object[]> totalpengajuanuser(String nama) {
        return repoPengajuan.totalpengajuanuser(nama);
    }



    


}
