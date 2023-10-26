/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package umg.edu.gt.insertardatos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import org.hibernate.cfg.Configuration;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import umg.edu.gt.Datos.Autor;
import umg.edu.gt.Datos.Estudiante;
import umg.edu.gt.Datos.Libro;
import umg.edu.gt.Datos.Categoria;
import umg.edu.gt.Datos.Transaccion;
//http://localhost:8080/InsertarDatos/webresources/Insertar/primerWS

/**
 * REST Web Service
 *
 * @author Isai
 */
@Path("Insertar")
public class InsertarResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InsertarResource
     */
    public InsertarResource() {
    }

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

    @Path("ingresarEstudiante")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarEstudiante(Estudiante estudiante) {
        System.out.println("Los atributos son: " + estudiante.getIdentificacion() + estudiante.getNombre_estudiante() + estudiante.getCorreo() + estudiante.getTelefono() + estudiante.getDireccion() + estudiante.getId_municipio() + estudiante.getEstado());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            Estudiante estudiante1 = new Estudiante(estudiante.getIdentificacion(), estudiante.getNombre_estudiante(), estudiante.getCorreo(), estudiante.getTelefono(), estudiante.getDireccion(), estudiante.getId_municipio(), estudiante.getEstado());

            session.beginTransaction();
            //session.save(client);
            session.persist(estudiante1);

            session.getTransaction().commit();

            session.close();

            return "Estudiante creado";
        } catch (PersistenceException e) {
            e.printStackTrace();
            return "error al registrar usuario: " + e.getStackTrace();
        }

    }

    @Path("ingresarAutor")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarAutor(Autor autor) {
        System.out.println("Los atributos de autor son: " + autor.getNombre_autor());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Autor.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            Autor autor1 = new Autor(autor.getNombre_autor());

            session.beginTransaction();
            //session.save(client);
            session.persist(autor1);

            session.getTransaction().commit();

            session.close();

            return "Autor creado";
        } catch (PersistenceException e) {
            e.printStackTrace();
            return "error al registrar autor: " + e.getStackTrace();
        }
    }

    @Path("ingresarLibro")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarLibro(Libro libro) { 
                
        System.out.println("Los atributos de autor son: " + libro.getTitulo());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            Libro libro1 = new Libro(libro.getTitulo(), libro.getCategoria(), libro.getId_autor(), libro.getEdicion(), libro.getFecha_edicion(), libro.getFecha_ingreso(), libro.getEstado());

            session.beginTransaction();
            //session.save(client);
            session.persist(libro1);

            session.getTransaction().commit();

            session.close();

            return "Libro creado";
        } catch (PersistenceException e){
            e.printStackTrace();
            return "error al registrar libro: " + e.getStackTrace();
        }
    }
    
    @Path("ingresarCategoria")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarCategoria(Categoria categoria) { 
                
        System.out.println("Los atributos de autor son: " + categoria.getDescripcion());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Categoria.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            Categoria categoria1 = new Categoria(categoria.getDescripcion());

            session.beginTransaction();
            //session.save(client);
            session.persist(categoria1);

            session.getTransaction().commit();

            session.close();

            return "Categoria creada";
        } catch (PersistenceException e){
            e.printStackTrace();
            return "error al registrar categoria: " + e.getStackTrace();
        }
    }
    
    @Path("ingresarTransaccion")
    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String ingresarTransaccion(Transaccion transaccion) { 
                
        System.out.println("Los atributos de autor son: " + transaccion.getId_transaccion());

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Libro.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            Transaccion transaccion1 = new Transaccion(transaccion.getId_usuario(), transaccion.getId_libro(), transaccion.getTipo_transaccion(), transaccion.getFecha_prestamo(), transaccion.getFecha_devolucion());

            session.beginTransaction();
     
            session.persist(transaccion1);

            session.getTransaction().commit();

            session.close();

            return "Transaacion creada";
        } catch (PersistenceException e){
            e.printStackTrace();
            return "error al registrar transaccion: " + e.getStackTrace();
        }
    }

}
