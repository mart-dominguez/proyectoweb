/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.modelo;

import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.entidades.Tarea;
import ar.sancor.martin.proyectoweb.service.EmpleadoService;
import java.util.List;

/**
 *
 * @author martdominguez
 */
public class EmpleadoServiceMOCK implements EmpleadoService{

    @Override
    public Empleado crear(Empleado e) {
        System.out.println("SE VA A CREAR "+e.getNombre());
        e.setId(99);
        return e;
    }

    @Override
    public Empleado actualizar(Empleado e) {
        System.out.println("SE VA A ACTUALIZAR"+e.getNombre());
        e.setId(100);
        return e;
    }

    @Override
    public void borrar(Empleado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado buscar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarTarea(Empleado e, Tarea t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
