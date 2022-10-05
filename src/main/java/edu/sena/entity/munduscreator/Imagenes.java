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
@Table(name = "tbl_imagenes")
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_IMG_Id")
    private Integer pKIMGId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "IMG_Ruta_Img")
    private String iMGRutaImg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IMG_Descripcion")
    private String iMGDescripcion;
    @ManyToMany(mappedBy = "imagenesCollection", fetch = FetchType.LAZY)
    private Collection<Multimedia> multimediaCollection;

    public Imagenes() {
    }

    public Imagenes(Integer pKIMGId) {
        this.pKIMGId = pKIMGId;
    }

    public Imagenes(Integer pKIMGId, String iMGRutaImg, String iMGDescripcion) {
        this.pKIMGId = pKIMGId;
        this.iMGRutaImg = iMGRutaImg;
        this.iMGDescripcion = iMGDescripcion;
    }

    public Integer getPKIMGId() {
        return pKIMGId;
    }

    public void setPKIMGId(Integer pKIMGId) {
        this.pKIMGId = pKIMGId;
    }

    public String getIMGRutaImg() {
        return iMGRutaImg;
    }

    public void setIMGRutaImg(String iMGRutaImg) {
        this.iMGRutaImg = iMGRutaImg;
    }

    public String getIMGDescripcion() {
        return iMGDescripcion;
    }

    public void setIMGDescripcion(String iMGDescripcion) {
        this.iMGDescripcion = iMGDescripcion;
    }

    public Collection<Multimedia> getMultimediaCollection() {
        return multimediaCollection;
    }

    public void setMultimediaCollection(Collection<Multimedia> multimediaCollection) {
        this.multimediaCollection = multimediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKIMGId != null ? pKIMGId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.pKIMGId == null && other.pKIMGId != null) || (this.pKIMGId != null && !this.pKIMGId.equals(other.pKIMGId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Imagenes[ pKIMGId=" + pKIMGId + " ]";
    }
    
}
