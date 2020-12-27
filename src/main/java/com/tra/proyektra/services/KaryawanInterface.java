/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.services;

import com.tra.proyektra.entities.Karyawan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author asus
 */
public interface KaryawanInterface {
    Iterable<Karyawan> findAllKaryawan();
    
    public Karyawan getKaryawan(Integer karyawan_id);
    
    public Karyawan findKaryawan(String karyawanNama);
    
    void savekaryawan(Karyawan karyawan);
    
    void deletekaryawan (Integer karyawan_id);
    
    public Karyawan findId(String idlog);
    
    public Karyawan cariemail(Integer email);
    
    public Karyawan carinama(Integer pengajuanid_2);
    
    long karyawan();

//    public void savekaryawan(Karyawan karyawan, Date tanggallahir2);

//    public void savekaryawan(String divisi_id, String namakaryawan, String jeniskelamin, Date tanggallahir2, String email, String alamat, String role);

    public void savekaryawan(Integer karyawan_id, Integer divisi_id, String namakaryawan, String jeniskelamin, Date tanggallahir2, String email, String alamat, String role);
    
    public List<Object[]> jeniskelamin();
    
}
