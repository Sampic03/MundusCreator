/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
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

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "tbl_certificados")
@NamedQueries({
    @NamedQuery(name = "Certificados.findAll", query = "SELECT c FROM Certificados c")})
public class Certificados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_CER_Id")
    private Integer pKCERId;
    @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuarios fKUSUId;
    @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cursos fKCURId;

    public Certificados() {
    }

    public Certificados(Integer pKCERId) {
        this.pKCERId = pKCERId;
    }

    public Integer getPKCERId() {
        return pKCERId;
    }

    public void setPKCERId(Integer pKCERId) {
        this.pKCERId = pKCERId;
    }

    public Usuarios getFKUSUId() {
        return fKUSUId;
    }

    public void setFKUSUId(Usuarios fKUSUId) {
        this.fKUSUId = fKUSUId;
    }

    public Cursos getFKCURId() {
        return fKCURId;
    }

    public void setFKCURId(Cursos fKCURId) {
        this.fKCURId = fKCURId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKCERId != null ? pKCERId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificados)) {
            return false;
        }
        Certificados other = (Certificados) object;
        if ((this.pKCERId == null && other.pKCERId != null) || (this.pKCERId != null && !this.pKCERId.equals(other.pKCERId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Certificados[ pKCERId=" + pKCERId + " ]";
    }
    
}
