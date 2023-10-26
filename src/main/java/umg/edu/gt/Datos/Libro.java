/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Datos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id_libro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "id_autor")
    private Long id_autor;

    @Column(name = "edicion")
    private String edicion;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_edicion")
    private Date fecha_edicion;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_ingreso")
    private Date fecha_ingreso;

    @Column(name = "estado")
    private String estado;

    public Libro(String titulo, String categoria, Long id_autor, String edicion, Date fecha_edicion, Date fecha_ingreso, String estado) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.id_autor = id_autor;
        this.edicion = edicion;
        this.fecha_edicion = fecha_edicion;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Libro() {
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
    public Date getFecha_edicion() {
        return fecha_edicion;
    }

    /**
     * @param fecha_edicion the fecha_edicion to set
     */
    public void setFecha_edicion(Date fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    /**
     * @return the fecha_ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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
