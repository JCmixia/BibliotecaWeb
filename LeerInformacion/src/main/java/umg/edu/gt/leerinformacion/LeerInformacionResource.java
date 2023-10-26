/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package umg.edu.gt.leerinformacion;

//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import umg.edu.gt.Datos.Autor;
import umg.edu.gt.Datos.Estudiante;
import umg.edu.gt.Datos.Libro;
import umg.edu.gt.Datos.Categoria;
import umg.edu.gt.Datos.Transaccion;
import umg.edu.gt.Datos.Usuario;

/**
 * REST Web Service
 *
 * @author Isai
 */
@Path("leer")
public class LeerInformacionResource {

    @GET
    @Path("primerWS")
    @Produces({"text/plain"})
    @Consumes({"text/plain"})
    public String primerWS() {
        //TODO return proper representation object
        return "Mi primer API WS";
    }

    @Path("pruebaWSParametrosJson")
    @GET
    @Consumes({"text/plain"})
    @Produces({"text/plain"})
    public String pruebaWSParametrosJson(@QueryParam("Nombre") String pNombre, @QueryParam("Apellido") String pApellido) {
        JsonObject jo = new JsonObject();
        jo.addProperty("Nombre", pNombre);
        jo.addProperty("Apellido", pApellido);
        System.out.println("el objeto json es: " + jo.toString());

        return jo.toString();
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
            
            estudiantee.setDireccion(estudiante.getDireccion());
            estudiantee.setEstado(estudiante.getEstado());

            estudiantee.setNombre_estudiante(estudiante.getNombre_estudiante());
            estudiantee.setTelefono(estudiante.getTelefono());
            
            session.update(estudiantee);
            transaction.commit();
            return "Estudiante Actualizado";
           
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
            return"Fallo al Actualizar";
        }
       finally{
           session.close();
       }

    }

    @Path("consultarUser")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarUser() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;

        try {
            Query query = session.createQuery("from Usuario");

            List<Usuario> usuarios = query.list();

            session.close();

            json = gson.toJson(usuarios);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar clientes " + e.getStackTrace());
            return "Error al consultar usuarios";
        }
        return json.toString();
    }

    @Path("consultarEstudiantes")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarEstudiantes() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        Gson gson = new Gson();
        String json = null;

        try {
            Query query = session.createQuery("from Estudiante");

            List<Estudiante> estudiantes = query.list();

            session.close();

            json = gson.toJson(estudiantes);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar estudiantes " + e.getStackTrace());
            return "Error al consultar usuarios";
        }
        return json.toString();
    }

    @Path("consultarAutores")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarAutores() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Autor.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        try {
            Query query = session.createQuery("from Autor");

            List<Autor> autores = query.list();

            session.close();
            
            Gson gson = new Gson();
            String json = gson.toJson(autores);

            return json.toString();
            
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar autores " + e.getStackTrace());
            return "Error al consultar autores";
        }

    }
    
    @Path("consultarCategorias")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarCateogorias() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Categoria.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        try {
            Query query = session.createQuery("from TipoLibro");

            List<Categoria> tipoLibros = query.list();

            session.close();
            
            Gson gson = new Gson();
            String json = gson.toJson(tipoLibros);

            return json.toString();
            
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar TipoLibros " + e.getStackTrace());
            return "Error al consultar TipoLibros";
        }

    }
    
    @Path("consultarLibros")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarLibros() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        try {
            Query query = session.createQuery("from Libro");

            List<Libro> libros = query.list();

            session.close();
            
            Gson gson = new Gson();
            String json = gson.toJson(libros);

            return json.toString();
            
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar libros " + e.getStackTrace());
            return "Error al consultar libros";
        }

    }
    
    @Path("consultarTransacciones")
    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String consultarTransacciones() {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Transaccion.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        try {
            Query query = session.createQuery("from Transaccion");

            List<Transaccion> transacciones = query.list();

            session.close();
            
            Gson gson = new Gson();
            String json = gson.toJson(transacciones);

            return json.toString();
            
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error HB al consultar transacciones " + e.getStackTrace());
            return "Error al consultar transacciones";
        }

    }

}
