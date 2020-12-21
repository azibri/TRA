/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Kendaraan;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author asus
 */
public interface KendaraanInterface {
    Iterable<Kendaraan> findAllkendaraan();
    
    public Kendaraan getKendaraan(Integer kendaraan_id);
    
    public List<Kendaraan> findAll();
    
    public Optional<Kendaraan> findKendaraan(Integer kendaraan_id);
    
    void addKendaraan(Kendaraan kendaraan);
    
    void saveKendaraan(Kendaraan kendaraan);
    
    void deleteKendaraan (Integer kendaraan_id);
    
    public Kendaraan listpengajuan(Integer listid);
    
    public Kendaraan carikendaraan(Integer kendaraan);
    
}
