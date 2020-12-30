/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.repository;

//import com.tra.proyektra.config.PengajuanList;
import com.tra.proyektra.entities.Pengajuan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author asus
 */
public interface RepoPengajuan extends CrudRepository<Pengajuan, Integer> {

    @Query(value = "SELECT * FROM pengajuan\n"
            + "INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id\n"
            + "WHERE karyawan.karyawan_nama = ?1", nativeQuery = true)
    public Iterable<Pengajuan> findPengajuan(String karyawan);

    @Query(value = "SELECT * FROM pengajuan INNER JOIN approval "
            + "ON pengajuan.approval_id=approval.approval_id "
            + "WHERE approval.approval_nama = 'accept' and pengajuan.deleted=0", nativeQuery = true)
    public Iterable<Pengajuan> allapproval();

    @Query(value = "SELECT count(pengajuan_id) FROM pengajuan INNER JOIN approval "
            + "ON pengajuan.approval_id=approval.approval_id "
            + "WHERE approval.approval_nama = 'pending'", nativeQuery = true)
    public long menunggu();

    @Query(value = "SELECT count(pengajuan_id) FROM pengajuan INNER JOIN approval "
            + "ON pengajuan.approval_id=approval.approval_id "
            + "WHERE approval.approval_nama = 'accept'", nativeQuery = true)
    public long diterima();

    @Query(value = "SELECT count(pengajuan_id) FROM pengajuan INNER JOIN approval "
            + "ON pengajuan.approval_id=approval.approval_id "
            + "WHERE approval.approval_nama = 'decline'", nativeQuery = true)
    public long ditolak();

    @Query(value = "SELECT COUNT(pengajuan_id) FROM pengajuan INNER JOIN karyawan "
            + "ON pengajuan.karyawan_id=karyawan.karyawan_id "
            + "WHERE karyawan.karyawan_nama = ?1", nativeQuery = true)
    public long pengajuanuser(String usernama);

    //Menampilkan data di perjalanan
    @Query(value = "SELECT karyawan.karyawan_nama, tujuandinas.tujuandinas_nama, kendaraan.kendaraan_nama, \n"
            + "pengajuan.pengajuan_kota_asal, pengajuan.pengajuan_kota_tujuan, \n"
            + "pengajuan.pengajuan_waktu_berangkat, pengajuan.pengajuan_waktu_pulang, \n"
            + "pengajuan.pengajuan_tanggal_berangkat, pengajuan.pengajuan_tanggal_pulang, \n"
            + "pengajuan.pengajuan_hotel\n"
            + "\n"
            + "FROM pengajuan\n"
            + "\n"
            + "INNER JOIN perjalanan ON perjalanan.pengajuan_id=pengajuan.pengajuan_id\n"
            + "INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id \n"
            + "INNER JOIN tujuandinas ON pengajuan.tujuandinas_id=tujuandinas.tujuandinas_id\n"
            + "INNER JOIN kendaraan ON pengajuan.kendaraan_id=kendaraan.kendaraan_id\n"
            + "WHERE pengajuan.pengajuan_id = ?1", nativeQuery = true)
    public Iterable<Pengajuan> simpanperjalanan(Integer idperjalanan);

    @Query(value = "SELECT * FROM pengajuan \n"
            + "INNER JOIN perjalanan ON pengajuan.pengajuan_id = perjalanan.pengajuan_id\n"
            + "WHERE perjalanan.perjalanan_id = ?1", nativeQuery = true)
    public Pengajuan caripengajuan(Integer idpengajuan);

    @Query(value = "SELECT * FROM pengajuan WHERE pengajuan_id = ?1", nativeQuery = true)
    public Pengajuan pilih(Integer pengajuanid1);

    @Query(value = "SELECT MONTHNAME(pengajuan_tanggal_berangkat) AS Bulan, COUNT(pengajuan_id) AS Jumlah_Pengajuan "
            + "FROM pengajuan where year(pengajuan_tanggal_berangkat) = year(NOW()) "
            + "GROUP BY MONTH(pengajuan_tanggal_berangkat)", nativeQuery = true)
    public List<Object[]> totalpengajuan();

    @Query(value = "SELECT MONTHNAME(pengajuan_tanggal_berangkat) AS Bulan, COUNT(pengajuan_id) AS Jumlah_Pengajuan \n"
            + "FROM pengajuan INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id WHERE karyawan.karyawan_nama = ?1 "
            + "GROUP BY MONTH(pengajuan_tanggal_berangkat)", nativeQuery = true)
    public List<Object[]> totalpengajuanuser(String nama);
    
    @Query(value = "SELECT COUNT(*) FROM pengajuan WHERE approval_id<>2", nativeQuery = true)
    public long hitung();
    
    @Query(value = "SELECT * FROM pengajuan WHERE approval_id<>2", nativeQuery = true)
    Iterable<Pengajuan> findAllpengajuan();
//    @Query(value = "SELECT MONTHNAME(pengajuan_tanggal_berangkat) AS Bulan, COUNT(pengajuan_id) AS Jumlah_Pengajuan "
//            + "FROM pengajuan where year(pengajuan_tanggal_berangkat) = year(NOW()) "
//            + "GROUP BY MONTH(pengajuan_tanggal_berangkat)", nativeQuery = true)
//    public List<PengajuanList> totalpengajuan();
//    @Query(value = "SELECT MONTHNAME(pengajuan_tanggal_berangkat) AS Bulan, COUNT(pengajuan_id) "
//            + "AS Jumlah_Pengajuan FROM pengajuan GROUP BY MONTH(pengajuan_tanggal_berangkat)", nativeQuery = true)
//    public List<PengajuanList> totalpengajuan();

//    @Query(value = "SELECT * FROM karyawan\n"
//            + "WHERE karyawan_nama = ?1", nativeQuery = true)
//    public Pengajuan findId(String id);
//    @Query(value = "SELECT * FROM pengajuan INNER JOIN karyawan ON "
//            + "pengajuan.karyawan_id=karyawan.karyawan_id WHERE "
//            + "karyawan.karyawan_nama = ?1 and pengajuan.deleted = ?2", nativeQuery = true)
//    public Iterable<Pengajuan> allsoftdelete(String karyawan, String deleteid);
    //    @Query(value = "SELECT * FROM pengajuan\n" +
//"INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id\n" +
//"WHERE karyawan.karyawan_nama = ?1", nativeQuery = true)
////    public Iterable<Pengajuan> findPengajuan(String karyawan);
//    @Query(value = "SELECT pengajuan.karyawan_id FROM pengajuan\n"
//            + "INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id\n"
//            + "WHERE karyawan.karyawan_nama = ?1", nativeQuery = true)
//    public Pengajuan findId(String id);
//    @Query(value = "SELECT * FROM pengajuan\n"
//            + "INNER JOIN karyawan ON pengajuan.karyawan_id=karyawan.karyawan_id\n"
//            + "WHERE karyawan.karyawan_nama = ?1 and pengajuan.deleted = 0", nativeQuery = true)
//    public Iterable<Pengajuan> findPengajuan(String karyawan);
    //Override CrudRepository or PagingAndSortingRepository's query method:
//    @Override
//    @Query("select * from pengajuan where deleted='false'")
//    public Iterable<Pengajuan> lihat(String deleted);
//
//    //Look up deleted entities
////    @Query("select e from #{#entityName} e where e.deleteFlag=true")
////    public List<T> recycleBin(); 
//
//    //Soft delete.
//    @Query("update pengajuan set deleted=true where pengajuan_id=?1")
//    @Modifying
//    public void softDelete(Integer pengajuan); 
}

//public interface RepoPengajuan extends JpaRepository<Pengajuan, Integer>{
//    
//}
