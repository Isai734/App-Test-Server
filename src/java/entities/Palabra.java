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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "palabra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palabra.findAll", query = "SELECT p FROM Palabra p"),
    @NamedQuery(name = "Palabra.findByIdPalabra", query = "SELECT p FROM Palabra p WHERE p.idPalabra = :idPalabra"),
    @NamedQuery(name = "Palabra.findByPalabraespaniol", query = "SELECT p FROM Palabra p WHERE p.palabraespaniol = :palabraespaniol"),
    @NamedQuery(name = "Palabra.findByPalabratlapaneco", query = "SELECT p FROM Palabra p WHERE p.palabratlapaneco = :palabratlapaneco")})
public class Palabra implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Sonido")
    private byte[] sonido;
    @Size(max = 45)
    @Column(name = "Image_name")
    private String imagename;
    @Size(max = 45)
    @Column(name = "Sound_name")
    private String soundname;
    @JoinColumn(name = "usuario_Email", referencedColumnName = "Email")
    @ManyToOne(optional = false)
    private Usuario usuarioEmail;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPalabra")
    private Integer idPalabra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Palabra_espaniol")
    private String palabraespaniol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Palabra_tlapaneco")
    private String palabratlapaneco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "palabraidPalabra")
    private Collection<MetaPalabra> metaPalabraCollection;
    @JoinColumn(name = "Clasificacion_idClasificacion", referencedColumnName = "idClasificacion")
    @ManyToOne(optional = false)
    private Clasificacion clasificacionidClasificacion;
    @JoinColumn(name = "Nivel_idNivel", referencedColumnName = "idNivel")
    @ManyToOne(optional = false)
    private Nivel nivelidNivel;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "palabraidPalabra")
    private Collection<Variantes> variantesCollection;

    public Palabra() {
    }

    public Palabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public Palabra(Integer idPalabra, String palabraespaniol, String palabratlapaneco, byte[] imagen, byte[] sonido) {
        this.idPalabra = idPalabra;
        this.palabraespaniol = palabraespaniol;
        this.palabratlapaneco = palabratlapaneco;
        this.imagen = imagen;
        this.sonido = sonido;
    }

    public Integer getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabraespaniol() {
        return palabraespaniol;
    }

    public void setPalabraespaniol(String palabraespaniol) {
        this.palabraespaniol = palabraespaniol;
    }

    public String getPalabratlapaneco() {
        return palabratlapaneco;
    }

    public void setPalabratlapaneco(String palabratlapaneco) {
        this.palabratlapaneco = palabratlapaneco;
    }


    @XmlTransient
    public Collection<MetaPalabra> getMetaPalabraCollection() {
        return metaPalabraCollection;
    }

    public void setMetaPalabraCollection(Collection<MetaPalabra> metaPalabraCollection) {
        this.metaPalabraCollection = metaPalabraCollection;
    }

    public Clasificacion getClasificacionidClasificacion() {
        return clasificacionidClasificacion;
    }

    public void setClasificacionidClasificacion(Clasificacion clasificacionidClasificacion) {
        this.clasificacionidClasificacion = clasificacionidClasificacion;
    }

    public Nivel getNivelidNivel() {
        return nivelidNivel;
    }

    public void setNivelidNivel(Nivel nivelidNivel) {
        this.nivelidNivel = nivelidNivel;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @XmlTransient
    public Collection<Variantes> getVariantesCollection() {
        return variantesCollection;
    }

    public void setVariantesCollection(Collection<Variantes> variantesCollection) {
        this.variantesCollection = variantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalabra != null ? idPalabra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palabra)) {
            return false;
        }
        Palabra other = (Palabra) object;
        if ((this.idPalabra == null && other.idPalabra != null) || (this.idPalabra != null && !this.idPalabra.equals(other.idPalabra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Palabra[ idPalabra=" + idPalabra + " ]";
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getSonido() {
        return sonido;
    }

    public void setSonido(byte[] sonido) {
        this.sonido = sonido;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getSoundname() {
        return soundname;
    }

    public void setSoundname(String soundname) {
        this.soundname = soundname;
    }

    public Usuario getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(Usuario usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }
    
}
