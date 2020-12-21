/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Kendaraan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoKendaraan extends CrudRepository<Kendaraan, Integer>{
    @Query(value = "SELECT * FROM pengajuan INNER JOIN kendaraan "
            + "ON pengajuan.kendaraan_id=kendaraan.kendaraan_id "
            + "WHERE pengajuan_id = ?1", nativeQuery = true)
    public Kendaraan listpengajuan(Integer idlist);
    
    @Query(value = "SELECT * FROM kendaraan INNER JOIN pengajuan "
            + "ON kendaraan.kendaraan_id = pengajuan.kendaraan_id "
            + "WHERE pengajuan.pengajuan_id = ?1", nativeQuery = true)
    public Kendaraan carikendaraan(Integer kendaraannama);
}
