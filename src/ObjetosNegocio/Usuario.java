/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosNegocio;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;


public class Usuario {
    private ObjectId id;
    private String nombre;
    private String contraseña;
    private String correoElectronico;
    private int edad;
    private String sexo;
    private LocalDate fechaNacimiento;
    private List<String> generosPeliculas;
    private List<String> generosMusica;
    
    
    public Usuario() {
    }

    //constructor que recibe en sus parametros todos los atributos pero no el id de usuario
    public Usuario(String nombre, String correoElentronico, String contraseña, 
            String sexo,LocalDate fechaNacimiento, List<String> generosPeliculas, 
            List<String> generosMusica) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correoElectronico= correoElectronico;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.generosPeliculas = generosPeliculas;
        this.generosMusica = generosMusica;
     
    }

    
//Constructor que recibe todos los atributos del usuario
    public Usuario(ObjectId id, String nombre, String correoElectronico, String contraseña,
            int edad, String sexo, LocalDate fechaNacimiento, List<String> generosPeliculas, 
            List<String> generosMusica) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.generosPeliculas = generosPeliculas;
        this.generosMusica = generosMusica;
       
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
 
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        LocalDate fechaActual= LocalDate.now();
        Period age= Period.between(fechaNacimiento, fechaActual);
        edad= age.getYears();
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrase\u00f1a=" +
                contraseña + ", correoElectronico=" + correoElectronico + 
                ", edad=" + edad + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + 
                ", generosPeliculas=" + generosPeliculas + ", generosMusica=" + generosMusica +'}';
    }
    
    
}
