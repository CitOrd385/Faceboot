/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Usuario;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
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
        MongoCollection<Usuario> coleccion = this.getCollection();
        Document filtroId = new Document();
        filtroId.append("_id", id);

        Usuario usuario= coleccion.find(eq("_id", filtroId)).first();
        if (usuario != null) {
            System.out.println(usuario);
         return usuario;
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
    
    public Usuario consultarCorreo(Usuario usuario){
        MongoCollection<Usuario> coleccion = this.getCollection();
        Document filtroCorreo = new Document(); 
        filtroCorreo.append("correoElectronico", usuario.getCorreoElectronico());
        FindIterable<Usuario> usuarios= coleccion.find(filtroCorreo);
       if(usuarios != null){
           for (Usuario documento : usuarios) {
               System.out.println(documento);
           }
           return usuario;
       }else{
           System.out.println("Pura madre se agregó");
           return null;
       }
    }
    
    public List<String> consultarGenerosMusicales(Usuario usuario){
        MongoCollection coleccion = this.getCollection();
       return usuario.getGenerosMusica();
    }
    
    public List<String> consultarGenerosPeliculas(Usuario usuario){
        MongoCollection coleccion = this.getCollection();
        return usuario.getGenerosPeliculas();

    }
}
