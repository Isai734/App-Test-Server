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
    @NamedQuery(name = "Estadistica.findByAcierto", query = "SELECT e FROM Estadistica e WHERE e.acierto = :acierto")})
public class Estadistica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadistica")
    private Integer idEstadistica;
    @Size(max = 45)
    @Column(name = "Nivel")
    private String nivel;
    @Column(name = "Acierto")
    private Integer acierto;
    @JoinColumn(name = "Meta_Nivel_idMeta_Nivel", referencedColumnName = "idMeta_Nivel")
    @ManyToOne(optional = false)
    private MetaNivel metaNivelidMetaNivel;
    @JoinColumn(name = "Meta_palabra_idMeta_palabra", referencedColumnName = "idMeta_palabra")
    @ManyToOne(optional = false)
    private MetaPalabra metapalabraidMetapalabra;
    @JoinColumn(name = "usuario_Email", referencedColumnName = "Email")
    @ManyToOne(optional = false)
    private Usuario usuarioEmail;

    public Estadistica() {
    }

    public Estadistica(Integer idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Integer getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Integer idEstadistica) {
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

    public Usuario getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(Usuario usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadistica != null ? idEstadistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((this.idEstadistica == null && other.idEstadistica != null) || (this.idEstadistica != null && !this.idEstadistica.equals(other.idEstadistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Estadistica[ idEstadistica=" + idEstadistica + " ]";
    }
    
}
