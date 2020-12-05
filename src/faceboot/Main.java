/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceboot;

//import DAO.ComentarioDAO;
import DAO.PublicacionDAO;
import DAO.UsuarioDAO;
import GUI.InicioSesion;

import ObjetosNegocio.Publicacion;
import ObjetosNegocio.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

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
       
       LocalDate fechaNacimiento= LocalDate.of(1998, 07, 16);
       
       
      // coleccion.insertOne(documento);
     
      
        List<String> generosMusica= new ArrayList<>();
        generosMusica.add("baladas");
        generosMusica.add("power metal");
        generosMusica.add("regueton");
        
        List<String> generosPeliculas= new ArrayList<>();
        generosPeliculas.add("Romance");
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
     
       Usuario user2= new Usuario();
       user2.setNombre("Joel");
       user2.setCorreoElectronico("joellokillo@gmail.com");
       user2.setContraseña("joelMoon");
       user2.setSexo("hombre");
       user2.setFechaNacimiento(fechaNacimiento);
       user2.setGenerosMusica(generosMusica);
       user2.setGenerosPeliculas(generosPeliculas);
       
//       
       UsuarioDAO udao= new UsuarioDAO();
       ObjectId idUs= new ObjectId("5fca7146e2c3f0732c995cb8");
      // udao.consularporId(idUs);
       
      // udao.agregar(user2);
//       ArrayList<Usuario> usuarios= udao.consultar();
//       
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario);
//        }
       //udao.agregar(usuario);
//       String correo= usuario.getCorreoElectronico();
//       String contrasenia= usuario.getContraseña();
       
       //udao.consultarCorreo(correo, contrasenia);
       //udao.consultarGenerosMusicales(usuario);
       
       // System.out.println(usuario.getEdad());
       
    //-------------------------------------- Cale de las publicaciones --------------------------------------------------------------------------------  
    LocalDateTime fechaHora= LocalDateTime.now();
    Usuario autor= user2;
    String mensaje= "Que perro frío está haciendo pero no tanto como el de su fría indiferencia";
    
     List<String> etiquetas= new ArrayList<>();
     etiquetas.add("Desamor");
     etiquetas.add("DolidoOn");
    
    Publicacion publicacion = new Publicacion(autor, fechaHora, mensaje, etiquetas);
    
    PublicacionDAO pdao= new PublicacionDAO();
    
    ObjectId id= new ObjectId();
   // pdao.consularporId(id);
   
   //pdao.eliminar(publicacion);
    
    //pdao.agregar(publicacion);
    
    
    
    //---------------------------Cale de los comentarios (Sigue pendiente)-------------------------------------------------------------------------------
   
//    String respuesta="Sin Yolanda, Maricarmen";
//    Comentario comentario= new Comentario();
//    comentario.setId(id);
//    comentario.setFechaHora(fechaHora);
//    comentario.setUsuario(usuario);
//    comentario.setMensaje(respuesta);
//    
//    ComentarioDAO cdao= new ComentarioDAO();
//       cdao.agregar(comentario);
//        System.out.println(comentario);

        InicioSesion iS = new InicioSesion();
        iS.setVisible(true);
    }
    
}
