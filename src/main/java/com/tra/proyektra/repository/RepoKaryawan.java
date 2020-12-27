/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

import com.tra.proyektra.entities.Karyawan;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
@Repository
public interface RepoKaryawan extends CrudRepository<Karyawan, Integer> {
//    @Query(value = "Select * from Karyawan where karyawanNama = ?1", nativeQuery = true)

    @Query(value = "select * from karyawan where karyawan_nama = ?1", nativeQuery = true)
    public Karyawan findKaryawan(String KaryawanNama);

    @Query(value = "SELECT * FROM karyawan\n"
            + "WHERE karyawan_nama = ?1", nativeQuery = true)
    public Karyawan findKaryawanByKaryawannama(String id);

    @Query(value = "SELECT * FROM karyawan \n"
            + "INNER JOIN pengajuan ON karyawan.karyawan_id = pengajuan.karyawan_id\n"
            + "WHERE pengajuan.pengajuan_id = ?1", nativeQuery = true)
    public Karyawan cariemail(Integer mail);
    
    @Query(value = "SELECT * FROM karyawan INNER JOIN pengajuan "
            + "ON karyawan.karyawan_id = pengajuan.karyawan_id "
            + "WHERE pengajuan.pengajuan_id = ?1", nativeQuery = true)
    public Karyawan carinama(Integer pengajuanid2);
    
    @Query(value = "SELECT karyawan_jenis_kelamin AS JENIS_KELAMIN, COUNT(karyawan_jenis_kelamin) "
            + "AS JUMLAH FROM karyawan GROUP BY karyawan_jenis_kelamin", nativeQuery = true)
    public List<Object[]> jeniskelamin();
    
    
    
//    @Query(value = "SELECT COUNT(karyawan_id) FROM karyawan", nativeQuery = true)
//    long karyawan();
    
    

//    Optional<Karyawan> findByKaryawan(String KaryawanNama);
}
