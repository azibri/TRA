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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "pengajuan")
@SQLDelete(sql = "UPDATE pengajuan set deleted=true WHERE pengajuan_id = ?")
@Where(clause = "deleted = false")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pengajuan.findAll", query = "SELECT p FROM Pengajuan p")
    , @NamedQuery(name = "Pengajuan.findByPengajuanId", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanId = :pengajuanId")
    , @NamedQuery(name = "Pengajuan.findByPengajuanKotaAsal", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanKotaAsal = :pengajuanKotaAsal")
    , @NamedQuery(name = "Pengajuan.findByPengajuanKotaTujuan", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanKotaTujuan = :pengajuanKotaTujuan")
    , @NamedQuery(name = "Pengajuan.findByPengajuanWaktuBerangkat", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanWaktuBerangkat = :pengajuanWaktuBerangkat")
    , @NamedQuery(name = "Pengajuan.findByPengajuanWaktuPulang", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanWaktuPulang = :pengajuanWaktuPulang")
    , @NamedQuery(name = "Pengajuan.findByPengajuanTanggalBerangkat", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanTanggalBerangkat = :pengajuanTanggalBerangkat")
    , @NamedQuery(name = "Pengajuan.findByPengajuanTanggalPulang", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanTanggalPulang = :pengajuanTanggalPulang")
    , @NamedQuery(name = "Pengajuan.findByPengajuanHotel", query = "SELECT p FROM Pengajuan p WHERE p.pengajuanHotel = :pengajuanHotel")
    , @NamedQuery(name = "Pengajuan.findByDeleted", query = "SELECT p FROM Pengajuan p WHERE p.deleted = :deleted")})
public class Pengajuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pengajuan_id")
    private Integer pengajuanId;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pengajuan_kota_asal")
    private String pengajuanKotaAsal;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pengajuan_kota_tujuan")
    private String pengajuanKotaTujuan;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pengajuan_waktu_berangkat")
    private String pengajuanWaktuBerangkat;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pengajuan_waktu_pulang")
    private String pengajuanWaktuPulang;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "pengajuan_tanggal_berangkat")
    @Temporal(TemporalType.DATE)
    private Date pengajuanTanggalBerangkat;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "pengajuan_tanggal_pulang")
    @Temporal(TemporalType.DATE)
    private Date pengajuanTanggalPulang;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pengajuan_hotel")
    private String pengajuanHotel;
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "deleted")
    private String deleted;
    @Basic(optional = false)
//    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pengajuan_komentar")
    private String pengajuanKomentar;
    @JoinColumn(name = "approval_id", referencedColumnName = "approval_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Approval approvalId;
    @JoinColumn(name = "karyawan_id", referencedColumnName = "karyawan_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Karyawan karyawanId;
    @JoinColumn(name = "kendaraan_id", referencedColumnName = "kendaraan_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kendaraan kendaraanId;
    @JoinColumn(name = "tujuandinas_id", referencedColumnName = "tujuandinas_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tujuandinas tujuandinasId;

    public Pengajuan() {
    }

    public Pengajuan(Integer pengajuanId) {
        this.pengajuanId = pengajuanId;
    }

    public Pengajuan(Integer pengajuanId, String pengajuanKotaAsal, String pengajuanKotaTujuan, String pengajuanWaktuBerangkat, String pengajuanWaktuPulang, Date pengajuanTanggalBerangkat, Date pengajuanTanggalPulang, String pengajuanHotel, String deleted, String pengajuanKomentar) {
        this.pengajuanId = pengajuanId;
        this.pengajuanKotaAsal = pengajuanKotaAsal;
        this.pengajuanKotaTujuan = pengajuanKotaTujuan;
        this.pengajuanWaktuBerangkat = pengajuanWaktuBerangkat;
        this.pengajuanWaktuPulang = pengajuanWaktuPulang;
        this.pengajuanTanggalBerangkat = pengajuanTanggalBerangkat;
        this.pengajuanTanggalPulang = pengajuanTanggalPulang;
        this.pengajuanHotel = pengajuanHotel;
        this.deleted = deleted;
        this.pengajuanKomentar = pengajuanKomentar;
    }

    public Pengajuan(String pengajuankotaasal, String pengajuankotatujuan, String pengajuanwaktuberangkat, String pengajuanwaktupulang, Date pengajuantanggalberangkat, Date pengajuantanggalpulang, String pengajuanhotel, String deleted, Integer pengajuan_id, Karyawan karyawan_id, Kendaraan jeniskendaraan_id, Tujuandinas tujuandinas_id, Approval approval_id) {
        this.pengajuanKotaAsal = pengajuankotaasal;
        this.pengajuanKotaTujuan = pengajuankotatujuan;
        this.pengajuanWaktuBerangkat = pengajuanwaktuberangkat;
        this.pengajuanWaktuPulang = pengajuanwaktupulang;
        this.pengajuanTanggalBerangkat = pengajuantanggalberangkat;
        this.pengajuanTanggalPulang = pengajuantanggalpulang;
        this.pengajuanHotel = pengajuanhotel;
        this.deleted = deleted;
        this.pengajuanId = pengajuan_id;
        this.karyawanId = karyawan_id;
        this.kendaraanId = jeniskendaraan_id;
        this.tujuandinasId = tujuandinas_id;
        this.approvalId = approval_id;
    }
//    public Pengajuan(String pengajuankotaasal, String pengajuankotatujuan, String pengajuanwaktuberangkat, String pengajuanwaktupulang, Date pengajuantanggalberangkat, Date pengajuantanggalpulang, String pengajuanhotel, String deleted, String pengajuanKomentar, Integer pengajuan_id, Karyawan karyawan_id, Kendaraan jeniskendaraan_id, Tujuandinas tujuandinas_id, Approval approval_id) {
//        this.pengajuanKotaAsal = pengajuankotaasal;
//        this.pengajuanKotaTujuan = pengajuankotatujuan;
//        this.pengajuanWaktuBerangkat = pengajuanwaktuberangkat;
//        this.pengajuanWaktuPulang = pengajuanwaktupulang;
//        this.pengajuanTanggalBerangkat = pengajuantanggalberangkat;
//        this.pengajuanTanggalPulang = pengajuantanggalpulang;
//        this.pengajuanHotel = pengajuanhotel;
//        this.deleted = deleted;
//        this.pengajuanKomentar = pengajuanKomentar;
//        this.pengajuanId = pengajuan_id;
//        this.karyawanId = karyawan_id;
//        this.kendaraanId = jeniskendaraan_id;
//        this.tujuandinasId = tujuandinas_id;
//        this.approvalId = approval_id;
//    }

    public Pengajuan(Date tanggalberangkat, Date tanggalpulang) {
        this.pengajuanTanggalBerangkat = tanggalberangkat;
        this.pengajuanTanggalPulang = tanggalpulang;
    }

    public Integer getPengajuanId() {
        return pengajuanId;
    }

    public void setPengajuanId(Integer pengajuanId) {
        this.pengajuanId = pengajuanId;
    }

    public String getPengajuanKotaAsal() {
        return pengajuanKotaAsal;
    }

    public void setPengajuanKotaAsal(String pengajuanKotaAsal) {
        this.pengajuanKotaAsal = pengajuanKotaAsal;
    }

    public String getPengajuanKotaTujuan() {
        return pengajuanKotaTujuan;
    }

    public void setPengajuanKotaTujuan(String pengajuanKotaTujuan) {
        this.pengajuanKotaTujuan = pengajuanKotaTujuan;
    }

    public String getPengajuanWaktuBerangkat() {
        return pengajuanWaktuBerangkat;
    }

    public void setPengajuanWaktuBerangkat(String pengajuanWaktuBerangkat) {
        this.pengajuanWaktuBerangkat = pengajuanWaktuBerangkat;
    }

    public String getPengajuanWaktuPulang() {
        return pengajuanWaktuPulang;
    }

    public void setPengajuanWaktuPulang(String pengajuanWaktuPulang) {
        this.pengajuanWaktuPulang = pengajuanWaktuPulang;
    }

    public Date getPengajuanTanggalBerangkat() {
        return pengajuanTanggalBerangkat;
    }

    public void setPengajuanTanggalBerangkat(Date pengajuanTanggalBerangkat) {
        this.pengajuanTanggalBerangkat = pengajuanTanggalBerangkat;
    }

    public Date getPengajuanTanggalPulang() {
        return pengajuanTanggalPulang;
    }

    public void setPengajuanTanggalPulang(Date pengajuanTanggalPulang) {
        this.pengajuanTanggalPulang = pengajuanTanggalPulang;
    }

    public String getPengajuanHotel() {
        return pengajuanHotel;
    }

    public void setPengajuanHotel(String pengajuanHotel) {
        this.pengajuanHotel = pengajuanHotel;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getPengajuanKomentar() {
        return pengajuanKomentar;
    }

    public void setPengajuanKomentar(String pengajuanKomentar) {
        this.pengajuanKomentar = pengajuanKomentar;
    }

    public Approval getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Approval approvalId) {
        this.approvalId = approvalId;
    }

    public Karyawan getKaryawanId() {
        return karyawanId;
    }

    public void setKaryawanId(Karyawan karyawanId) {
        this.karyawanId = karyawanId;
    }

    public Kendaraan getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(Kendaraan kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public Tujuandinas getTujuandinasId() {
        return tujuandinasId;
    }

    public void setTujuandinasId(Tujuandinas tujuandinasId) {
        this.tujuandinasId = tujuandinasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pengajuanId != null ? pengajuanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pengajuan)) {
            return false;
        }
        Pengajuan other = (Pengajuan) object;
        if ((this.pengajuanId == null && other.pengajuanId != null) || (this.pengajuanId != null && !this.pengajuanId.equals(other.pengajuanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Pengajuan[ pengajuanId=" + pengajuanId + " ]";
    }

}
