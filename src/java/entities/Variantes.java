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
 * @author Isai
 */
@Entity
@Table(name = "variantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variantes.findAll", query = "SELECT v FROM Variantes v")
    , @NamedQuery(name = "Variantes.findByIdVariantes", query = "SELECT v FROM Variantes v WHERE v.idVariantes = :idVariantes")
    , @NamedQuery(name = "Variantes.findByNombrevariante", query = "SELECT v FROM Variantes v WHERE v.nombrevariante = :nombrevariante")})
public class Variantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVariantes")
    private Integer idVariantes;
    @Size(max = 45)
    @Column(name = "Nombre_variante")
    private String nombrevariante;
    @JoinColumn(name = "Palabra_idPalabra", referencedColumnName = "idPalabra")
    @ManyToOne(optional = false)
    private Palabra palabraidPalabra;

    public Variantes() {
    }

    public Variantes(Integer idVariantes) {
        this.idVariantes = idVariantes;
    }

    public Integer getIdVariantes() {
        return idVariantes;
    }

    public void setIdVariantes(Integer idVariantes) {
        this.idVariantes = idVariantes;
    }

    public String getNombrevariante() {
        return nombrevariante;
    }

    public void setNombrevariante(String nombrevariante) {
        this.nombrevariante = nombrevariante;
    }

    public Palabra getPalabraidPalabra() {
        return palabraidPalabra;
    }

    public void setPalabraidPalabra(Palabra palabraidPalabra) {
        this.palabraidPalabra = palabraidPalabra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariantes != null ? idVariantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variantes)) {
            return false;
        }
        Variantes other = (Variantes) object;
        if ((this.idVariantes == null && other.idVariantes != null) || (this.idVariantes != null && !this.idVariantes.equals(other.idVariantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Variantes[ idVariantes=" + idVariantes + " ]";
    }
    
}
