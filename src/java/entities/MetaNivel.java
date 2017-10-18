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
 * @author Isai
 */
@Entity
@Table(name = "meta_nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetaNivel.findAll", query = "SELECT m FROM MetaNivel m")
    , @NamedQuery(name = "MetaNivel.findByIdMetaNivel", query = "SELECT m FROM MetaNivel m WHERE m.idMetaNivel = :idMetaNivel")
    , @NamedQuery(name = "MetaNivel.findByCantidad", query = "SELECT m FROM MetaNivel m WHERE m.cantidad = :cantidad")})
public class MetaNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMeta_Nivel")
    private Integer idMetaNivel;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metaNivelidMetaNivel")
    private Collection<Estadistica> estadisticaCollection;
    @JoinColumn(name = "Nivel_idNivel", referencedColumnName = "idNivel")
    @ManyToOne(optional = false)
    private Nivel nivelidNivel;

    public MetaNivel() {
    }

    public MetaNivel(Integer idMetaNivel) {
        this.idMetaNivel = idMetaNivel;
    }

    public Integer getIdMetaNivel() {
        return idMetaNivel;
    }

    public void setIdMetaNivel(Integer idMetaNivel) {
        this.idMetaNivel = idMetaNivel;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<Estadistica> getEstadisticaCollection() {
        return estadisticaCollection;
    }

    public void setEstadisticaCollection(Collection<Estadistica> estadisticaCollection) {
        this.estadisticaCollection = estadisticaCollection;
    }

    public Nivel getNivelidNivel() {
        return nivelidNivel;
    }

    public void setNivelidNivel(Nivel nivelidNivel) {
        this.nivelidNivel = nivelidNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetaNivel != null ? idMetaNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetaNivel)) {
            return false;
        }
        MetaNivel other = (MetaNivel) object;
        if ((this.idMetaNivel == null && other.idMetaNivel != null) || (this.idMetaNivel != null && !this.idMetaNivel.equals(other.idMetaNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MetaNivel[ idMetaNivel=" + idMetaNivel + " ]";
    }
    
}
