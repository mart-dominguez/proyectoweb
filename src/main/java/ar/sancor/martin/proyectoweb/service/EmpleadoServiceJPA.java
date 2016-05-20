/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.service;

import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.entidades.Tarea;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author martdominguez
 */
@RequestScoped
@Transactional
public class EmpleadoServiceJPA implements EmpleadoService{
    @PersistenceContext(unitName = "proyectos-pu")
    private EntityManager em;

    @Override
    public Empleado crear(Empleado e) {
        System.out.println("CREA CREA CREA");
        em.persist(e);
        em.flush();
        em.refresh(e);
        return e;
    }

    @Override
    public Empleado actualizar(Empleado e) {
        return em.merge(e);
    }

    @Override
    public void borrar(Empleado e) {
        em.remove(em.find(Empleado.class, e.getId()));
    }

    @Override
    public Empleado buscar(Integer id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public List<Empleado> listar() {
        return em.createQuery("SELECT e FROM Empleado e").getResultList();
    }

     /**
     * Un empleado puede ser asignado a una tarea SI
     * 1- No tiene más de 2 tareas pendientes
     * 2- Tiene la habilidad requerida
     * @param e
     * @param t 
     */
    @Override
    public void asignarTarea(Empleado e, Tarea t) {
        Query q =em.createQuery("SELECT t FROM Empleado e JOIN Tarea t WHERE e.id= :P_ID_EMPLEADO AND t.completada= FALSE" );
        q.setParameter("P_ID_EMPLEADO", e.getId());
        List<Tarea> task = q.getResultList();
                    System.out.println("llega 0");

        if(task.size()<4){
            if(e.getHabilidades().contains(t.getHabilidadRequerida())){
                e.getTareasAsignadas().add(t);
            }
        }
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
