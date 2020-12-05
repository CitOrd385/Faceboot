/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Publicacion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Citlali Orduño
 */
public class PublicacionDAO extends BaseDAO<Publicacion> {

    @Override
    protected MongoCollection<Publicacion> getCollection() {
        MongoDatabase baseDatos = this.getDatabase();
        MongoCollection<Publicacion> coleccion = baseDatos.getCollection("publicaciones", Publicacion.class);

        return coleccion;
    }

    @Override
    public void agregar(Publicacion publicacion) {
        MongoCollection<Publicacion> coleccion = this.getCollection();
        coleccion.insertOne(publicacion);
    }

    @Override
    public ArrayList<Publicacion> consultar() {
        MongoCollection coleccion = this.getCollection();

        FindIterable<Publicacion> publicaciones = coleccion.find();
        ArrayList<Publicacion> listaPublicaciones = new ArrayList<>();

        for (Publicacion listapubs : publicaciones) {
            listaPublicaciones.add(listapubs);
        }
        return listaPublicaciones;
    }

    @Override
    public void eliminar(Publicacion publicacion) {
        MongoCollection coleccion = this.getCollection();
         coleccion.deleteOne(new Document("_id", publicacion.getId()));
    }

    public List<Publicacion> buscarPorTag(String tag) {
        MongoCollection coleccion = this.getCollection();
        FindIterable<Publicacion> publicaciones = coleccion.find(eq("tags", tag));

        List<Publicacion> listaPublicaciones = new ArrayList<>();

        for (Publicacion listaPubs : publicaciones) {
            listaPublicaciones.add(listaPubs);
        }
        return listaPublicaciones;
    }

    //ya esta corregido
    public Publicacion consularporId(ObjectId id) {
        MongoCollection<Publicacion> coleccion = this.getCollection();
        Publicacion publicacion= coleccion.find(eq("_id",id)).first();
        if(publicacion != null){
            System.out.println(publicacion);
            System.out.println("Si entró uauaua");
            return publicacion;
        }else{
            System.out.println("Ponte a llorar, no entró al if JAJAA");
            return null;
        }
    }

    @Override
    public void actualizar(Publicacion publicacion) {
        MongoCollection coleccion = this.getCollection();
        Document searchDoc = new Document("_id",publicacion.getId());
        Document updateDoc = new Document();
        
        updateDoc.append("mensaje",publicacion.getMensaje());
        updateDoc.append("comentarios", publicacion.getComentarios());
        
        Document setDoc = new Document();
        setDoc.append("$set", updateDoc);
        
        coleccion.updateOne(searchDoc, setDoc);
    }
    
   public void agregarComentario(Publicacion publicacion, Comentario comentario){
        MongoCollection<Publicacion> coleccion = this.getCollection();
        
        ObjectId idPub= publicacion.getId();
        Document searchDoc= new Document("_id", idPub);
        
        coleccion.updateOne(searchDoc, Updates.push("comentarios", comentario));
   }
   
   public void eliminarComentario(Publicacion publicacion, Comentario comentario){
        MongoCollection<Publicacion> coleccion = this.getCollection();
        
        Document searchDoc= new Document("_id", publicacion.getId());
        Document comentDoc= new Document("comentarios", comentario);
        Document updateDoc = new Document("$pull", comentDoc);
        
        coleccion.updateOne(searchDoc, updateDoc);
   }
   
   
   public List<Comentario> consultarComentario(Publicacion publicacion){
       return publicacion.getComentarios();
   }
    
}
