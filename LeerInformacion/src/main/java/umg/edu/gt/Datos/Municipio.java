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
@Table (name = "municipios")
public class Municipio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private Long id_municipio;
    
    @Column(name = "id_departamento")
    private Long id_departamento;
    
    @Column(name = "nombre_municipio")
    private String nombre_municipio;

    public Municipio(Long id_departamento, String nombre_municipio) {
        this.id_departamento = id_departamento;
        this.nombre_municipio = nombre_municipio;
    }

    public Municipio() {
        
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
     * @return the id_departamento
     */
    public Long getId_departamento() {
        return id_departamento;
    }

    /**
     * @param id_departamento the id_departamento to set
     */
    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    /**
     * @return the nombre_municipio
     */
    public String getNombre_municipio() {
        return nombre_municipio;
    }

    /**
     * @param nombre_municipio the nombre_municipio to set
     */
    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }
      
}
