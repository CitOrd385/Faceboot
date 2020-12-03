/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Citlali Orduño
 */
public class UsuarioDAO extends BaseDAO<Usuario> {

    @Override
    protected MongoCollection<Usuario> getCollection() {
        MongoDatabase baseDatos = this.getDatabase();
        MongoCollection<Usuario> coleccion = baseDatos.getCollection("usuarios",Usuario.class);
        return coleccion;
    }

    @Override
    public void agregar(Usuario usuario) {
         MongoCollection<Usuario> coleccion = this.getCollection();
        coleccion.insertOne(usuario);
    }


    public Usuario consularporId(ObjectId id) {
         MongoCollection coleccion = this.getCollection();
        Document filtroId = new Document();
        filtroId.append("_id", id);
        Document usuario = (Document) coleccion.find(filtroId).first();
        if (usuario != null) {
            System.out.println(usuario);
         
        }
        else{
            System.out.println("No se encontro el usuario");
        }
        return  null;
    }

    public void actualizar(Usuario usuario) {
         MongoCollection coleccion = this.getCollection();
 
        Document searchDoc = new Document("_id",usuario.getId());
        Document updateDoc = new Document();
        
        updateDoc.append("nombre", usuario.getNombre());
        updateDoc.append("contraseña", usuario.getContraseña());
        updateDoc.append("edad", usuario.getEdad());
        updateDoc.append("sexo", usuario.getSexo());
        updateDoc.append("fechaNacimiento", usuario.getFechaNacimiento());
        updateDoc.append("generosPeliculas", usuario.getGenerosPeliculas());
        updateDoc.append("generosMusica", usuario.getGenerosMusica());
        updateDoc.append("publicaciones", usuario.getPublicaciones());
        
        Document setDoc = new Document();
        setDoc.append("$set", updateDoc);
        
        coleccion.updateOne(searchDoc, setDoc);
    }

    @Override
    public void eliminar(Usuario usuario) {
        MongoCollection coleccion = this.getCollection();
        Document searchDocument = new Document("_id", usuario.getId());
        coleccion.findOneAndDelete(searchDocument);
    }
    
    public Usuario consultarUsuario(String correoElectronico, String contrasenia){
        Usuario usuario= null;
        MongoCollection coleccion = this.getCollection();
        Document filtroCorreo = new Document(); 
        filtroCorreo.append("correoElectronico", correoElectronico);
        filtroCorreo.append("Contraseña",contrasenia);
        usuario= (Usuario) coleccion.find(filtroCorreo).first();
        
        if(usuario != null){
            System.out.println(usuario);
            return usuario;
        }else{
            System.out.println("No se encontró el usuario");
            return null;
        }
    }
    
    
    public Usuario consultarGenerosMusicales(Usuario usuario){
        MongoCollection coleccion = this.getCollection();
        Document busquedaGenMusical = new Document();
        busquedaGenMusical.append("generosMusicales", usuario.getGenerosMusica());
        Document generosMusicales = (Document) coleccion.find(busquedaGenMusical);
        if(generosMusicales != null){
            System.out.println(usuario);
            return usuario;
        }else{
            System.out.println("Los generos musicales no se encontró");
            return null;
        }
    }
    
    
    public Usuario consultarGenerosPeliculas(Usuario usuario){
        MongoCollection coleccion = this.getCollection();
        Document busquedaGenPelicula = new Document();
        busquedaGenPelicula.append("generosPeliculas",usuario.getGenerosPeliculas());
        Document generosPeliculas= (Document) coleccion.find(busquedaGenPelicula);
        if(generosPeliculas != null){
            System.out.println(usuario);
            Usuario usuarioFind= (Usuario) usuario.getGenerosPeliculas();
            return usuarioFind;
        }else{
            System.out.println("Los generos de peliculas no se encontró");
            return null;
        }
        
    }
}
