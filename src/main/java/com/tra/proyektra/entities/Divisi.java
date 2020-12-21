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
@Table(name = "divisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisi.findAll", query = "SELECT d FROM Divisi d")
    , @NamedQuery(name = "Divisi.findByDivisiId", query = "SELECT d FROM Divisi d WHERE d.divisiId = :divisiId")
    , @NamedQuery(name = "Divisi.findByDivisiNama", query = "SELECT d FROM Divisi d WHERE d.divisiNama = :divisiNama")
    , @NamedQuery(name = "Divisi.findByDivisiKeterangan", query = "SELECT d FROM Divisi d WHERE d.divisiKeterangan = :divisiKeterangan")})
public class Divisi implements Serializable {

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "divisi_nama", length = 50)
    private String divisiNama;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "divisi_keterangan", length = 100)
    private String divisiKeterangan;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "divisi_id")
    private Integer divisiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisiId", fetch = FetchType.LAZY)
    private List<Karyawan> karyawanList;

    public Divisi() {
    }

    public Divisi(Integer divisiId) {
        this.divisiId = divisiId;
    }

    public Divisi(Integer divisiId, String divisiNama, String divisiKeterangan) {
        this.divisiId = divisiId;
        this.divisiNama = divisiNama;
        this.divisiKeterangan = divisiKeterangan;
    }

    public Integer getDivisiId() {
        return divisiId;
    }

    public void setDivisiId(Integer divisiId) {
        this.divisiId = divisiId;
    }

    public String getDivisiNama() {
        return divisiNama;
    }

    public void setDivisiNama(String divisiNama) {
        this.divisiNama = divisiNama;
    }

    public String getDivisiKeterangan() {
        return divisiKeterangan;
    }

    public void setDivisiKeterangan(String divisiKeterangan) {
        this.divisiKeterangan = divisiKeterangan;
    }

    @XmlTransient
    public List<Karyawan> getKaryawanList() {
        return karyawanList;
    }

    public void setKaryawanList(List<Karyawan> karyawanList) {
        this.karyawanList = karyawanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisiId != null ? divisiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisi)) {
            return false;
        }
        Divisi other = (Divisi) object;
        if ((this.divisiId == null && other.divisiId != null) || (this.divisiId != null && !this.divisiId.equals(other.divisiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Divisi[ divisiId=" + divisiId + " ]";
    }
    
}
