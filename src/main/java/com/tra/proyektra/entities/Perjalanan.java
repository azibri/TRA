/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "perjalanan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perjalanan.findAll", query = "SELECT p FROM Perjalanan p")
    , @NamedQuery(name = "Perjalanan.findByPerjalananId", query = "SELECT p FROM Perjalanan p WHERE p.perjalananId = :perjalananId")
    , @NamedQuery(name = "Perjalanan.findByPerjalananKaryawan", query = "SELECT p FROM Perjalanan p WHERE p.perjalananKaryawan = :perjalananKaryawan")
    , @NamedQuery(name = "Perjalanan.findByPerjalananTujuanDinas", query = "SELECT p FROM Perjalanan p WHERE p.perjalananTujuanDinas = :perjalananTujuanDinas")
    , @NamedQuery(name = "Perjalanan.findByPerjalananKendaraan", query = "SELECT p FROM Perjalanan p WHERE p.perjalananKendaraan = :perjalananKendaraan")
    , @NamedQuery(name = "Perjalanan.findByPerjalananKotaAsal", query = "SELECT p FROM Perjalanan p WHERE p.perjalananKotaAsal = :perjalananKotaAsal")
    , @NamedQuery(name = "Perjalanan.findByPerjalananKotaTujuan", query = "SELECT p FROM Perjalanan p WHERE p.perjalananKotaTujuan = :perjalananKotaTujuan")
    , @NamedQuery(name = "Perjalanan.findByPerjalananWaktuBerangkat", query = "SELECT p FROM Perjalanan p WHERE p.perjalananWaktuBerangkat = :perjalananWaktuBerangkat")
    , @NamedQuery(name = "Perjalanan.findByPerjalananWaktuPulang", query = "SELECT p FROM Perjalanan p WHERE p.perjalananWaktuPulang = :perjalananWaktuPulang")
    , @NamedQuery(name = "Perjalanan.findByPerjalananTanggalBerangkat", query = "SELECT p FROM Perjalanan p WHERE p.perjalananTanggalBerangkat = :perjalananTanggalBerangkat")
    , @NamedQuery(name = "Perjalanan.findByPerjalananTanggalPulang", query = "SELECT p FROM Perjalanan p WHERE p.perjalananTanggalPulang = :perjalananTanggalPulang")
    , @NamedQuery(name = "Perjalanan.findByPerjalananHotel", query = "SELECT p FROM Perjalanan p WHERE p.perjalananHotel = :perjalananHotel")
    , @NamedQuery(name = "Perjalanan.findByPerjalananTotalDiem", query = "SELECT p FROM Perjalanan p WHERE p.perjalananTotalDiem = :perjalananTotalDiem")})
public class Perjalanan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perjalanan_id")
    private Integer perjalananId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "perjalanan_karyawan")
    private String perjalananKaryawan;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perjalanan_tujuan_dinas")
    private String perjalananTujuanDinas;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perjalanan_kendaraan")
    private String perjalananKendaraan;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perjalanan_kota_asal")
    private String perjalananKotaAsal;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "perjalanan_kota_tujuan")
    private String perjalananKotaTujuan;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "perjalanan_waktu_berangkat")
    @Temporal(TemporalType.TIME)
    private Date perjalananWaktuBerangkat;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "perjalanan_waktu_pulang")
    @Temporal(TemporalType.TIME)
    private Date perjalananWaktuPulang;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "perjalanan_tanggal_berangkat")
    @Temporal(TemporalType.DATE)
    private Date perjalananTanggalBerangkat;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "perjalanan_tanggal_pulang")
    @Temporal(TemporalType.DATE)
    private Date perjalananTanggalPulang;
    @Size(max = 100)
    @Column(name = "perjalanan_hotel")
    private String perjalananHotel;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "perjalanan_total_diem")
    private int perjalananTotalDiem;
    @JoinColumn(name = "pengajuan_id", referencedColumnName = "pengajuan_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pengajuan pengajuanId;

    public Perjalanan() {
    }

    public Perjalanan(Integer perjalananId) {
        this.perjalananId = perjalananId;
    }

    public Perjalanan(Integer perjalananId, String perjalananKaryawan, String perjalananTujuanDinas, String perjalananKendaraan, String perjalananKotaAsal, String perjalananKotaTujuan, Date perjalananWaktuBerangkat, Date perjalananWaktuPulang, Date perjalananTanggalBerangkat, Date perjalananTanggalPulang, int perjalananTotalDiem) {
        this.perjalananId = perjalananId;
        this.perjalananKaryawan = perjalananKaryawan;
        this.perjalananTujuanDinas = perjalananTujuanDinas;
        this.perjalananKendaraan = perjalananKendaraan;
        this.perjalananKotaAsal = perjalananKotaAsal;
        this.perjalananKotaTujuan = perjalananKotaTujuan;
        this.perjalananWaktuBerangkat = perjalananWaktuBerangkat;
        this.perjalananWaktuPulang = perjalananWaktuPulang;
        this.perjalananTanggalBerangkat = perjalananTanggalBerangkat;
        this.perjalananTanggalPulang = perjalananTanggalPulang;
        this.perjalananTotalDiem = perjalananTotalDiem;
    }

//    public Perjalanan(Pengajuan pengajuanId, String karyawan, String tujuandinas, String kendaraan, String kotaasal, String kotatujuan, Date waktuberangkat, Date waktupulang, Date tanggalberangkat, Date tanggalpulang, String hotel, Integer totaldiem) {
//        this.pengajuanId = pengajuanId;
//        this.perjalananKaryawan = karyawan;
//        this.perjalananTujuanDinas = tujuandinas;
//        this.perjalananKendaraan = kendaraan;
//        this.perjalananKotaAsal = kotaasal;
//        this.perjalananKotaTujuan = kotatujuan;
//        this.perjalananWaktuBerangkat = waktuberangkat;
//        this.perjalananWaktuPulang = waktupulang;
//        this.perjalananTanggalBerangkat = tanggalberangkat;
//        this.perjalananTanggalPulang = tanggalpulang;
//        this.perjalananHotel = hotel;
//        this.perjalananTotalDiem = totaldiem;
//    }

    public Perjalanan(Pengajuan pengajuan, String karyawan, String tujuandinas, String kendaraan, String kotaasal, String kotatujuan, Date waktuberangkat, Date waktupulang, Date tanggalberangkat, Date tanggalpulang, String hotel, Integer totaldiem) {
        this.pengajuanId = pengajuan;
        this.perjalananKaryawan = karyawan;
        this.perjalananTujuanDinas = tujuandinas;
        this.perjalananKendaraan = kendaraan;
        this.perjalananKotaAsal = kotaasal;
        this.perjalananKotaTujuan = kotatujuan;
        this.perjalananWaktuBerangkat = waktuberangkat;
        this.perjalananWaktuPulang = waktupulang;
        this.perjalananTanggalBerangkat = tanggalberangkat;
        this.perjalananTanggalPulang = tanggalpulang;
        this.perjalananHotel = hotel;
        this.perjalananTotalDiem = totaldiem;
    }

    public Integer getPerjalananId() {
        return perjalananId;
    }

    public void setPerjalananId(Integer perjalananId) {
        this.perjalananId = perjalananId;
    }

    public String getPerjalananKaryawan() {
        return perjalananKaryawan;
    }

    public void setPerjalananKaryawan(String perjalananKaryawan) {
        this.perjalananKaryawan = perjalananKaryawan;
    }

    public String getPerjalananTujuanDinas() {
        return perjalananTujuanDinas;
    }

    public void setPerjalananTujuanDinas(String perjalananTujuanDinas) {
        this.perjalananTujuanDinas = perjalananTujuanDinas;
    }

    public String getPerjalananKendaraan() {
        return perjalananKendaraan;
    }

    public void setPerjalananKendaraan(String perjalananKendaraan) {
        this.perjalananKendaraan = perjalananKendaraan;
    }

    public String getPerjalananKotaAsal() {
        return perjalananKotaAsal;
    }

    public void setPerjalananKotaAsal(String perjalananKotaAsal) {
        this.perjalananKotaAsal = perjalananKotaAsal;
    }

    public String getPerjalananKotaTujuan() {
        return perjalananKotaTujuan;
    }

    public void setPerjalananKotaTujuan(String perjalananKotaTujuan) {
        this.perjalananKotaTujuan = perjalananKotaTujuan;
    }

    public Date getPerjalananWaktuBerangkat() {
        return perjalananWaktuBerangkat;
    }

    public void setPerjalananWaktuBerangkat(Date perjalananWaktuBerangkat) {
        this.perjalananWaktuBerangkat = perjalananWaktuBerangkat;
    }

    public Date getPerjalananWaktuPulang() {
        return perjalananWaktuPulang;
    }

    public void setPerjalananWaktuPulang(Date perjalananWaktuPulang) {
        this.perjalananWaktuPulang = perjalananWaktuPulang;
    }

    public Date getPerjalananTanggalBerangkat() {
        return perjalananTanggalBerangkat;
    }

    public void setPerjalananTanggalBerangkat(Date perjalananTanggalBerangkat) {
        this.perjalananTanggalBerangkat = perjalananTanggalBerangkat;
    }

    public Date getPerjalananTanggalPulang() {
        return perjalananTanggalPulang;
    }

    public void setPerjalananTanggalPulang(Date perjalananTanggalPulang) {
        this.perjalananTanggalPulang = perjalananTanggalPulang;
    }

    public String getPerjalananHotel() {
        return perjalananHotel;
    }

    public void setPerjalananHotel(String perjalananHotel) {
        this.perjalananHotel = perjalananHotel;
    }

    public int getPerjalananTotalDiem() {
        return perjalananTotalDiem;
    }

    public void setPerjalananTotalDiem(int perjalananTotalDiem) {
        this.perjalananTotalDiem = perjalananTotalDiem;
    }

    public Pengajuan getPengajuanId() {
        return pengajuanId;
    }

    public void setPengajuanId(Pengajuan pengajuanId) {
        this.pengajuanId = pengajuanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perjalananId != null ? perjalananId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perjalanan)) {
            return false;
        }
        Perjalanan other = (Perjalanan) object;
        if ((this.perjalananId == null && other.perjalananId != null) || (this.perjalananId != null && !this.perjalananId.equals(other.perjalananId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Perjalanan[ perjalananId=" + perjalananId + " ]";
    }
    
}
