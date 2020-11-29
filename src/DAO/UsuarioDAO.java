/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ObjetosNegocio.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

    @Override
    public Usuario consularporId(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Usuario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
