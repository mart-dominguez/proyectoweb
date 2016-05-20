/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sancor.martin.proyectoweb.service;

import ar.sancor.martin.proyectoweb.entidades.Habilidades;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author martdominguez
 */
@RequestScoped
public class HabilidadesServiceMOCK implements HabilidadService{

    private List<Habilidades> lista;
    
    public void init(){
        Habilidades h1 = new Habilidades();
        h1.setId(1);
        h1.setHabilidad("Java");
        Habilidades h2 = new Habilidades();
        h2.setId(2);
        h2.setHabilidad("C#");
        Habilidades h3 = new Habilidades();
        h3.setId(3);
        h3.setHabilidad("PHP");
        lista.add(h1);
        lista.add(h2);
        lista.add(h3);    
    }
    
    @Override
    public Habilidades crear(Habilidades e) {
        // ok!
        return e;
    }

    @Override
    public Habilidades actualizar(Habilidades e) {
        // ok
        return e;
    }

    @Override
    public void borrar(Habilidades e) {
        // ok
    }

    @Override
    public Habilidades buscar(Integer id) {
        return this.lista.get(0);
    }

    @Override
    public List<Habilidades> listar() {
        return this.lista;
    }
    
}
