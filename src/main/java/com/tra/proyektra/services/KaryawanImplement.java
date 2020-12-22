/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Karyawan;
import com.tra.proyektra.repository.RepoKaryawan;
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
    
}
