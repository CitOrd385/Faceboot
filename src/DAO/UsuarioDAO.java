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

    @Override
    public ArrayList<Usuario> consultar() {
         MongoCollection coleccion = this.getCollection();
         FindIterable<Usuario> usuarios = coleccion.find();
         ArrayList<Usuario> listaUsuarios = new ArrayList<>();
         for (Usuario listaUsuario : usuarios) {
            listaUsuarios.add(listaUsuario);
        }
        return listaUsuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(){
        MongoCollection<Usuario> coleccion = this.getCollection();
        FindIterable<Usuario> usuarios = coleccion.find();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;   
    }
    
    public Usuario consularporId(ObjectId id) {
        MongoCollection<Usuario> coleccion = this.getCollection();
        Usuario usuario= coleccion.find(eq("_id",id)).first();
        if(usuario != null){
            System.out.println(usuario);
            System.out.println("Si entró uauaua");
            return usuario;
        }else{
            System.out.println("Ponte a llorar, no entró al if JAJAA");
            return null;
        }
    }

    @Override
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
    
    public List<String> mostrarGenerosMusicales(Usuario usuario){
       return usuario.getGenerosMusica();
    }
    
    public List<String> mostrarGenerosPeliculas(Usuario usuario){
        return usuario.getGenerosPeliculas();

    }

   
    
}
