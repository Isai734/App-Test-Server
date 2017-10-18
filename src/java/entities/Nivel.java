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
 * @author Isai
 */
@Entity
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n")
    , @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel")
    , @NamedQuery(name = "Nivel.findByNumero", query = "SELECT n FROM Nivel n WHERE n.numero = :numero")
    , @NamedQuery(name = "Nivel.findByDifucultad", query = "SELECT n FROM Nivel n WHERE n.difucultad = :difucultad")})
public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNivel")
    private Integer idNivel;
    @Column(name = "Numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "Difucultad")
    private String difucultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelidNivel")
    private Collection<Palabra> palabraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelidNivel")
    private Collection<MetaNivel> metaNivelCollection;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDifucultad() {
        return difucultad;
    }

    public void setDifucultad(String difucultad) {
        this.difucultad = difucultad;
    }

    @XmlTransient
    public Collection<Palabra> getPalabraCollection() {
        return palabraCollection;
    }

    public void setPalabraCollection(Collection<Palabra> palabraCollection) {
        this.palabraCollection = palabraCollection;
    }

    @XmlTransient
    public Collection<MetaNivel> getMetaNivelCollection() {
        return metaNivelCollection;
    }

    public void setMetaNivelCollection(Collection<MetaNivel> metaNivelCollection) {
        this.metaNivelCollection = metaNivelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Nivel[ idNivel=" + idNivel + " ]";
    }
    
}
