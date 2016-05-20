/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.service;


import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.entidades.Habilidades;
import ar.sancor.martin.proyectoweb.entidades.Tarea;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

 
//runner de mockito que detecta las anotaciones
@RunWith(MockitoJUnitRunner.class)
public class TestEmpleado {
    @Mock
    private EntityManager entityManager; 
    @Mock
    private Query query;    
    @Mock
    private  List<Tarea> tareasIncompletas;

    @Mock
    private  List<Habilidades> listaHabilidades;

    @Mock
    private Empleado e;
    
    @Mock
    private Tarea tarea;
    
    @Test
    public void testAsignarTarea(){
        Mockito.when(tareasIncompletas.size()).thenReturn(3);
        Mockito.when(entityManager.createQuery(any(String.class))).thenReturn(query);
        Mockito.when(query.setParameter(any(String.class), any(Integer.class))).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(tareasIncompletas);
        Mockito.when(e.getHabilidades()).thenReturn(listaHabilidades);
        Mockito.when(e.getTareasAsignadas()).thenReturn(new ArrayList<Tarea>());
        Mockito.when(listaHabilidades.contains(any(Habilidades.class))).thenReturn(true);
        Mockito.when(tarea.getHabilidadRequerida()).thenReturn(any(Habilidades.class));
        
        e.setTareasAsignadas(new ArrayList<Tarea>());
        assertEquals(0, e.getTareasAsignadas().size());
        EmpleadoServiceJPA empSrvJPA= new EmpleadoServiceJPA();
        empSrvJPA.setEm(entityManager);
        empSrvJPA.asignarTarea(e, tarea);
        assertEquals(1, e.getTareasAsignadas().size());
        verify(e, atLeast(1)).getTareasAsignadas();
    }
}
