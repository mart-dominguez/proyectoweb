/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.service;

import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.entidades.Tarea;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public interface EmpleadoService {
    public Empleado crear(Empleado e);
    public Empleado actualizar(Empleado e);
    public void borrar(Empleado e);
    public Empleado buscar(Integer id);
    public List<Empleado> listar();
    /**
     * Un empleado puede ser asignado a una tarea SI
     * 1- No tiene más de 2 tareas pendientes
     * 2- Tiene la habilidad requerida
     * @param e
     * @param t 
     */
    public void asignarTarea(Empleado e,Tarea t);
}
