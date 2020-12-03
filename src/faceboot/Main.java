/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceboot;

import ObjetosNegocio.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
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
       
       Usuario usuario= new Usuario("Tiffany","tiffa_rosie@gmail.com", "rosiefabuloli", "mujer", fechaNacimiento);
       
       // System.out.println(usuario.getEdad());
       
       
       
    }
    
}
