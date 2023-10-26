/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Datos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Isai
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

 
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "id_estudiante")
    private String id_estudiante;

    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    
    @Column(name = "password")
    private String password;

    @Column(name = "tipo_usuario")
    private String tipo_usuario;

    @Column(name = "libros_prestados")
    private String libros_prestados;

    public Usuario(Long id_usuario, String nombre_usuario, String tipo_usuario, String password, String tpo_usuario, String libros_prestados) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.nombre_usuario = tipo_usuario;
        this.password = password;
        this.tipo_usuario = tpo_usuario;
        this.libros_prestados = libros_prestados;
    }

    public Usuario() {
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
     * @return the id_estudiante
     */
    public String getId_estudiante() {
        return id_estudiante;
    }

    /**
     * @param id_estudiante the id_estudiante to set
     */
    public void setId_estudiante(String id_estudiante) {
        this.id_estudiante = id_estudiante;
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
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the libros_prestados
     */
    public String getLibros_prestados() {
        return libros_prestados;
    }

    /**
     * @param libros_prestados the libros_prestados to set
     */
    public void setLibros_prestados(String libros_prestados) {
        this.libros_prestados = libros_prestados;
    }
  
}
