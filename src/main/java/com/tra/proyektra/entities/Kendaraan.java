/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "kendaraan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kendaraan.findAll", query = "SELECT k FROM Kendaraan k")
    , @NamedQuery(name = "Kendaraan.findByKendaraanId", query = "SELECT k FROM Kendaraan k WHERE k.kendaraanId = :kendaraanId")
    , @NamedQuery(name = "Kendaraan.findByKendaraanNama", query = "SELECT k FROM Kendaraan k WHERE k.kendaraanNama = :kendaraanNama")
    , @NamedQuery(name = "Kendaraan.findByKendaraanKeterangan", query = "SELECT k FROM Kendaraan k WHERE k.kendaraanKeterangan = :kendaraanKeterangan")})
public class Kendaraan implements Serializable {

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "kendaraan_nama", length = 50)
    private String kendaraanNama;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "kendaraan_keterangan", length = 100)
    private String kendaraanKeterangan;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kendaraan_id")
    private Integer kendaraanId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kendaraanId", fetch = FetchType.LAZY)
    private List<Pengajuan> pengajuanList;

    public Kendaraan() {
    }

    public Kendaraan(Integer kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public Kendaraan(Integer kendaraanId, String kendaraanNama, String kendaraanKeterangan) {
        this.kendaraanId = kendaraanId;
        this.kendaraanNama = kendaraanNama;
        this.kendaraanKeterangan = kendaraanKeterangan;
    }

    public Integer getKendaraanId() {
        return kendaraanId;
    }

    public void setKendaraanId(Integer kendaraanId) {
        this.kendaraanId = kendaraanId;
    }

    public String getKendaraanNama() {
        return kendaraanNama;
    }

    public void setKendaraanNama(String kendaraanNama) {
        this.kendaraanNama = kendaraanNama;
    }

    public String getKendaraanKeterangan() {
        return kendaraanKeterangan;
    }

    public void setKendaraanKeterangan(String kendaraanKeterangan) {
        this.kendaraanKeterangan = kendaraanKeterangan;
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
        hash += (kendaraanId != null ? kendaraanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kendaraan)) {
            return false;
        }
        Kendaraan other = (Kendaraan) object;
        if ((this.kendaraanId == null && other.kendaraanId != null) || (this.kendaraanId != null && !this.kendaraanId.equals(other.kendaraanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Kendaraan[ kendaraanId=" + kendaraanId + " ]";
    }

    
}
