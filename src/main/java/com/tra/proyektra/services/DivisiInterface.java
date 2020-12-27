/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Divisi;
import java.util.Optional;

/**
 *
 * @author asus
 */
public interface DivisiInterface {
    Iterable<Divisi> findAlldivisi();
    
//    void addDivisi (Divisi divisi);
    
    Optional<Divisi> findAll(Integer divisi_id);
    
    public Divisi getDivisi(Integer divisi_id);
    
    void savedivisi (Divisi divisi);
        
    void deletedivisi (Integer divisi_id);
    
    public Divisi caridivisi(Integer divisi_id);
    
}
