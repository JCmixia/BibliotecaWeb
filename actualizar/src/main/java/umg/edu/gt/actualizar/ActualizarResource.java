/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package umg.edu.gt.actualizar;

import javax.persistence.PersistenceException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.core.MediaType;
import umg.edu.gt.Datos.Estudiante;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import umg.edu.gt.Datos.Autor;
import umg.edu.gt.Datos.Categoria;
import umg.edu.gt.Datos.Libros;
import umg.edu.gt.Datos.Tipos_Usuario;
import umg.edu.gt.Datos.Transacciones;
import umg.edu.gt.Datos.Usuarios;


/**
 * REST Web Service
 *
 * @author ADMIN
 */
@Path("actualizar")
public class ActualizarResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ActualizarResource
     */
    public ActualizarResource() {
    }

    /**
     * Retrieves representation of an instance of umg.edu.gt.actualizar.ActualizarResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Path("primerWS")
    @Produces({"text/plain"})
    @Consumes({"text/plain"})
    public String primerWS() {
        //TODO return proper representation object
        return "Mi primer API WS";
    }
    
    @PUT
    @Path("actualizarEstudiante")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    
    public String actualizarEstudiante(Estudiante estudiante){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
       try {
            transaction = session.beginTransaction();
            Estudiante estudiantee = session.get(Estudiante.class, estudiante.getId_estudiante());
            
           if(estudiante.getDireccion()!=null && !estudiante.getDireccion().isEmpty()){
            estudiantee.setDireccion(estudiante.getDireccion());
           }else{
               estudiantee.setDireccion(estudiantee.getDireccion());
           }
           
           if(estudiante.getEstado() !=null && !estudiante.getEstado().isEmpty()){
            estudiantee.setEstado(estudiante.getEstado());
           }else{
               estudiantee.setEstado(estudiantee.getEstado());
           }
           
           if(estudiante.getMunicipio() !=0){
            estudiantee.setMunicipio(estudiante.getMunicipio());
           }else{
               estudiantee.setMunicipio(estudiantee.getMunicipio());
           }
            
            if (estudiante.getNombre_estudiante() !=null && !estudiante.getNombre_estudiante().isEmpty()) {
                estudiantee.setNombre_estudiante(estudiante.getNombre_estudiante());
                
            } else {
                estudiantee.setNombre_estudiante(estudiantee.getNombre_estudiante());
                
            }
            
            if(estudiante.getTelefono() != null && !estudiante.getTelefono().isEmpty()){
            estudiantee.setTelefono(estudiante.getTelefono());
            }else{
                estudiantee.setTelefono(estudiantee.getTelefono());
            }
            
            
            if(estudiante.getCorreo() != null && !estudiante.getCorreo().isEmpty()){
            estudiantee.setCorreo(estudiante.getCorreo());
            }else{
                estudiantee.setCorreo(estudiantee.getCorreo());
            }
            
            session.update(estudiantee);
            transaction.commit();
            return "Estudiante Actualizado";
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar";
        }
       finally{
           session.close();
       }

    }
    
    
    @PUT
    @Path("actualizarAutor")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    
    public String actualizarAutor (Autor autor){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Autor.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
       
        
       try {
            transaction = session.beginTransaction();
            Autor autoree = session.get(Autor.class, autor.getId_autor());
            
           if(autor.getNombre_autor()!=null && !autor.getNombre_autor().isEmpty()){
             autoree.setNombre_autor(autor.getNombre_autor());
           }else{
               autoree.setNombre_autor(autoree.getNombre_autor());
           }
           
            
            session.update(autoree);
            transaction.commit();
            return "Autor Actualizado";
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Autor";
        }
       finally{
           session.close();
       }
        
    }
    
    @PUT
    @Path("actualizarCategoria")
    @Consumes("application/json")
    @Produces({"application/json"})
    
   public String actualizarCategoria (Categoria categoria){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Categoria.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
       
        
       try {
            transaction = session.beginTransaction();
            Categoria categoriaa = session.get(Categoria.class, categoria.getId_categoria());
            
           if(categoria.getDescripcion() !=null && !categoria.getDescripcion().isEmpty()){
             categoriaa.setDescripcion(categoria.getDescripcion());
           }else{
               categoriaa.setDescripcion(categoriaa.getDescripcion());
             
           }
           
            
            session.update(categoriaa);
            transaction.commit();
            return "Categoria Actualizada";
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Autor";
        }
       finally{
           session.close();
       }
        
   }
  
    @PUT
    @Path("actualizarLibros")
    @Consumes("application/json")
    @Produces({"application/json"})
    
    
   public String actualizarLibros (Libros libro){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libros.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
       
        
       try {
            transaction = session.beginTransaction();
            Libros libroo = session.get(Libros.class, libro.getId_libro());
            
           if(libro.getTitulo() !=null && !libro.getTitulo().isEmpty()){
             libroo.setTitulo(libro.getTitulo());    
           }else{
               libroo.setTitulo(libroo.getTitulo());
           }
           
            if(libro.getCategoria() !=null && !libro.getCategoria().isEmpty()){
             libroo.setCategoria(libro.getCategoria());    
           }else{
               libroo.setCategoria(libroo.getCategoria());
           }
           
            if(libro.getId_autor() !=0){
             libroo.setId_autor(libro.getId_autor());    
           }else{
               libroo.setId_autor(libroo.getId_autor());
           }
            
            if(libro.getEdicion() !=null && !libro.getEdicion().isEmpty()){
             libroo.setEdicion(libro.getEdicion());    
           }else{
               libroo.setEdicion(libroo.getEdicion());
           } 
           
            if(libro.getFecha_edicion() !=null ){
             libroo.setFecha_edicion(libro.getFecha_edicion());    
           }else{
               libroo.setFecha_edicion(libroo.getFecha_edicion());
           } 
           
           if(libro.getFecha_ingreso() !=null ){
             libroo.setFecha_ingreso(libro.getFecha_ingreso());    
           }else{
               libroo.setFecha_ingreso(libroo.getFecha_ingreso());
           }
           
           if(libro.getEstado() !=null && !libro.getEstado().isEmpty() ){
             libroo.setEstado(libro.getEstado());    
           }else{
               libroo.setEstado(libroo.getEstado());
           }
            
           
            
            session.update(libroo);
            transaction.commit();
            return "Libro Actualizada";
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Autor";
        }
       finally{
           session.close();
       }
        
   }
   
   @PUT
   @Path("actualizarTipos_Usuario")
   @Consumes("application/json")
   @Produces({"application/json"})
   
   public String Actualizar_Tipos_Usuario(Tipos_Usuario tipos_usuario){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tipos_Usuario.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        
        try{
            transaction = session.beginTransaction();
            Tipos_Usuario tipos_usuarioo = session.get(Tipos_Usuario.class, tipos_usuario.getId_tUsuario());
            
           if(tipos_usuario.getDescripcion() !=null && !tipos_usuario.getDescripcion().isEmpty()){
             tipos_usuarioo.setDescripcion(tipos_usuario.getDescripcion());    
           }else{
              tipos_usuarioo.setDescripcion(tipos_usuarioo.getDescripcion());
           }
           
            session.update(tipos_usuarioo);
            transaction.commit();
            return "Tipos_Usuario Actualizada";
           
            }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Tipos_Usuario";
        }
       finally{
           session.close();
       }

   }
   
   

    @PUT
    @Path("actualizarTransacciones")
    @Consumes("application/json")
    @Produces({"application/json"})
    
    
   public String actualizarTransacciones (Transacciones transacciones){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transacciones.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
       
        
       try {
            transaction = session.beginTransaction();
            Transacciones transaccioness = session.get(Transacciones.class, transacciones.getId_transaccion());
            
           if(transacciones.getId_usuario() != 0){
             transaccioness.setId_usuario(transacciones.getId_usuario());    
           }else{
               transaccioness.setId_usuario(transaccioness.getId_usuario());
           }
           
           if(transacciones.getId_libro() !=0){
               transaccioness.setId_libro(transacciones.getId_libro());
           }else{
               transaccioness.setId_libro(transaccioness.getId_libro());
           }
           
           if(transacciones.getTipo_transaccion() != null && !transacciones.getTipo_transaccion().isEmpty()){
               transaccioness.setTipo_transaccion(transacciones.getTipo_transaccion());
           }else{
               transaccioness.setTipo_transaccion(transaccioness.getTipo_transaccion());
           }
            
           if(transacciones.getFecha_prestamo() != null){
               transaccioness.setFecha_prestamo(transacciones.getFecha_prestamo());
           }else{
               transaccioness.setFecha_prestamo(transaccioness.getFecha_prestamo());
           }
           
           if(transacciones.getFecha_devolucion() != null){
               transaccioness.setFecha_devolucion(transacciones.getFecha_devolucion());
           }else{
               transaccioness.setFecha_devolucion(transaccioness.getFecha_devolucion());
           }
           
           
            session.update(transaccioness);
            transaction.commit();
            return "Transaccion Actualizada";
            
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Transaccion";
        }
       finally{
           session.close();
       }
        
   }
   
   
   
    @PUT
    @Path("actualizarUsuarios")
    @Consumes("application/json")
    @Produces({"application/json"})
    
    
   public String actualizarUsuarios (Usuarios usuarios){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
       
        
       try {
            transaction = session.beginTransaction();
            Usuarios usuarioss = session.get(Usuarios.class, usuarios.getId_usuario());
            
           if(usuarios.getId_estudiante() != 0){
             usuarioss.setId_estudiante(usuarios.getId_estudiante());    
           }else{
               usuarioss.setId_estudiante(usuarioss.getId_estudiante());
           }
           
           if(usuarios.getNombre_estudiante() != null && !usuarios.getNombre_estudiante().isEmpty()){
               usuarioss.setNombre_estudiante(usuarios.getNombre_estudiante());
           }else{
               usuarioss.setNombre_estudiante(usuarioss.getNombre_estudiante());
           }
           
           if(usuarios.getPassword() != null && !usuarios.getPassword().isEmpty()){
               usuarioss.setPassword(usuarios.getPassword());
           }else{
               usuarioss.setPassword(usuarioss.getPassword());
           }
            
           if(usuarios.getTpo_usuario() != 0){
               usuarioss.setTpo_usuario(usuarios.getTpo_usuario());
           }else{
               usuarioss.setTpo_usuario(usuarioss.getTpo_usuario());
           }
           
           if(usuarios.getLibros_prestados() != 0){
               usuarioss.setLibros_prestados(usuarios.getLibros_prestados());
           }else{
               usuarioss.setLibros_prestados(usuarioss.getLibros_prestados());
           }
           
           
            session.update(usuarioss);
            transaction.commit();
            return "Usuario Actualizado";
            
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar Usuario";
        }
       finally{
           session.close();
       }
        
   }
   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
     
    /**
     * PUT method for updating or creating an instance of ActualizarResource
     * @param content representation for the resource
     */
    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
    
}



