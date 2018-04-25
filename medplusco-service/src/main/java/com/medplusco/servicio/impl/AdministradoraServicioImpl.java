/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio.impl;

import com.medplusco.dao.AdministradoraDAO;
import com.medplusco.dao.modelo.Administradora;
import com.medplusco.servicio.AdministradoraServicio;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradoraServicioImpl implements AdministradoraServicio {
    
    private static final Logger LOGGER = Logger.getLogger(AdministradoraServicioImpl.class);
    
    @Autowired
    AdministradoraDAO administradoraDao;

    @Override
    public Administradora buscarEmpresa(Long id) {
        Administradora administradora= administradoraDao.findOne(id);
        
        return administradora;
    }

    @Override
    public List<Administradora> buscarAdministradoras() {
        
        List<Administradora> administradoras = administradoraDao.findAll();
        return administradoras;
    }

    
    @Override
    public Administradora buscarAdministradoraPorNit(String nit) {
        Administradora administradora = administradoraDao.findByNit(nit);
        return administradora;
    }
    
    @Override
    public void crearAdministradora(Administradora administradora) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutando servicio crearAdministradora()");
        }
        administradoraDao.save(administradora);
    }

    @Override
    public void eliminarAdministradora(Long id) {
        administradoraDao.delete(id);
    }

    @Override
    public void actualizarAdministradora(Administradora administradora) {
        administradoraDao.save(administradora);
    }
    
}
