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
@Table(name = "tbl_documentos")
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d")})
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_DOC_Id")
    private Integer pKDOCId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOC_Nombre")
    private String dOCNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "DOC_Descripcion")
    private String dOCDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOC_Ruta")
    private String dOCRuta;
    @ManyToMany(mappedBy = "documentosCollection", fetch = FetchType.LAZY)
    private Collection<Papeleria> papeleriaCollection;

    public Documentos() {
    }

    public Documentos(Integer pKDOCId) {
        this.pKDOCId = pKDOCId;
    }

    public Documentos(Integer pKDOCId, String dOCNombre, String dOCDescripcion, String dOCRuta) {
        this.pKDOCId = pKDOCId;
        this.dOCNombre = dOCNombre;
        this.dOCDescripcion = dOCDescripcion;
        this.dOCRuta = dOCRuta;
    }

    public Integer getPKDOCId() {
        return pKDOCId;
    }

    public void setPKDOCId(Integer pKDOCId) {
        this.pKDOCId = pKDOCId;
    }

    public String getDOCNombre() {
        return dOCNombre;
    }

    public void setDOCNombre(String dOCNombre) {
        this.dOCNombre = dOCNombre;
    }

    public String getDOCDescripcion() {
        return dOCDescripcion;
    }

    public void setDOCDescripcion(String dOCDescripcion) {
        this.dOCDescripcion = dOCDescripcion;
    }

    public String getDOCRuta() {
        return dOCRuta;
    }

    public void setDOCRuta(String dOCRuta) {
        this.dOCRuta = dOCRuta;
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
        hash += (pKDOCId != null ? pKDOCId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.pKDOCId == null && other.pKDOCId != null) || (this.pKDOCId != null && !this.pKDOCId.equals(other.pKDOCId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Documentos[ pKDOCId=" + pKDOCId + " ]";
    }
    
}
