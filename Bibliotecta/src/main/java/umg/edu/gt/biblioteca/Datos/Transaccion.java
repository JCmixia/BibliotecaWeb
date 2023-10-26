/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.biblioteca.Datos;


import java.util.Date;
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

public class Transaccion implements Serializable {


    private Long id_transaccion;
    private Long id_usuario;
    private Long id_libro;
    private String tipo_transaccion;
    private String fecha_prestamo;
    private String fecha_devolucion;

    public Transaccion() {
    }

    public Transaccion(Long id_usuario, Long id_libro, String tipo_transaccion, String fecha_prestamo, String fecha_devolucion) {
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.tipo_transaccion = tipo_transaccion;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
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
}
