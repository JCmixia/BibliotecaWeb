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
@Table(name="autores")

public class Autor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    
    @Column (name="id_autor")
    private long id_autor;
    
    @Column (name="nombre_autor")
    private String nombre_autor;
    
    
    public Autor() {
    }

    public Autor(long id_autor, String nombre_autor){
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
       
    }
    



    /**
     * @return the id_autor
     */
    public long getId_autor() {
        return id_autor;
    }

    /**
     * @param id_autor the id_autor to set
     */
    public void setId_autor(long id_autor) {
        this.id_autor = id_autor;
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


}