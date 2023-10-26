/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.bibliotecta.Inicio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;
import umg.edu.gt.biblioteca.Datos.Autor;
import umg.edu.gt.biblioteca.Datos.Estudiante;
import umg.edu.gt.biblioteca.Datos.Libro;
import umg.edu.gt.biblioteca.Datos.Categoria;
import umg.edu.gt.biblioteca.Datos.Transaccion;
import umg.edu.gt.biblioteca.Datos.Usuario;
import umg.edu.gt.biblioteca.Datos.Estudiante;

/**
 *
 * @author Isai
 */
@ManagedBean(name = "bkn_Inicio")
@ViewScoped
public class biblioteca {

    /**
     * @return the id_tipo_cat
     */
    public Long getId_tipo_cat() {
        return id_tipo_cat;
    }

    /**
     * @param id_tipo_cat the id_tipo_cat to set
     */
    public void setId_tipo_cat(Long id_tipo_cat) {
        this.id_tipo_cat = id_tipo_cat;
    }

    /**
     * @return the descripcion_cat
     */
    public String getDescripcion_cat() {
        return descripcion_cat;
    }

    /**
     * @param descripcion_cat the descripcion_cat to set
     */
    public void setDescripcion_cat(String descripcion_cat) {
        this.descripcion_cat = descripcion_cat;
    }

    /**
     * @return the estudiantes2
     */
    public List<Estudiante> getEstudiantes2() {
        return estudiantes2;
    }

    /**
     * @param estudiantes2 the estudiantes2 to set
     */
    public void setEstudiantes2(List<Estudiante> estudiantes2) {
        this.estudiantes2 = estudiantes2;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private List<Libro> libros = new ArrayList<Libro>();
    private List<Autor> autores = new ArrayList<Autor>();
    private List<Transaccion> transacciones = new ArrayList<Transaccion>();
    private List<Categoria> categoria = new ArrayList<Categoria>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    //datos estudiante
    private Long id_estudiante;
    private String identificacion;
    private String nombre_estudiante;
    private String telefono;
    private String correo;
    private String direccion;
    private Long id_municipio;
    private String estadoEstudiante;

    private List<Estudiante> estudiantes2 = new ArrayList<Estudiante>();

    //datos libro
    private Long id_libro;
    private String categori;
    private Long id_autor;
    private String titulo;
    private String idioma;
    private String edicion;
    private String fecha_edicion;
    private String fecha_ingreso;
    private Long stock;
    private String estadoLibro;

    //datos autor
    private Long id_Autor;
    private String nombre_autor;
    private String correoAutor;

    //datos transaccion
    private Long id_transaccion;
    private Long estudiante_id;
    private Long libro_id;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private String estadoTransa;
    private Long id_usuario;
    private String tipo_transaccion;
    private String descripcion;

    //datos usuario
    //private Long id_user;
    //private String id_estudiant;
    private String nombre_usuario;
    private String password;
    //private String tipo_usuario;
    //private String libros_prestados;
    private String respuesta;

    //datos categoria
    private Long id_tipo_cat;
    private String descripcion_cat;

    // Crear una instancia de ArrayList
    private List<String> estados = new ArrayList<>();
    private List<String> nombresEstados = new ArrayList<>();
    private List<String> nombresMunicipios = new ArrayList<>();

    @PostConstruct
    public void init() {

        try {
            listarEstudiantes();
            listarLibros();
            listarAutores();
            listarTransacciones();
            listarCategorias();
            listrarUsuarios();
        } catch (Exception e) {
            System.out.println("Error al consumir el web service: " + e.toString());
        }

        // Agregar elementos a la lista
        estados.add("prestado");
        estados.add("devuelto");

        for (Categoria tipo : categoria) {
            nombresEstados.add(tipo.getDescripcion());
        }
        //imprimimos los nombres de la tabla de estados de libros
        for (String tipo : nombresEstados) {
            System.out.println("Nombres de estados: " + tipo);
        }

    }

    public void listarEstudiantes() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarEstudiantes";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Estudiante>>() {
        }.getType();
        List<Estudiante> estudianteList = gson.fromJson(response.body(), listType);
        setEstudiantes(estudianteList);

        /*
        // Crear una solicitud POST con parámetros
        request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar la solicitud y obtener la respuesta
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("respuesta: " + response.body());
         */
        //JsonParser parser = new JsonParser();        
        //JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
        //JsonFactory factory = new JsonFactory();
        //JsonParser parser = factory.createParser(jsonString);
        //JsonArray jsonArray = parser.parse(response.body()).getAsJsonArray();
        /*
        // Ahora puedes trabajar con el objeto JSON de tipo array
        for (int i = 0; i < jsonArray.size(); i++) {
            String nombre = jsonArray.get(i).getAsJsonObject().get("name").getAsString();
            String link = jsonArray.get(i).getAsJsonObject().get("url").getAsString();

            System.out.println("Elemento " + i + ":");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + link);
        }*/
    }

    public void agregarEstudiante() throws IOException, InterruptedException {

        if (identificacion != null && !nombre_estudiante.isEmpty() && !correo.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty()){
            id_municipio = Long.parseLong("1");
            Estudiante estudiante = new Estudiante(identificacion, nombre_estudiante, correo, telefono, direccion, id_municipio, "Activo");
            String url = "http://localhost:8080/InsertarDatos/webresources/Insertar/ingresarEstudiante";

            HttpClient client = HttpClient.newHttpClient();

            Gson gson = new Gson();
            String json = gson.toJson(estudiante);
            System.out.println(json);

            // Crear una solicitud POST con parámetros
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Imprimir el cuerpo de la respuesta
            System.out.println("respuesta: " + response.body());

            respuesta = response.body();
            // respuesta = "Estudiante agregado";
            listarEstudiantes();

            setId_estudiante(null);
            setIdentificacion(" ");
            setNombre_estudiante(" ");
            setTelefono(" ");
            setDireccion(" ");
            setId_municipio(null);
            setEstadoEstudiante(" ");
            setCorreo(" ");

        }else{
            respuesta = "Por favor llene todos los campos";
        }
        
    }

    public void editarEstudiante(RowEditEvent event) {

        Estudiante estudiante = (Estudiante) event.getObject();

        id_estudiante = estudiante.getId_estudiante();
        identificacion = estudiante.getIdentificacion();
        nombre_estudiante = estudiante.getNombre_estudiante();
        telefono = estudiante.getTelefono();
        correo = estudiante.getCorreo();
        direccion = estudiante.getDireccion();
        estadoEstudiante = estudiante.getEstado();

        try {
            actualizarEstudiante();
        } catch (Exception e) {
            System.out.println("Error al editarEstudiante");
        }
    }

    public void listarLibros() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarLibros";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Libro>>() {
        }.getType();
        List<Libro> libros = gson.fromJson(response.body(), listType);
        setLibros(libros);
    }

    public void agregarLibro() throws IOException, InterruptedException {

        Libro libro = new Libro(titulo.trim(), categori.trim(), id_autor, edicion.trim(), fecha_edicion.trim(), fecha_ingreso.trim(), estadoLibro.trim());

        String url = "http://localhost:8080/InsertarDatos/webresources/Insertar/ingresarLibro";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(libro);

        System.out.println(json);

        // Crear una solicitud POST con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta

        listarLibros();

        System.out.println("respuesta: " + response.body());

        setId_libro(null);
        setCategori(null);
        setId_autor(null);
        setTitulo(" ");
        //setIdioma(" ");
        setEdicion(" ");
        setFecha_edicion(" ");
        setFecha_ingreso(" ");
        setStock(null);
        setEstadoLibro(" ");

    }

    public void listarAutores() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarAutores";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Autor>>() {
        }.getType();
        List<Autor> autores = gson.fromJson(response.body(), listType);
        setAutores(autores);
    }

    public void agregarAutor() throws IOException, InterruptedException {

        Autor autor = new Autor(nombre_autor.trim());
        String url = "http://localhost:8080/InsertarDatos/webresources/Insertar/ingresarAutor";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(autor);

        System.out.println(json);

        // Crear una solicitud POST con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta

        listarAutores();

        System.out.println("respuesta: " + response.body());

        setId_Autor(null);
        setNombre_autor(" ");
        //setCorreoAutor(" ");

    }

    public void listarTransacciones() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarTransacciones";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Transaccion>>() {
        }.getType();
        List<Transaccion> transacciones = gson.fromJson(response.body(), listType);
        setTransacciones(transacciones);
    }

    public void agregarTransaccion() throws IOException, InterruptedException {

        Transaccion transaccion = new Transaccion(id_usuario, libro_id, getTipo_transaccion(), fecha_prestamo.trim(), fecha_devolucion.trim());

        String url = "http://localhost:8080/InsertarDatos/webresources/Insertar/ingresarTransaccion";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(transaccion);

        System.out.println(json);

        // Crear una solicitud POST con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta

        listarTransacciones();

        System.out.println("respuesta: " + response.body());

        id_transaccion = null;
        estudiante_id = null;
        libro_id = null;
        fecha_prestamo = "";
        fecha_devolucion = "";

    }

    public void listarCategorias() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarCategorias";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Categoria>>() {
        }.getType();
        List<Categoria> categorias = gson.fromJson(response.body(), listType);
        setCategoria(categorias);
    }

    public void agregarTipo() throws IOException, InterruptedException {

        Categoria categoria = new Categoria(descripcion.trim());
        String url = "http://localhost:8080/InsertarDatos/webresources/Insertar/ingresarTipoLibro";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(categoria);

        System.out.println(json);

        // Crear una solicitud POST con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta

        System.out.println("respuesta: " + response.body());

        descripcion = "";

    }

    public void listrarUsuarios() throws IOException, InterruptedException {

        String url = "http://localhost:8080/LeerInformacion/webresources/leer/consultarUser";

        HttpClient client = HttpClient.newHttpClient();

        // Crear una solicitud GET sin parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Imprimir el cuerpo de la respuesta
        System.out.println("La respuesta del servicio es: " + response.body());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Usuario>>() {
        }.getType();
        List<Usuario> usuarios = gson.fromJson(response.body(), listType);
        setUsuarios(usuarios);
    }

    public void validarUsuario() throws IOException {

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (compararDatos() == true) {

            externalContext.redirect("http://localhost:8080/Bibliotecta/pages/inicio/bienvenida.xhtml");
            respuesta = "Bienvenido";
        } else {
            respuesta = "Credenciales incorectas";

        }

    }

    public boolean compararDatos() {

        for (Usuario tipo : usuarios) {
            // System.out.println("ELEMENTOS DE LA LISTA: " + tipo.getNombre_usuario().trim()+":"+nombre_usuario.trim()+ ":" + tipo.getPassword().trim()+ ":" + password.trim());
            if (tipo.getNombre_usuario().equals(nombre_usuario) && tipo.getPassword().equals(password)) {
                FacesContext facesContext = FacesContext.getCurrentInstance();

                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true); // true para crear una nueva sesión si no existe

                session.setAttribute("sessionUsuario", tipo.getId_usuario());
                return true;
            }
        }
        return false;
    }

    /////////metodos Actualizar ////////////
    public void actualizarEstudiante() throws IOException, InterruptedException {
        Estudiante autor = new Estudiante(id_estudiante, identificacion, nombre_estudiante, correo, telefono, direccion, id_municipio, estadoEstudiante);

        String url = "http://localhost:8080/actualizar/webresources/actualizar/actualizarEstudiante";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(autor);

        System.out.println(json);

        // Crear una solicitud PUT con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        listarAutores();

        System.out.println("respuesta: " + response.body());

        setId_autor(null);
        setNombre_autor(" ");
    }

    public void actualizarAutor() throws IOException, InterruptedException {
        Autor autor = new Autor();
        autor.setId_autor(id_autor);
        autor.setNombre_autor(nombre_autor);

        String url = "http://localhost:8090/actualizar/webresources/actualizar/actualizarAutor";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(autor);

        System.out.println(json);

        // Crear una solicitud PUT con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        listarAutores();

        System.out.println("respuesta: " + response.body());

        setId_autor(null);
        setNombre_autor(" ");
    }

    public void actualizarCategorias() throws IOException, InterruptedException {
        Categoria categoria = new Categoria();
        categoria.setId_tipo(getId_tipo_cat());
        categoria.setDescripcion(getDescripcion_cat());

        String url = "http://localhost:8090/actualizar/webresources/actualizar/actualizarCategoria";

        HttpClient client = HttpClient.newHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(categoria);

        System.out.println(json);

        // Crear una solicitud PUT con parámetros
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        listarCategorias();

        System.out.println("respuesta: " + response.body());

        setId_tipo_cat(null);
        setDescripcion_cat("");
    }

    public void limpiarDatos() {

        respuesta = "";
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the nombresMunicipios
     */
    public List<String> getNombresMunicipios() {
        return nombresMunicipios;
    }

    /**
     * @param nombresMunicipios the nombresMunicipios to set
     */
    public void setNombresMunicipios(List<String> nombresMunicipios) {
        this.nombresMunicipios = nombresMunicipios;
    }

    /**
     * @return the tipo_transaccion
     */
    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    /**
     * @param tipo_transaccion the tipo_transaccion to set
     */
    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    /**
     * @return the id_usuario
     */
    public Long getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the nombresEstados
     */
    public List<String> getNombresEstados() {
        return nombresEstados;
    }

    /**
     * @param nombresEstados the nombresEstados to set
     */
    public void setNombresEstados(List<String> nombresEstados) {
        this.nombresEstados = nombresEstados;
    }

    /**
     * @return the estados
     */
    public List<String> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estudiantes
     */
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * @param estudiantes the estudiantes to set
     */
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    /**
     * @return the libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * @return the autores
     */
    public List<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    /**
     * @return the transacciones
     */
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * @param transacciones the transacciones to set
     */
    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    /**
     * @return the categoria
     */
    public List<Categoria> getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the id_estudiante
     */
    public Long getId_estudiante() {
        return id_estudiante;
    }

    /**
     * @param id_estudiante the id_estudiante to set
     */
    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre_estudiante
     */
    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    /**
     * @param nombre_estudiante the nombre_estudiante to set
     */
    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the id_municipio
     */
    public Long getId_municipio() {
        return id_municipio;
    }

    /**
     * @param id_municipio the id_municipio to set
     */
    public void setId_municipio(Long id_municipio) {
        this.id_municipio = id_municipio;
    }

    /**
     * @return the estadoEstudiante
     */
    public String getEstadoEstudiante() {
        return estadoEstudiante;
    }

    /**
     * @param estadoEstudiante the estadoEstudiante to set
     */
    public void setEstadoEstudiante(String estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    /**
     * @return the id_libro
     */
    public Long getId_libro() {
        return id_libro;
    }

    /**
     * @param id_libro the id_libro to set
     */
    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    /**
     * @return the categori
     */
    public String getCategori() {
        return categori;
    }

    /**
     * @param categori the categori to set
     */
    public void setCategori(String categori) {
        this.categori = categori;
    }

    /**
     * @return the id_autor
     */
    public Long getId_autor() {
        return id_autor;
    }

    /**
     * @param id_autor the id_autor to set
     */
    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the fecha_edicion
     */
    public String getFecha_edicion() {
        return fecha_edicion;
    }

    /**
     * @param fecha_edicion the fecha_edicion to set
     */
    public void setFecha_edicion(String fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    /**
     * @return the fecha_ingreso
     */
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the stock
     */
    public Long getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Long stock) {
        this.stock = stock;
    }

    /**
     * @return the estadoLibro
     */
    public String getEstadoLibro() {
        return estadoLibro;
    }

    /**
     * @param estadoLibro the estadoLibro to set
     */
    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    /**
     * @return the id_Autor
     */
    public Long getId_Autor() {
        return id_Autor;
    }

    /**
     * @param id_Autor the id_Autor to set
     */
    public void setId_Autor(Long id_Autor) {
        this.id_Autor = id_Autor;
    }

    /**
     * @return the nombre_autor
     */
    public String getNombre_autor() {
        return nombre_autor;
    }

    /**
     * @param nombre_autor the nombre_autor to set
     */
    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    /**
     * @return the correoAutor
     */
    public String getCorreoAutor() {
        return correoAutor;
    }

    /**
     * @param correoAutor the correoAutor to set
     */
    public void setCorreoAutor(String correoAutor) {
        this.correoAutor = correoAutor;
    }

    /**
     * @return the id_transaccion
     */
    public Long getId_transaccion() {
        return id_transaccion;
    }

    /**
     * @param id_transaccion the id_transaccion to set
     */
    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * @return the estudiante_id
     */
    public Long getEstudiante_id() {
        return estudiante_id;
    }

    /**
     * @param estudiante_id the estudiante_id to set
     */
    public void setEstudiante_id(Long estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    /**
     * @return the libro_id
     */
    public Long getLibro_id() {
        return libro_id;
    }

    /**
     * @param libro_id the libro_id to set
     */
    public void setLibro_id(Long libro_id) {
        this.libro_id = libro_id;
    }

    /**
     * @return the fecha_prestamo
     */
    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    /**
     * @param fecha_prestamo the fecha_prestamo to set
     */
    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    /**
     * @return the fecha_devolucion
     */
    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    /**
     * @param fecha_devolucion the fecha_devolucion to set
     */
    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    /**
     * @return the estadoTransa
     */
    public String getEstadoTransa() {
        return estadoTransa;
    }

    /**
     * @param estadoTransa the estadoTransa to set
     */
    public void setEstadoTransa(String estadoTransa) {
        this.estadoTransa = estadoTransa;
    }
}
