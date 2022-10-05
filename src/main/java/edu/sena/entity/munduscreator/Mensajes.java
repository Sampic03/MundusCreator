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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sr992
 */
@Entity
@Table(name = "tbl_mensajes")
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_MEN_Id")
    private Integer pKMENId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MEN_ descripcion")
    private String mENdescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MEN_Fecha")
    private String mENFecha;
    @JoinColumn(name = "FK_EST_Id", referencedColumnName = "PK_EST_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estados fKESTId;
    @JoinColumn(name = "FK_ROL_Id", referencedColumnName = "PK_ROL_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles fKROLId;

    public Mensajes() {
    }

    public Mensajes(Integer pKMENId) {
        this.pKMENId = pKMENId;
    }

    public Mensajes(Integer pKMENId, String mENdescripcion, String mENFecha) {
        this.pKMENId = pKMENId;
        this.mENdescripcion = mENdescripcion;
        this.mENFecha = mENFecha;
    }

    public Integer getPKMENId() {
        return pKMENId;
    }

    public void setPKMENId(Integer pKMENId) {
        this.pKMENId = pKMENId;
    }

    public String getMENdescripcion() {
        return mENdescripcion;
    }

    public void setMENdescripcion(String mENdescripcion) {
        this.mENdescripcion = mENdescripcion;
    }

    public String getMENFecha() {
        return mENFecha;
    }

    public void setMENFecha(String mENFecha) {
        this.mENFecha = mENFecha;
    }

    public Estados getFKESTId() {
        return fKESTId;
    }

    public void setFKESTId(Estados fKESTId) {
        this.fKESTId = fKESTId;
    }

    public Roles getFKROLId() {
        return fKROLId;
    }

    public void setFKROLId(Roles fKROLId) {
        this.fKROLId = fKROLId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKMENId != null ? pKMENId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.pKMENId == null && other.pKMENId != null) || (this.pKMENId != null && !this.pKMENId.equals(other.pKMENId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Mensajes[ pKMENId=" + pKMENId + " ]";
    }
    
}
