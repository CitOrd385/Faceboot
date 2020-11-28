/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;


import java.util.List;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Citlali Orduño
 */
public class Usuario {
    private ObjectId id;
    private String nombre;
    private String contraseña;
    private int edad;
    private String sexo;
    private Date fechaNacimiento;
    private List<String> generosPeliculas;
    private List<String> generosMusica;
    private List<Publicacion> publicaciones; 
    
    public Usuario() {
    }

    public Usuario(String nombre, String contraseña, int edad, String sexo,
            Date fechaNacimiento, List<String> generosPeliculas,
            List<String> generosMusica, List<Publicacion> publicaciones) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.generosPeliculas = generosPeliculas;
        this.generosMusica = generosMusica;
        this.publicaciones= publicaciones;
    }

    public Usuario(ObjectId id, String nombre, String contraseña, int edad, 
            String sexo, Date fechaNacimiento, List<String> generosPeliculas, 
            List<String> generosMusica, List<Publicacion> publicaciones) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.generosPeliculas = generosPeliculas;
        this.generosMusica = generosMusica;
        this.publicaciones= publicaciones;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<String> getGenerosPeliculas() {
        return generosPeliculas;
    }

    public void setGenerosPeliculas(List<String> generosPeliculas) {
        this.generosPeliculas = generosPeliculas;
    }

    public List<String> getGenerosMusica() {
        return generosMusica;
    }

    public void setGenerosMusica(List<String> generosMusica) {
        this.generosMusica = generosMusica;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
