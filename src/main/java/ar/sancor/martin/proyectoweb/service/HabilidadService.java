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
public interface HabilidadService {
    public Habilidades crear(Habilidades e);
    public Habilidades actualizar(Habilidades e);
    public void borrar(Habilidades e);
    public Habilidades buscar(Integer id);
    public List<Habilidades> listar();
}
