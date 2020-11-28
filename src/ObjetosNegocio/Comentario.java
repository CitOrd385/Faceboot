/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;


public class Comentario {
    private ObjectId id;
    private Usuario usuario;
    private Date fechaHora;
    private String mensaje;

    public Comentario() {
    }

    public Comentario(Usuario usuario, Date fechaHora, String mensaje) {
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    public Comentario(ObjectId id, Usuario usuario, Date fechaHora, String mensaje) {
        this.id = id;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
