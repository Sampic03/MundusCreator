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
@Table(name = "tbl_roles")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_ROL_Id")
    private Integer pKROLId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROL_Nombre")
    private String rOLNombre;
    @ManyToMany(mappedBy = "rolesCollection", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fKROLId", fetch = FetchType.LAZY)
    private Collection<Mensajes> mensajesCollection;

    public Roles() {
    }

    public Roles(Integer pKROLId) {
        this.pKROLId = pKROLId;
    }

    public Roles(Integer pKROLId, String rOLNombre) {
        this.pKROLId = pKROLId;
        this.rOLNombre = rOLNombre;
    }

    public Integer getPKROLId() {
        return pKROLId;
    }

    public void setPKROLId(Integer pKROLId) {
        this.pKROLId = pKROLId;
    }

    public String getROLNombre() {
        return rOLNombre;
    }

    public void setROLNombre(String rOLNombre) {
        this.rOLNombre = rOLNombre;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
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
        hash += (pKROLId != null ? pKROLId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.pKROLId == null && other.pKROLId != null) || (this.pKROLId != null && !this.pKROLId.equals(other.pKROLId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Roles[ pKROLId=" + pKROLId + " ]";
    }
    
}
