/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.biblioteca.Datos;

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

public class Estudiante implements Serializable {
    
    private Long id_estudiante;
    private String identificacion;
    private String nombre_estudiante;
    private String correo;
    private String telefono;
    private String direccion;
    private Long id_municipio;
    private String estado;

    public Estudiante(String identificacion, String nombre_estudiante, String correo, String telefono, String direccion, Long id_municipio, String estado) {
        this.identificacion = identificacion;
        this.nombre_estudiante = nombre_estudiante;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_municipio = id_municipio;
        this.estado = estado;
    }

    public Estudiante() {
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
     * @return the municipio
     */
    public Long getMunicipio() {
        return id_municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Long municipio) {
        this.id_municipio = municipio;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

   

   
}
