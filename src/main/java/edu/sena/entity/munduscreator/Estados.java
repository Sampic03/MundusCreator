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
@Table(name = "tbl_estados")
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_EST_Id")
    private Integer pKESTId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EST_descripcion")
    private String eSTdescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKESTId", fetch = FetchType.LAZY)
    private Collection<Mensajes> mensajesCollection;

    public Estados() {
    }

    public Estados(Integer pKESTId) {
        this.pKESTId = pKESTId;
    }

    public Estados(Integer pKESTId, String eSTdescripcion) {
        this.pKESTId = pKESTId;
        this.eSTdescripcion = eSTdescripcion;
    }

    public Integer getPKESTId() {
        return pKESTId;
    }

    public void setPKESTId(Integer pKESTId) {
        this.pKESTId = pKESTId;
    }

    public String getESTdescripcion() {
        return eSTdescripcion;
    }

    public void setESTdescripcion(String eSTdescripcion) {
        this.eSTdescripcion = eSTdescripcion;
    }

    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKESTId != null ? pKESTId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.pKESTId == null && other.pKESTId != null) || (this.pKESTId != null && !this.pKESTId.equals(other.pKESTId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Estados[ pKESTId=" + pKESTId + " ]";
    }
    
}
