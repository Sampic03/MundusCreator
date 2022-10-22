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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author sr992
 */
@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PK_USU_Id")
    private Integer pKUSUId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_Tipodedato")
    private String uSUTipodedato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_Nombre")
    private String uSUNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_Apellido")
    private String uSUApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_FechaNac")
    private String uSUFechaNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_Genero")
    private String uSUGenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_Correo")
    private String uSUCorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_NomUsu")
    private String uSUNomUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_Contrasenha")
    private String uSUContrasenha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_Estado")
    private short uSUEstado;
    @Size(max = 21000)
    @Column(name = "USU_Foto")
    private String uSUFoto;
    @JoinTable(name = "tbl_usuario_rol", joinColumns = {
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_ROL_Id", referencedColumnName = "PK_ROL_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;
    @JoinTable(name = "tbl_cursos_usuarios", joinColumns = {
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id"),
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection;
    @JoinTable(name = "tbl_notas", joinColumns = {
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id"),
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection1;
    @JoinTable(name = "tbl_certificados", joinColumns = {
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id"),
        @JoinColumn(name = "FK_USU_Id", referencedColumnName = "PK_USU_Id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id"),
        @JoinColumn(name = "FK_CUR_Id", referencedColumnName = "PK_CUR_Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Cursos> cursosCollection2;

    public Usuarios() {
    }

    public Usuarios(Integer pKUSUId) {
        this.pKUSUId = pKUSUId;
    }

    public Usuarios(Integer pKUSUId, String uSUTipodedato, String uSUNombre, String uSUApellido, String uSUFechaNac, String uSUGenero, String uSUCorreo, String uSUNomUsu, String uSUContrasenha, short uSUEstado) {
        this.pKUSUId = pKUSUId;
        this.uSUTipodedato = uSUTipodedato;
        this.uSUNombre = uSUNombre;
        this.uSUApellido = uSUApellido;
        this.uSUFechaNac = uSUFechaNac;
        this.uSUGenero = uSUGenero;
        this.uSUCorreo = uSUCorreo;
        this.uSUNomUsu = uSUNomUsu;
        this.uSUContrasenha = uSUContrasenha;
        this.uSUEstado = uSUEstado;
    }

    public Integer getPKUSUId() {
        return pKUSUId;
    }

    public void setPKUSUId(Integer pKUSUId) {
        this.pKUSUId = pKUSUId;
    }

    public String getUSUTipodedato() {
        return uSUTipodedato;
    }

    public void setUSUTipodedato(String uSUTipodedato) {
        this.uSUTipodedato = uSUTipodedato;
    }

    public String getUSUNombre() {
        return uSUNombre;
    }

    public void setUSUNombre(String uSUNombre) {
        this.uSUNombre = uSUNombre;
    }

    public String getUSUApellido() {
        return uSUApellido;
    }

    public void setUSUApellido(String uSUApellido) {
        this.uSUApellido = uSUApellido;
    }

    public String getUSUFechaNac() {
        return uSUFechaNac;
    }

    public void setUSUFechaNac(String uSUFechaNac) {
        this.uSUFechaNac = uSUFechaNac;
    }

    public String getUSUGenero() {
        return uSUGenero;
    }

    public void setUSUGenero(String uSUGenero) {
        this.uSUGenero = uSUGenero;
    }

    public String getUSUCorreo() {
        return uSUCorreo;
    }

    public void setUSUCorreo(String uSUCorreo) {
        this.uSUCorreo = uSUCorreo;
    }

    public String getUSUNomUsu() {
        return uSUNomUsu;
    }

    public void setUSUNomUsu(String uSUNomUsu) {
        this.uSUNomUsu = uSUNomUsu;
    }

    public String getUSUContrasenha() {
        return uSUContrasenha;
    }

    public void setUSUContrasenha(String uSUContrasenha) {
        this.uSUContrasenha = uSUContrasenha;
    }

    public short getUSUEstado() {
        return uSUEstado;
    }

    public void setUSUEstado(short uSUEstado) {
        this.uSUEstado = uSUEstado;
    }

    public String getUSUFoto() {
        return uSUFoto;
    }

    public void setUSUFoto(String uSUFoto) {
        this.uSUFoto = uSUFoto;
    }

    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    public Collection<Cursos> getCursosCollection1() {
        return cursosCollection1;
    }

    public void setCursosCollection1(Collection<Cursos> cursosCollection1) {
        this.cursosCollection1 = cursosCollection1;
    }

    public Collection<Cursos> getCursosCollection2() {
        return cursosCollection2;
    }

    public void setCursosCollection2(Collection<Cursos> cursosCollection2) {
        this.cursosCollection2 = cursosCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pKUSUId != null ? pKUSUId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.pKUSUId == null && other.pKUSUId != null) || (this.pKUSUId != null && !this.pKUSUId.equals(other.pKUSUId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.munduscreator.Usuarios[ pKUSUId=" + pKUSUId + " ]";
    }
    
}
