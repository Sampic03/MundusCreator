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
@Table(name = "tbl_actividades")
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ACT_Id")
    private Integer pKACTId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ACT_Nombre")
    private String aCTNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "ACT_Descripcion")
    private String aCTDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ACT_Ruta")
    private String aCTRuta;
    @ManyToMany(mappedBy = "actividadesCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Actividades() {
    }

    public Actividades(Integer pKACTId) {
        this.pKACTId = pKACTId;
    }

    public Actividades(Integer pKACTId, String aCTNombre, String aCTDescripcion, String aCTRuta) {
        this.pKACTId = pKACTId;
        this.aCTNombre = aCTNombre;
        this.aCTDescripcion = aCTDescripcion;
        this.aCTRuta = aCTRuta;
    }

    public Integer getPKACTId() {
        return pKACTId;
    }

    public void setPKACTId(Integer pKACTId) {
        this.pKACTId = pKACTId;
    }

    public String getACTNombre() {
        return aCTNombre;
    }

    public void setACTNombre(String aCTNombre) {
        this.aCTNombre = aCTNombre;
    }

    public String getACTDescripcion() {
        return aCTDescripcion;
    }

    public void setACTDescripcion(String aCTDescripcion) {
        this.aCTDescripcion = aCTDescripcion;
    }

    public String getACTRuta() {
        return aCTRuta;
    }

    public void setACTRuta(String aCTRuta) {
        this.aCTRuta = aCTRuta;
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
        hash += (pKACTId != null ? pKACTId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.pKACTId == null && other.pKACTId != null) || (this.pKACTId != null && !this.pKACTId.equals(other.pKACTId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Actividades[ pKACTId=" + pKACTId + " ]";
    }
    
}
