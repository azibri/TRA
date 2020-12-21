/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Kendaraan;
import com.tra.proyektra.repository.RepoKendaraan;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class KendaraanImplement implements KendaraanInterface{

    @Autowired
    private RepoKendaraan repoKendaraan;
    
    @Override
    public Iterable<Kendaraan> findAllkendaraan() {
        return repoKendaraan.findAll();
    }

    @Override
    public Optional<Kendaraan> findKendaraan(Integer kendaraan_id) {
        return repoKendaraan.findById(kendaraan_id);
    }

    @Override
    public void deleteKendaraan(Integer kendaraan_id) {
        repoKendaraan.deleteById(kendaraan_id);
    }

    @Override
    public Kendaraan getKendaraan(Integer kendaraan_id) {
        return repoKendaraan.findById(kendaraan_id).get();
    }

    @Override
    public List<Kendaraan> findAll() {
        return (List<Kendaraan>) repoKendaraan.findAll();
    }

    
    @Override
    public void saveKendaraan(Kendaraan kendaraan) {
        repoKendaraan.save(kendaraan);
    }
    
    @Override
    public void addKendaraan(Kendaraan kendaraan) {
        repoKendaraan.save(kendaraan);
    }
    
    @Override
    public Kendaraan listpengajuan(Integer listid) {
        return repoKendaraan.listpengajuan(listid);
    }

    @Override
    public Kendaraan carikendaraan(Integer kendaraan) {
        return repoKendaraan.carikendaraan(kendaraan);
    }
    

    
}
