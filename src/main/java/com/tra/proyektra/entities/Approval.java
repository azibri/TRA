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
@Table(name = "approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approval.findAll", query = "SELECT a FROM Approval a")
    , @NamedQuery(name = "Approval.findByApprovalId", query = "SELECT a FROM Approval a WHERE a.approvalId = :approvalId")
    , @NamedQuery(name = "Approval.findByApprovalNama", query = "SELECT a FROM Approval a WHERE a.approvalNama = :approvalNama")})
public class Approval implements Serializable {

    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "approval_nama", length = 50)
    private String approvalNama;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Column(name = "approval_id")
    private Integer approvalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvalId", fetch = FetchType.LAZY)
    private List<Pengajuan> pengajuanList;

    public Approval() {
    }

    public Approval(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Approval(Integer approvalId, String approvalNama) {
        this.approvalId = approvalId;
        this.approvalNama = approvalNama;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalNama() {
        return approvalNama;
    }

    public void setApprovalNama(String approvalNama) {
        this.approvalNama = approvalNama;
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
        hash += (approvalId != null ? approvalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approval)) {
            return false;
        }
        Approval other = (Approval) object;
        if ((this.approvalId == null && other.approvalId != null) || (this.approvalId != null && !this.approvalId.equals(other.approvalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tra.proyektra.entities.Approval[ approvalId=" + approvalId + " ]";
    }
    
}
