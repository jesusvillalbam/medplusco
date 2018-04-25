/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio;

import com.medplusco.dao.modelo.Administradora;
import java.util.List;

/**
 *
 * @author Jdvillalba
 */
public interface AdministradoraServicio {
    public Administradora buscarEmpresa(Long id);
    
    public List<Administradora> buscarAdministradoras();
    
    public Administradora  buscarAdministradoraPorNit(String nit);
    
    public void crearAdministradora(Administradora administradora);
    
    public void eliminarAdministradora(Long id);
    
    public void actualizarAdministradora(Administradora administradora);
}
