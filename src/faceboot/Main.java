/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceboot;

import DAO.UsuarioDAO;
import ObjetosNegocio.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Citlali Orduño
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        //Cliente mongo - persistence manager factory 
       MongoClient clienteMongo = new MongoClient("localhost",27017);
       
       //Acceso a la base de datos 
       MongoDatabase bd = clienteMongo.getDatabase("Faceboot");
       
       //Acceso a la colección que se desee modificar
       MongoCollection<Document> coleccion = bd.getCollection("usuarios");
       
       LocalDate fechaNacimiento= LocalDate.of(1999, 02, 02);
       Document documento= new Document();
       documento.append("nombre","el joel lokillo").
                 append("contraseña","lokillojoel").
                 append("sexo", "hombre").
               append("fechaNacimiento",fechaNacimiento);
       
      // coleccion.insertOne(documento);
     
      
        List<String> generosMusica= new ArrayList<>();
        generosMusica.add("Trash metal");
        generosMusica.add("Heavy metal");
        generosMusica.add("Rock psicodelico");
        
        List<String> generosPeliculas= new ArrayList<>();
        generosPeliculas.add("Terror");
        generosPeliculas.add("Misterio");
        generosPeliculas.add("Accion");
        
       Usuario usuario= new Usuario();
       usuario.setNombre("Marisol");
       usuario.setCorreoElectronico("mari_solecito23@gmail.com");
       usuario.setContraseña("solecito15");
       usuario.setSexo("mujer");
       usuario.setFechaNacimiento(fechaNacimiento);
       usuario.setGenerosMusica(generosMusica);
       usuario.setGenerosPeliculas(generosPeliculas);
     
       
       UsuarioDAO udao= new UsuarioDAO();
       
       
       //udao.agregar(usuario);
       
       List<String> generosMusicales= udao.consultarGenerosPeliculas(usuario);
       
        for (String generosMusic : generosMusicales) {
            System.out.println(generosMusic);
        }
       //udao.consultarGenerosMusicales(usuario);
       
       // System.out.println(usuario.getEdad());
       
       
       
    }
    
}
