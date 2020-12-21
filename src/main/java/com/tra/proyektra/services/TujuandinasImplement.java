/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Tujuandinas;
import com.tra.proyektra.repository.RepoTujuandinas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class TujuandinasImplement implements TujuandinasInterface{

    @Autowired
    private RepoTujuandinas repoTujuandinas;
    
    @Override
    public Iterable<Tujuandinas> findAllTujuandinas() {
        return repoTujuandinas.findAll();
    }

    @Override
    public Tujuandinas getTujuandinas(Integer tujuandinas_id) {
        return repoTujuandinas.findById(tujuandinas_id).get();
    }

    @Override
    public void deletetujuandinas(Integer tujuandinas_id) {
        repoTujuandinas.deleteById(tujuandinas_id);
    }

    @Override
    public Optional<Tujuandinas> findTugasdinas(Integer tujuandinas_id) {
        return repoTujuandinas.findById(tujuandinas_id);
    }

    @Override
    public void addtujuandinas(Tujuandinas tujuandinas) {
        repoTujuandinas.save(tujuandinas);
    }
    
    
    @Override
    public void savetujuandinas(Tujuandinas tujuandinas) {
        repoTujuandinas.save(tujuandinas);
    }

    @Override
    public List<Tujuandinas> findAll() {
        return (List<Tujuandinas>) repoTujuandinas.findAll();
    }

    @Override
    public Tujuandinas listpengajuan(Integer listid) {
        return repoTujuandinas.listpengajuan(listid);
    }

    @Override
    public Tujuandinas caritujuan(Integer tujuan) {
        return repoTujuandinas.caritujuan(tujuan);
    }

    @Override
    public Tujuandinas caridiem(String diem) {
        return repoTujuandinas.caridiem(diem);
    }
    
}
