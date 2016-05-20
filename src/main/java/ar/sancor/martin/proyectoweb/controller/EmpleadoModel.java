/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.controller;

import ar.sancor.martin.proyectoweb.entidades.Empleado;
import ar.sancor.martin.proyectoweb.service.EmpleadoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author martdominguez
 */
@Named("empleadoBean")
@SessionScoped
public class EmpleadoModel   implements Serializable {

    @Inject EmpleadoService empSrv;    
    private Empleado emp = null;
    private List<Empleado> listaEmpleados = null;
    
    @PostConstruct
    public void init(){
        System.out.println("INICIO ");
        listaEmpleados = new ArrayList<Empleado>();
    }

    public void nuevo(ActionEvent actionEvent){
        System.out.println("Nuevo ! !! !");
        emp=new Empleado();
        emp.setNombre("pepe0");
        emp.setCostoHora(44.56);
        empSrv.crear(emp);
    }
    public void guardar2(){
        System.out.println("EJECUTA ! !! !"+emp);
        if(this.emp!=null){
            if( this.emp.getId()!=null && this.emp.getId()>0) {
                empSrv.actualizar(emp);
            }else {
                emp = empSrv.crear(emp);
            }
        }
    }

    public void borrar(ActionEvent e){
       // empSrv.borrar(emp);
                       System.out.println("EJECUTA ! !! ! borrar ! ! !*&^&*("+emp);

    }

    public EmpleadoService getEmpSrv() {
        return empSrv;
    }

    public void setEmpSrv(EmpleadoService empSrv) {
        this.empSrv = empSrv;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
}
