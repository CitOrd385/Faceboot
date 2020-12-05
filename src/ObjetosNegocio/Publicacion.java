/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Citlali Orduño
 */
public class Publicacion {
    private ObjectId id;
    private Usuario autor;
    private LocalDateTime fechaHora;
    private String mensaje;
    private List<String> etiquetas;
    private List<Comentario> comentarios;

    public Publicacion() {
    }

    public Publicacion(Usuario autor, LocalDateTime fechaHora, String mensaje, List<String> etiquetas) {
        this.autor = autor;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
    }

    public Publicacion(Usuario usuario, LocalDateTime fechaHora, String mensaje, List<String> etiquetas, List<Comentario> comentarios) {
        this.autor = usuario;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.comentarios = comentarios;
    }

    public Publicacion(ObjectId id, Usuario usuario, LocalDateTime fechaHora, String mensaje, List<String> etiquetas, List<Comentario> comentarios) {
        this.id = id;
        this.autor = usuario;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.comentarios = comentarios;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Publicacion{" +" autor: n/" + autor.getNombre() + ", fechaHora: n/" + fechaHora 
                + ", mensaje: n/" + mensaje + ", etiquetas: n/" + etiquetas + ", comentarios: n/" + comentarios + '}';
    }

    
  
    
    
}
