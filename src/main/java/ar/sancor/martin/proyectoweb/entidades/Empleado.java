/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author martdominguez
 */
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    
    private Double costoHora;
    
    @OneToMany(mappedBy = "empleado")
    private List<Tarea> tareasAsignadas;

    @ManyToMany
    @JoinTable(name = "HABILIDADES_EMPLEADOS",joinColumns = @JoinColumn(name = "ID_EMPLEADO"),
    inverseJoinColumns = @JoinColumn(name = "ID_HABILIDAD"))
    private List<Habilidades> habilidades;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    public void setTareasAsignadas(List<Tarea> tareasAsignadas) {
        this.tareasAsignadas = tareasAsignadas;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * @return the costoHora
     */
    public Double getCostoHora() {
        return costoHora;
    }

    /**
     * @param costoHora the costoHora to set
     */
    public void setCostoHora(Double costoHora) {
        this.costoHora = costoHora;
    }
    
    
}
