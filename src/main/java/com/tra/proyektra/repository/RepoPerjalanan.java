/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Pengajuan;
import com.tra.proyektra.entities.Perjalanan;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoPerjalanan extends CrudRepository<Perjalanan, Integer> {

    @Query(value = "SELECT SUM(perjalanan_tanggal_pulang - perjalanan_tanggal_berangkat)/COUNT(perjalanan_id) "
            + "FROM perjalanan", nativeQuery = true)
    float rerata();

    @Query(value = "SELECT MONTHNAME(perjalanan_tanggal_berangkat) AS Periode, COUNT(perjalanan_id) AS Perjalanan "
            + "FROM perjalanan GROUP BY MONTH(perjalanan_tanggal_berangkat)", nativeQuery = true)
    public List<Object[]> perjalanan();
    
//    @Query(value = "SELECT * FROM perjalanan WHERE perjalanan_id = ?1", nativeQuery = true)
//    public List<Perjalanan> perperjalanan(Integer perjalananid);
    
    

}
