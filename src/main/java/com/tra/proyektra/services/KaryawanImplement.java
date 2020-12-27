/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Divisi;
import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.repository.RepoKaryawan;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class KaryawanImplement implements KaryawanInterface {

    @Autowired
    private RepoKaryawan repoKaryawan;
    
    
    @Override
    public Iterable<Karyawan> findAllKaryawan() {
        return repoKaryawan.findAll();
    }

    @Override
    public Karyawan getKaryawan(Integer karyawan_id) {
        return repoKaryawan.findById(karyawan_id).get();
    }

    @Override
    public void savekaryawan(Karyawan karyawan) {
        repoKaryawan.save(karyawan);
    }

    @Override
    public void deletekaryawan(Integer karyawan_id) {
        repoKaryawan.deleteById(karyawan_id);
    }

    @Override
    public Karyawan findKaryawan(String username) {
        return repoKaryawan.findKaryawan(username);
    }
    
    public Iterable<Karyawan> findByKaryawan() {
        return repoKaryawan.findAll();
    }

    @Override
    public Karyawan findId(String idlog) {
        return repoKaryawan.findKaryawanByKaryawannama(idlog);
    }
    
    @Override
    public Karyawan cariemail(Integer email) {
        return repoKaryawan.cariemail(email);
    }

    @Override
    public Karyawan carinama(Integer pengajuanid_2) {
        return repoKaryawan.carinama(pengajuanid_2);
    }

    @Override
    public long karyawan() {
        return repoKaryawan.count();
    }

//    @Override
//    public void savekaryawan(Karyawan karyawan, Date tanggallahir2) {
//        repoKaryawan.save(karyawan, tanggallahir2);
//    }

//    @Override
//    public void savekaryawan(String divisi_id, String namakaryawan, String jeniskelamin, Date tanggallahir2, String email, String alamat, String role) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void savekaryawan(Integer karyawan_id, Integer divisi_id, String namakaryawan, String jeniskelamin, Date tanggallahir2, String email, String alamat, String role) {

        Karyawan karyawan = new Karyawan(karyawan_id, new Divisi(divisi_id), namakaryawan, jeniskelamin, 
                tanggallahir2, email, alamat, role);
        repoKaryawan.save(karyawan);
    }

    @Override
    public List<Object[]> jeniskelamin() {
        return repoKaryawan.jeniskelamin();
    }

    
    
}
