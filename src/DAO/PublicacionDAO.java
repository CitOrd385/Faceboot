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
public class PublicacionDAO extends BaseDAO<Publicacion>{

    @Override
    protected MongoCollection<Publicacion> getCollection() {
        MongoDatabase baseDatos = this.getDatabase();
        MongoCollection<Publicacion> coleccion = baseDatos.getCollection("publicaciones",Publicacion.class);
        
        //Esto es un comentario de cale, para que salga github
        return coleccion;
    }

    @Override
    public void agregar(Publicacion publicacion) {
        MongoCollection<Publicacion> coleccion = this.getCollection();
        coleccion.insertOne(publicacion);
    }

 
    public Publicacion consularporId(ObjectId id) {
         MongoCollection coleccion = this.getCollection();
        Document filtroId = new Document();
        filtroId.append("_id", id);
        Document publicacion = (Document) coleccion.find(filtroId).first();
        if (publicacion != null) {
            System.out.println(publicacion);
            
        }
        else{
            System.out.println("No se encontro el usuario");
        }
        return  null;
    }

    @Override
    public void eliminar(Publicacion publicacion) {
        MongoCollection coleccion = this.getCollection();
        Document searchDocument = new Document("_id", publicacion.getId());
        coleccion.findOneAndDelete(searchDocument);
    }
    
    public void agregarComentario(Comentario comentario, Publicacion publicacion){
        MongoDatabase baseDatos = this.getDatabase();
        MongoCollection<Publicacion> publicaciones= baseDatos.getCollection("publicaciones",Publicacion.class);
        
        ObjectId idPublicacion = publicacion.getId();
        publicaciones.updateOne(new Document("_id", idPublicacion), Updates.push("comentarios", comentario));
    }
    
    
    public List<Publicacion> buscarPorTag(String tag){
        MongoCollection coleccion= this.getCollection();
        FindIterable<Publicacion> publicaciones= coleccion.find(eq("tags",tag));
        
        List<Publicacion> listaPublicaciones= new ArrayList<>();
        
        for (Publicacion listaPubs : listaPublicaciones) {
         listaPublicaciones.add(listaPubs);
        }
        return listaPublicaciones;
    }
    
    public void eliminarComentario(Publicacion pub, Comentario comentario){
        MongoCollection coleccion= this.getCollection();
        Document filtro= new Document();
        filtro.append("_id", pub.getId());
        Document actualiza= new Document();
        actualiza.append("comentarios",comentario);
        
        coleccion.updateOne(filtro, actualiza);
                
    }
}
