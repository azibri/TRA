/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Tujuandinas;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author asus
 */
public interface TujuandinasInterface {
    
    Iterable<Tujuandinas> findAllTujuandinas();
    
    public List<Tujuandinas> findAll();
    
    Optional<Tujuandinas> findTugasdinas(Integer tujuandinas_id);
    
    public Tujuandinas getTujuandinas(Integer tujuandinas_id);
    
    void addtujuandinas (Tujuandinas tujuandinas);
    
    void savetujuandinas (Tujuandinas tujuandinas);
    
    void deletetujuandinas (Integer tujuandinas_id);
    
    public Tujuandinas listpengajuan(Integer listid);
    
    public Tujuandinas caritujuan(Integer tujuan);
    
    public Tujuandinas caridiem(String diem);
    
}
