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
@Table(name="tipos_usuario")

public class Tipos_Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    @Column (name="id_tUsuario")
    private long id_tUsuario;
    
    @Column (name="descripcion")
    private String descripcion;
    
   
public Tipos_Usuario() {
    
}

    public Tipos_Usuario(long id_tUsuario, String descripcion){
        this.id_tUsuario = id_tUsuario;
        this.descripcion = descripcion;
    }




    /**
     * @return the id_tUsuario
     */
    public long getId_tUsuario() {
        return id_tUsuario;
    }

    /**
     * @param id_tUsuario the id_tUsuario to set
     */
    public void setId_tUsuario(long id_tUsuario) {
        this.id_tUsuario = id_tUsuario;
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
