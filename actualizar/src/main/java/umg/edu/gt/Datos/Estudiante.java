/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name="estudiantes")

public class Estudiante implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column (name="id_estudiante")
    private long id_estudiante;
    
    @Column (name="municipio")
    private long municipio;
    
    @Column (name="identificacion")
    private String identificacion;
    
    @Column (name="nombre_estudiante")
    private String nombre_estudiante;
    
    @Column (name="telefono")
    private String telefono;
    
    @Column (name="estado")
    private String estado;
    
    @Column (name="direccion")
    private String direccion;
    
    @Column (name="correo")
    private String correo;
    
    public Estudiante(){
        
    }
    
    
    public Estudiante(long id_estudiante, long municipio, String identificacion, String nombre_estudiante, String telefono, String estado, String direccion, String correo){
        this.id_estudiante = id_estudiante;
        this.municipio = municipio;
        this.identificacion = identificacion;
        this.nombre_estudiante = nombre_estudiante;
        this.telefono = telefono;
        this.estado = estado;
        this.direccion = direccion;
        this.correo = correo;
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
     * @return the municipio
     */
    public long getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(long municipio) {
        this.municipio = municipio;
    }

    
    
} 

