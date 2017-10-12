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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author isai.castro
 */
@Entity
@Table(name = "meta_palabra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetaPalabra.findAll", query = "SELECT m FROM MetaPalabra m"),
    @NamedQuery(name = "MetaPalabra.findByIdMetapalabra", query = "SELECT m FROM MetaPalabra m WHERE m.idMetapalabra = :idMetapalabra"),
    @NamedQuery(name = "MetaPalabra.findByCantidad", query = "SELECT m FROM MetaPalabra m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MetaPalabra.findByTiempo", query = "SELECT m FROM MetaPalabra m WHERE m.tiempo = :tiempo")})
public class MetaPalabra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMeta_palabra")
    private Integer idMetapalabra;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Tiempo")
    private Integer tiempo;
    @JoinColumn(name = "Palabra_idPalabra", referencedColumnName = "idPalabra")
    @ManyToOne(optional = false)
    private Palabra palabraidPalabra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metapalabraidMetapalabra")
    private Collection<Estadistica> estadisticaCollection;

    public MetaPalabra() {
    }

    public MetaPalabra(Integer idMetapalabra) {
        this.idMetapalabra = idMetapalabra;
    }

    public Integer getIdMetapalabra() {
        return idMetapalabra;
    }

    public void setIdMetapalabra(Integer idMetapalabra) {
        this.idMetapalabra = idMetapalabra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Palabra getPalabraidPalabra() {
        return palabraidPalabra;
    }

    public void setPalabraidPalabra(Palabra palabraidPalabra) {
        this.palabraidPalabra = palabraidPalabra;
    }

    @XmlTransient
    public Collection<Estadistica> getEstadisticaCollection() {
        return estadisticaCollection;
    }

    public void setEstadisticaCollection(Collection<Estadistica> estadisticaCollection) {
        this.estadisticaCollection = estadisticaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetapalabra != null ? idMetapalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaPalabra)) {
            return false;
        }
        MetaPalabra other = (MetaPalabra) object;
        if ((this.idMetapalabra == null && other.idMetapalabra != null) || (this.idMetapalabra != null && !this.idMetapalabra.equals(other.idMetapalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MetaPalabra[ idMetapalabra=" + idMetapalabra + " ]";
    }
    
}
