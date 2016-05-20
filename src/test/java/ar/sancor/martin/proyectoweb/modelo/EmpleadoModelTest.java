/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.modelo;

import ar.sancor.martin.proyectoweb.controller.EmpleadoModel;
import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.service.EmpleadoService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author martdominguez
 */
public class EmpleadoModelTest {
    
    public EmpleadoModelTest() {
    }
    private EmpleadoModel empMod;
    private Empleado empleadoTest;
    private EmpleadoService empleadoService;
    
    @Before
    public void setUp() {
        empMod = new EmpleadoModel();
        empleadoTest = new Empleado();
        empleadoTest.setNombre("pepe");
        empleadoService = new EmpleadoServiceMOCK();
        empMod.setEmp(empleadoTest);
        empMod.setEmpSrv(empleadoService);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        empMod.guardar2();
        assertEquals(Integer.valueOf(99), empMod.getEmp().getId());
        empMod.guardar2();
        assertEquals(Integer.valueOf(100), empMod.getEmp().getId());
        empMod.setEmp(null);
        assertNull(empMod.getEmp());       
    }
}
