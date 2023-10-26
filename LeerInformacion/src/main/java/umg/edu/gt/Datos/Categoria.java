/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.Datos;


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
@Table(name = "categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id_tipo;
    
    @Column(name = "descripcion")
    private String descripcion;

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    
    /**
     * @return the id_tipo
     */
    public Long getId_tipo() {
        return id_tipo;
    }

    /**
     * @param id_tipo the id_tipo to set
     */
    public void setId_tipo(Long id_tipo) {
        this.id_tipo = id_tipo;
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

   
   
    
    
}
