/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio.impl;

import com.medplusco.dao.AdministradoraDAO;
import com.medplusco.dao.PlanAdministradoraDAO;
import com.medplusco.dao.modelo.PlanAdministradora;
import com.medplusco.dao.modelo.Administradora;
import com.medplusco.servicio.PlanAdministradoraServicio;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanAdministradoraServicioImpl implements PlanAdministradoraServicio {

    private static final Logger LOGGER = Logger.getLogger(PlanAdministradoraServicioImpl.class);
    
    @Autowired
    PlanAdministradoraDAO planAdministradoraDAO; 
    
    @Autowired
    AdministradoraDAO administradoraDAO;
    
    
    @Override
    public PlanAdministradora buscarPlanAdministradora(Long id) {
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Buscando Plan de Administradora por Id: " +id);    
        }
        PlanAdministradora planAdministradora = planAdministradoraDAO.findOne(id);
        return planAdministradora;
    }
    
    @Override
    public PlanAdministradora buscarPlanAdministradoraPorCodigo(String codigo) {
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Buscando Plan de Administradora por Codigo: " +codigo);    
        }
        PlanAdministradora planAdm = planAdministradoraDAO.findByCodigo(codigo);
        return planAdm;
    }
    
    @Override
    public void crearPlanAdministradora(PlanAdministradora planAdministradora) {
        Administradora adm = administradoraDAO.findByCodigo(planAdministradora.getCodigo());
        if (LOGGER.isInfoEnabled()){
        LOGGER.info("Creando Plan de Administradora: " +adm);    
        }
        planAdministradora.setAdministradora(adm);
        planAdministradoraDAO.save(planAdministradora);
        
    }

    @Override
    public void eliminarPlanAdministradora(Long id) {
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Eliminando Plan de Administradora: " +id);    
        }
        planAdministradoraDAO.delete(id);
    }

    @Override
    public void actualizarPlanAdministradora(PlanAdministradora planAdministradora) {
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Actualizando Plan de Administradora: " +planAdministradora);
        }
        planAdministradoraDAO.save(planAdministradora);
    }
}
