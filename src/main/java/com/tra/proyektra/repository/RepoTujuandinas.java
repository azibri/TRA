/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Tujuandinas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author asus
 */
public interface RepoTujuandinas extends CrudRepository<Tujuandinas, Integer> {

    @Query(value = "SELECT * FROM pengajuan INNER JOIN tujuandinas "
            + "ON pengajuan.tujuandinas_id=tujuandinas.tujuandinas_id "
            + "WHERE pengajuan_id =?1", nativeQuery = true)
    public Tujuandinas listpengajuan(Integer idlist);
    
    @Query(value = "SELECT * FROM tujuandinas INNER JOIN pengajuan "
            + "ON tujuandinas.tujuandinas_id = pengajuan.tujuandinas_id "
            + "WHERE pengajuan.pengajuan_id = ?1", nativeQuery = true)
    public Tujuandinas caritujuan(Integer namatujuan);
    
    @Query(value = "SELECT * FROM tujuandinas WHERE tujuandinas_nama = ?1", nativeQuery = true)
    public Tujuandinas caridiem(String diemtujuan);
}
