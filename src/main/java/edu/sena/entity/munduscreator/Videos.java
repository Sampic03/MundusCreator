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
@Table(name = "tbl_videos")
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v")})
public class Videos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_VID_Id")
    private Integer pKVIDId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21000)
    @Column(name = "VID_Ruta_Video")
    private String vIDRutaVideo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "VID_Descripcion")
    private String vIDDescripcion;
    @ManyToMany(mappedBy = "videosCollection", fetch = FetchType.LAZY)
    private Collection<Multimedia> multimediaCollection;

    public Videos() {
    }

    public Videos(Integer pKVIDId) {
        this.pKVIDId = pKVIDId;
    }

    public Videos(Integer pKVIDId, String vIDRutaVideo, String vIDDescripcion) {
        this.pKVIDId = pKVIDId;
        this.vIDRutaVideo = vIDRutaVideo;
        this.vIDDescripcion = vIDDescripcion;
    }

    public Integer getPKVIDId() {
        return pKVIDId;
    }

    public void setPKVIDId(Integer pKVIDId) {
        this.pKVIDId = pKVIDId;
    }

    public String getVIDRutaVideo() {
        return vIDRutaVideo;
    }

    public void setVIDRutaVideo(String vIDRutaVideo) {
        this.vIDRutaVideo = vIDRutaVideo;
    }

    public String getVIDDescripcion() {
        return vIDDescripcion;
    }

    public void setVIDDescripcion(String vIDDescripcion) {
        this.vIDDescripcion = vIDDescripcion;
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
        hash += (pKVIDId != null ? pKVIDId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        if ((this.pKVIDId == null && other.pKVIDId != null) || (this.pKVIDId != null && !this.pKVIDId.equals(other.pKVIDId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Videos[ pKVIDId=" + pKVIDId + " ]";
    }
    
}
