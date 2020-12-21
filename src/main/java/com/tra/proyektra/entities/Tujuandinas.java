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
@Table(name = "tujuandinas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tujuandinas.findAll", query = "SELECT t FROM Tujuandinas t")
    , @NamedQuery(name = "Tujuandinas.findByTujuandinasId", query = "SELECT t FROM Tujuandinas t WHERE t.tujuandinasId = :tujuandinasId")
    , @NamedQuery(name = "Tujuandinas.findByTujuandinasNama", query = "SELECT t FROM Tujuandinas t WHERE t.tujuandinasNama = :tujuandinasNama")
    , @NamedQuery(name = "Tujuandinas.findByTujuandinasDiem", query = "SELECT t FROM Tujuandinas t WHERE t.tujuandinasDiem = :tujuandinasDiem")
    , @NamedQuery(name = "Tujuandinas.findByTujuandinasKeterangan", query = "SELECT t FROM Tujuandinas t WHERE t.tujuandinasKeterangan = :tujuandinasKeterangan")})
public class Tujuandinas implements Serializable {

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "tujuandinas_nama", length = 50)
    private String tujuandinasNama;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "tujuandinas_keterangan", length = 100)
    private String tujuandinasKeterangan;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tujuandinas_id")
    private Integer tujuandinasId;
    @Basic(optional = false)
//    @NotNull
    @Column(name = "tujuandinas_diem")
    private int tujuandinasDiem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tujuandinasId", fetch = FetchType.LAZY)
    private List<Pengajuan> pengajuanList;

    public Tujuandinas() {
    }

    public Tujuandinas(Integer tujuandinasId) {
        this.tujuandinasId = tujuandinasId;
    }

    public Tujuandinas(Integer tujuandinasId, String tujuandinasNama, int tujuandinasDiem, String tujuandinasKeterangan) {
        this.tujuandinasId = tujuandinasId;
        this.tujuandinasNama = tujuandinasNama;
        this.tujuandinasDiem = tujuandinasDiem;
        this.tujuandinasKeterangan = tujuandinasKeterangan;
    }

    public Integer getTujuandinasId() {
        return tujuandinasId;
    }

    public void setTujuandinasId(Integer tujuandinasId) {
        this.tujuandinasId = tujuandinasId;
    }

    public String getTujuandinasNama() {
        return tujuandinasNama;
    }

    public void setTujuandinasNama(String tujuandinasNama) {
        this.tujuandinasNama = tujuandinasNama;
    }

    public int getTujuandinasDiem() {
        return tujuandinasDiem;
    }

    public void setTujuandinasDiem(int tujuandinasDiem) {
        this.tujuandinasDiem = tujuandinasDiem;
    }

    public String getTujuandinasKeterangan() {
        return tujuandinasKeterangan;
    }

    public void setTujuandinasKeterangan(String tujuandinasKeterangan) {
        this.tujuandinasKeterangan = tujuandinasKeterangan;
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
        hash += (tujuandinasId != null ? tujuandinasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tujuandinas)) {
            return false;
        }
        Tujuandinas other = (Tujuandinas) object;
        if ((this.tujuandinasId == null && other.tujuandinasId != null) || (this.tujuandinasId != null && !this.tujuandinasId.equals(other.tujuandinasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Tujuandinas[ tujuandinasId=" + tujuandinasId + " ]";
    }
    
}
