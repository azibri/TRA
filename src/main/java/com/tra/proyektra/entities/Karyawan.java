/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "karyawan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k")
    , @NamedQuery(name = "Karyawan.findByKaryawanId", query = "SELECT k FROM Karyawan k WHERE k.karyawanId = :karyawanId")
    , @NamedQuery(name = "Karyawan.findByKaryawanNama", query = "SELECT k FROM Karyawan k WHERE k.karyawanNama = :karyawanNama")
    , @NamedQuery(name = "Karyawan.findByKaryawanJenisKelamin", query = "SELECT k FROM Karyawan k WHERE k.karyawanJenisKelamin = :karyawanJenisKelamin")
    , @NamedQuery(name = "Karyawan.findByKaryawanTanggalLahir", query = "SELECT k FROM Karyawan k WHERE k.karyawanTanggalLahir = :karyawanTanggalLahir")
    , @NamedQuery(name = "Karyawan.findByKaryawanEmail", query = "SELECT k FROM Karyawan k WHERE k.karyawanEmail = :karyawanEmail")
    , @NamedQuery(name = "Karyawan.findByKaryawanAlamat", query = "SELECT k FROM Karyawan k WHERE k.karyawanAlamat = :karyawanAlamat")
    , @NamedQuery(name = "Karyawan.findByKaryawanRole", query = "SELECT k FROM Karyawan k WHERE k.karyawanRole = :karyawanRole")
    , @NamedQuery(name = "Karyawan.findByKaryawanPassword", query = "SELECT k FROM Karyawan k WHERE k.karyawanPassword = :karyawanPassword")
    , @NamedQuery(name = "Karyawan.findByActive", query = "SELECT k FROM Karyawan k WHERE k.active = :active")})
public class Karyawan implements Serializable {

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "karyawan_nama", length = 50)
    private String karyawanNama;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
    @Column(name = "karyawan_jenis_kelamin", length = 10)
    private String karyawanJenisKelamin;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "karyawan_email", length = 50)
    private String karyawanEmail;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "karyawan_alamat", length = 50)
    private String karyawanAlamat;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    @Column(name = "karyawan_role", length = 20)
    private String karyawanRole;
//    @Size(max = 100)
    @Column(name = "karyawan_password", length = 100)
    private String karyawanPassword;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "karyawan_id")
    private Integer karyawanId;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "karyawan_tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private Date karyawanTanggalLahir;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "divisi_id", referencedColumnName = "divisi_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Divisi divisiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "karyawanId", fetch = FetchType.LAZY)
    private List<Pengajuan> pengajuanList;

    public Karyawan() {
    }

    public Karyawan(Integer karyawanId) {
        this.karyawanId = karyawanId;
    }

    public Karyawan(Integer karyawanId, String karyawanNama, String karyawanJenisKelamin, Date karyawanTanggalLahir, String karyawanEmail, String karyawanAlamat, String karyawanRole) {
        this.karyawanId = karyawanId;
        this.karyawanNama = karyawanNama;
        this.karyawanJenisKelamin = karyawanJenisKelamin;
        this.karyawanTanggalLahir = karyawanTanggalLahir;
        this.karyawanEmail = karyawanEmail;
        this.karyawanAlamat = karyawanAlamat;
        this.karyawanRole = karyawanRole;
    }
    
    public Karyawan(Integer karyawanId, Divisi divisi, String karyawanNama, String karyawanJenisKelamin, Date karyawanTanggalLahir, String karyawanEmail, String karyawanAlamat, String karyawanRole) {
        this.karyawanId = karyawanId;
        this.divisiId = divisi;
        this.karyawanNama = karyawanNama;
        this.karyawanJenisKelamin = karyawanJenisKelamin;
        this.karyawanTanggalLahir = karyawanTanggalLahir;
        this.karyawanEmail = karyawanEmail;
        this.karyawanAlamat = karyawanAlamat;
        this.karyawanRole = karyawanRole;
    }

    public Integer getKaryawanId() {
        return karyawanId;
    }

    public void setKaryawanId(Integer karyawanId) {
        this.karyawanId = karyawanId;
    }

    public String getKaryawanNama() {
        return karyawanNama;
    }

    public void setKaryawanNama(String karyawanNama) {
        this.karyawanNama = karyawanNama;
    }

    public String getKaryawanJenisKelamin() {
        return karyawanJenisKelamin;
    }

    public void setKaryawanJenisKelamin(String karyawanJenisKelamin) {
        this.karyawanJenisKelamin = karyawanJenisKelamin;
    }

    public Date getKaryawanTanggalLahir() {
        return karyawanTanggalLahir;
    }

    public void setKaryawanTanggalLahir(Date karyawanTanggalLahir) {
        this.karyawanTanggalLahir = karyawanTanggalLahir;
    }

    public String getKaryawanEmail() {
        return karyawanEmail;
    }

    public void setKaryawanEmail(String karyawanEmail) {
        this.karyawanEmail = karyawanEmail;
    }

    public String getKaryawanAlamat() {
        return karyawanAlamat;
    }

    public void setKaryawanAlamat(String karyawanAlamat) {
        this.karyawanAlamat = karyawanAlamat;
    }

    public String getKaryawanRole() {
        return karyawanRole;
    }

    public void setKaryawanRole(String karyawanRole) {
        this.karyawanRole = karyawanRole;
    }

    public String getKaryawanPassword() {
        return karyawanPassword;
    }

    public void setKaryawanPassword(String karyawanPassword) {
        this.karyawanPassword = karyawanPassword;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Divisi getDivisiId() {
        return divisiId;
    }

    public void setDivisiId(Divisi divisiId) {
        this.divisiId = divisiId;
    }

    @XmlTransient
    public List<Pengajuan> getPengajuanList() {
        return pengajuanList;
    }

    public void setPengajuanList(List<Pengajuan> pengajuanList) {
        this.pengajuanList = pengajuanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (karyawanId != null ? karyawanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.karyawanId == null && other.karyawanId != null) || (this.karyawanId != null && !this.karyawanId.equals(other.karyawanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Karyawan[ karyawanId=" + karyawanId + " ]";
    }

    
}
