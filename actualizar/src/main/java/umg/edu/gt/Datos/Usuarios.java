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
 * @author ADMIN
 */

@Entity
@Table(name="usuarios")

public class Usuarios implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    @Column(name="id_usuario")
    private long id_usuario;
    
    @Column(name="id_estudiante")
    private long id_estudiante;
    
    @Column (name="nombre_estudiante")
    private String nombre_estudiante;
    
    @Column (name="password")
    private String password;
    
    @Column (name="tpo_usuario")
    private long tpo_usuario;
    
    @Column (name="libros_prestados")
    private long libros_prestados;
    
   
public Usuarios() {
    
}

public Usuarios(long id_usuario, long id_estudiante, String nombre_estudiante, String password, long tpo_usuario, long libros_prestados){
    this.id_usuario = id_usuario;
    this.id_estudiante = id_estudiante;
    this.nombre_estudiante = nombre_estudiante;
    this.password = password;
    this.tpo_usuario =tpo_usuario;
    this.libros_prestados = libros_prestados;
}


    /**
     * @return the id_usuario
     */
    public long getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_estudiante
     */
    public long getId_estudiante() {
        return id_estudiante;
    }

    /**
     * @param id_estudiante the id_estudiante to set
     */
    public void setId_estudiante(long id_estudiante) {
        this.id_estudiante = id_estudiante;
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
    public long getTpo_usuario() {
        return tpo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTpo_usuario(long tipo_usuario) {
        this.tpo_usuario = tipo_usuario;
    }

    /**
     * @return the libros_prestados
     */
    public long getLibros_prestados() {
        return libros_prestados;
    }

    /**
     * @param libros_prestados the libros_prestados to set
     */
    public void setLibros_prestados(long libros_prestados) {
        this.libros_prestados = libros_prestados;
    }
}