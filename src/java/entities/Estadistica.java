/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isai.castro
 */
@Entity
@Table(name = "estadistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadistica.findAll", query = "SELECT e FROM Estadistica e"),
    @NamedQuery(name = "Estadistica.findByIdEstadistica", query = "SELECT e FROM Estadistica e WHERE e.idEstadistica = :idEstadistica"),
    @NamedQuery(name = "Estadistica.findByNivel", query = "SELECT e FROM Estadistica e WHERE e.nivel = :nivel"),
    @NamedQuery(name = "Estadistica.findByAcierto", query = "SELECT e FROM Estadistica e WHERE e.acierto = :acierto"),
    @NamedQuery(name = "Estadistica.findByUsuarioidUsuario", query = "SELECT e FROM Estadistica e WHERE e.usuarioidUsuario = :usuarioidUsuario")})
public class Estadistica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadistica")
    private int idEstadistica;
    @Size(max = 45)
    @Column(name = "Nivel")
    private String nivel;
    @Column(name = "Acierto")
    private Integer acierto;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_idUsuario")
    private Integer usuarioidUsuario;
    @JoinColumn(name = "Meta_Nivel_idMeta_Nivel", referencedColumnName = "idMeta_Nivel")
    @ManyToOne(optional = false)
    private MetaNivel metaNivelidMetaNivel;
    @JoinColumn(name = "Meta_palabra_idMeta_palabra", referencedColumnName = "idMeta_palabra")
    @ManyToOne(optional = false)
    private MetaPalabra metapalabraidMetapalabra;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Estadistica() {
    }

    public Estadistica(Integer usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Estadistica(Integer usuarioidUsuario, int idEstadistica) {
        this.usuarioidUsuario = usuarioidUsuario;
        this.idEstadistica = idEstadistica;
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getAcierto() {
        return acierto;
    }

    public void setAcierto(Integer acierto) {
        this.acierto = acierto;
    }

    public Integer getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Integer usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public MetaNivel getMetaNivelidMetaNivel() {
        return metaNivelidMetaNivel;
    }

    public void setMetaNivelidMetaNivel(MetaNivel metaNivelidMetaNivel) {
        this.metaNivelidMetaNivel = metaNivelidMetaNivel;
    }

    public MetaPalabra getMetapalabraidMetapalabra() {
        return metapalabraidMetapalabra;
    }

    public void setMetapalabraidMetapalabra(MetaPalabra metapalabraidMetapalabra) {
        this.metapalabraidMetapalabra = metapalabraidMetapalabra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioidUsuario != null ? usuarioidUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((this.usuarioidUsuario == null && other.usuarioidUsuario != null) || (this.usuarioidUsuario != null && !this.usuarioidUsuario.equals(other.usuarioidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadistica[ usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
}
