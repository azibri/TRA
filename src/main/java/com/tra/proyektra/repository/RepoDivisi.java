/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Divisi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoDivisi extends CrudRepository<Divisi, Integer>{
    @Query(value = "SELECT * FROM divisi INNER JOIN karyawan ON "
            + "divisi.divisi_id=karyawan.divisi_id WHERE karyawan_id = ?1", nativeQuery = true)
    public Divisi caridivisi(Integer divisiid);
}
