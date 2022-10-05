/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.munduscreator;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sr992
 */
@Entity
@Table(name = "tbl_multimedia")
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m")})
public class Multimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_MUL_Id")
    private Integer pKMULId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MUL_Descripcion")
    private String mULDescripcion;
    @JoinTable(name = "tbl_multimedia_video", joinColumns = {
        @JoinColumn(name = "FK_MUL_Id", referencedColumnName = "PK_MUL_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_VID_Id", referencedColumnName = "PK_VID_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Videos> videosCollection;
    @JoinTable(name = "tbl_multimedia_imagen", joinColumns = {
        @JoinColumn(name = "FK_MUL_Id", referencedColumnName = "PK_MUL_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_IMG_Id", referencedColumnName = "PK_IMG_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Imagenes> imagenesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKMULId", fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection;

    public Multimedia() {
    }

    public Multimedia(Integer pKMULId) {
        this.pKMULId = pKMULId;
    }

    public Multimedia(Integer pKMULId, String mULDescripcion) {
        this.pKMULId = pKMULId;
        this.mULDescripcion = mULDescripcion;
    }

    public Integer getPKMULId() {
        return pKMULId;
    }

    public void setPKMULId(Integer pKMULId) {
        this.pKMULId = pKMULId;
    }

    public String getMULDescripcion() {
        return mULDescripcion;
    }

    public void setMULDescripcion(String mULDescripcion) {
        this.mULDescripcion = mULDescripcion;
    }

    public Collection<Videos> getVideosCollection() {
        return videosCollection;
    }

    public void setVideosCollection(Collection<Videos> videosCollection) {
        this.videosCollection = videosCollection;
    }

    public Collection<Imagenes> getImagenesCollection() {
        return imagenesCollection;
    }

    public void setImagenesCollection(Collection<Imagenes> imagenesCollection) {
        this.imagenesCollection = imagenesCollection;
    }

    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKMULId != null ? pKMULId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.pKMULId == null && other.pKMULId != null) || (this.pKMULId != null && !this.pKMULId.equals(other.pKMULId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Multimedia[ pKMULId=" + pKMULId + " ]";
    }
    
}
