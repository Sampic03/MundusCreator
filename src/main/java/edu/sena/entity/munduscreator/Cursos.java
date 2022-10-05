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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "tbl_cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_CUR_Id")
    private Integer pKCURId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CUR_nombre")
    private String cURnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CUR_Fecha_Creacion")
    private String cURFechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CUR_Descripcion")
    private String cURDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "CUR_IMAGEN")
    private String curImagen;
    @ManyToMany(mappedBy = "cursosCollection", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @ManyToMany(mappedBy = "cursosCollection1", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection1;
    @ManyToMany(mappedBy = "cursosCollection2", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection2;
    @JoinColumn(name = "FK_MUL_Id", referencedColumnName = "PK_MUL_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Multimedia fKMULId;
    @JoinColumn(name = "FK_PAP_Id", referencedColumnName = "PK_PAP_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Papeleria fKPAPId;

    public Cursos() {
    }

    public Cursos(Integer pKCURId) {
        this.pKCURId = pKCURId;
    }

    public Cursos(Integer pKCURId, String cURnombre, String cURFechaCreacion, String cURDescripcion, String curImagen) {
        this.pKCURId = pKCURId;
        this.cURnombre = cURnombre;
        this.cURFechaCreacion = cURFechaCreacion;
        this.cURDescripcion = cURDescripcion;
        this.curImagen = curImagen;
    }

    public Integer getPKCURId() {
        return pKCURId;
    }

    public void setPKCURId(Integer pKCURId) {
        this.pKCURId = pKCURId;
    }

    public String getCURnombre() {
        return cURnombre;
    }

    public void setCURnombre(String cURnombre) {
        this.cURnombre = cURnombre;
    }

    public String getCURFechaCreacion() {
        return cURFechaCreacion;
    }

    public void setCURFechaCreacion(String cURFechaCreacion) {
        this.cURFechaCreacion = cURFechaCreacion;
    }

    public String getCURDescripcion() {
        return cURDescripcion;
    }

    public void setCURDescripcion(String cURDescripcion) {
        this.cURDescripcion = cURDescripcion;
    }

    public String getCurImagen() {
        return curImagen;
    }

    public void setCurImagen(String curImagen) {
        this.curImagen = curImagen;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Collection<Usuarios> getUsuariosCollection1() {
        return usuariosCollection1;
    }

    public void setUsuariosCollection1(Collection<Usuarios> usuariosCollection1) {
        this.usuariosCollection1 = usuariosCollection1;
    }

    public Collection<Usuarios> getUsuariosCollection2() {
        return usuariosCollection2;
    }

    public void setUsuariosCollection2(Collection<Usuarios> usuariosCollection2) {
        this.usuariosCollection2 = usuariosCollection2;
    }

    public Multimedia getFKMULId() {
        return fKMULId;
    }

    public void setFKMULId(Multimedia fKMULId) {
        this.fKMULId = fKMULId;
    }

    public Papeleria getFKPAPId() {
        return fKPAPId;
    }

    public void setFKPAPId(Papeleria fKPAPId) {
        this.fKPAPId = fKPAPId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKCURId != null ? pKCURId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.pKCURId == null && other.pKCURId != null) || (this.pKCURId != null && !this.pKCURId.equals(other.pKCURId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Cursos[ pKCURId=" + pKCURId + " ]";
    }
    
}
