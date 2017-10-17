/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author isai.castro
 */import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 En este clase hacemos la gestion del los errores del servidor
 */
@XmlRootElement(name = "responseapi")
public class ResponseApi {

    private int estado;
    private String mensaje;

    public ResponseApi() {

    }

    public ResponseApi(int msg, String body) {
        this.estado = msg;
        this.mensaje = body;
    }

    @XmlAttribute
    public int getEstado() {
        return estado;
    }

    @XmlElement
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return "(" + getEstado() + "): " + getMensaje();
    }

}