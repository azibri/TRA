/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Divisi;
import com.tra.proyektra.repository.RepoDivisi;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class DivisiImplement implements DivisiInterface{

    @Autowired
    private RepoDivisi repoDivisi;
    
    @Override
    public Iterable<Divisi> findAlldivisi() {
        return repoDivisi.findAll();
    }

    @Override
    public Divisi getDivisi(Integer divisi_id) {
        return repoDivisi.findById(divisi_id).get();
    }

    @Override
    public void savedivisi(Divisi divisi) {
        repoDivisi.save(divisi);
    }

    @Override
    public void deletedivisi(Integer divisi_id) {
        repoDivisi.deleteById(divisi_id);
    }

    @Override
    public Optional<Divisi> findAll(Integer divisi_id) {
        return repoDivisi.findById(divisi_id);
    }
    
    @Override
    public Divisi caridivisi(Integer divisi_id) {
        return repoDivisi.caridivisi(divisi_id);
    }
    
}
