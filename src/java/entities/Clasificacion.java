/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author isai.castro
 */
@Entity
@Table(name = "clasificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c"),
    @NamedQuery(name = "Clasificacion.findByIdClasificacion", query = "SELECT c FROM Clasificacion c WHERE c.idClasificacion = :idClasificacion"),
    @NamedQuery(name = "Clasificacion.findByTipo", query = "SELECT c FROM Clasificacion c WHERE c.tipo = :tipo")})
public class Clasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClasificacion")
    private Integer idClasificacion;
    @Size(max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasificacionidClasificacion")
    private Collection<Palabra> palabraCollection;

    public Clasificacion() {
    }

    public Clasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Palabra> getPalabraCollection() {
        return palabraCollection;
    }

    public void setPalabraCollection(Collection<Palabra> palabraCollection) {
        this.palabraCollection = palabraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasificacion != null ? idClasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idClasificacion == null && other.idClasificacion != null) || (this.idClasificacion != null && !this.idClasificacion.equals(other.idClasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clasificacion[ idClasificacion=" + idClasificacion + " ]";
    }
    
}
