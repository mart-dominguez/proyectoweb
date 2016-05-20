/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.service;

import ar.sancor.martin.proyectoweb.entidades.Tarea;
import ar.sancor.martin.proyectoweb.entidades.Tarea;
import java.util.List;

/**
 *
 * @author martdominguez
 */

public interface TareaService {
    public Tarea crear(Tarea e);
    public Tarea actualizar(Tarea e);
    public Tarea borrar(Tarea e);
    public Tarea buscar(Integer id);
    public List<Tarea> listar();
}
