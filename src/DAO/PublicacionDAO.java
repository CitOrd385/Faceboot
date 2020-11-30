/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Comentario;
import ObjetosNegocio.Publicacion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
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
        return coleccion;
    }

    @Override
    public void agregar(Publicacion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
}
