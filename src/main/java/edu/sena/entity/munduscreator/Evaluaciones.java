/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_evaluaciones")
@NamedQueries({
    @NamedQuery(name = "Evaluaciones.findAll", query = "SELECT e FROM Evaluaciones e")})
public class Evaluaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_EVA_Id")
    private Integer pKEVAId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVA_Nombre")
    private String eVANombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "EVA_Descripcion")
    private String eVADescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EVA_Ruta")
    private String eVARuta;
    @ManyToMany(mappedBy = "evaluacionesCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Evaluaciones() {
    }

    public Evaluaciones(Integer pKEVAId) {
        this.pKEVAId = pKEVAId;
    }

    public Evaluaciones(Integer pKEVAId, String eVANombre, String eVADescripcion, String eVARuta) {
        this.pKEVAId = pKEVAId;
        this.eVANombre = eVANombre;
        this.eVADescripcion = eVADescripcion;
        this.eVARuta = eVARuta;
    }

    public Integer getPKEVAId() {
        return pKEVAId;
    }

    public void setPKEVAId(Integer pKEVAId) {
        this.pKEVAId = pKEVAId;
    }

    public String getEVANombre() {
        return eVANombre;
    }

    public void setEVANombre(String eVANombre) {
        this.eVANombre = eVANombre;
    }

    public String getEVADescripcion() {
        return eVADescripcion;
    }

    public void setEVADescripcion(String eVADescripcion) {
        this.eVADescripcion = eVADescripcion;
    }

    public String getEVARuta() {
        return eVARuta;
    }

    public void setEVARuta(String eVARuta) {
        this.eVARuta = eVARuta;
    }

    public Collection<Papeleria> getPapeleriaCollection() {
        return papeleriaCollection;
    }

    public void setPapeleriaCollection(Collection<Papeleria> papeleriaCollection) {
        this.papeleriaCollection = papeleriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKEVAId != null ? pKEVAId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluaciones)) {
            return false;
        }
        Evaluaciones other = (Evaluaciones) object;
        if ((this.pKEVAId == null && other.pKEVAId != null) || (this.pKEVAId != null && !this.pKEVAId.equals(other.pKEVAId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Evaluaciones[ pKEVAId=" + pKEVAId + " ]";
    }
    
}
