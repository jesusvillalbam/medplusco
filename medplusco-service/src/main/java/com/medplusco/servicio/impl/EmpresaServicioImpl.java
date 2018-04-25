/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio.impl;

import com.medplusco.dao.EmpresaDAO;
import com.medplusco.dao.modelo.Empresa;
import com.medplusco.servicio.EmpresaServicio;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServicioImpl implements EmpresaServicio {
    
    @Autowired
    EmpresaDAO empresaDao;
    
    private static final Logger LOGGER = Logger.getLogger(EmpresaServicioImpl.class);
    
    @Override
    public Empresa buscarEmpresa(Long id) {
        LOGGER.info("Ingresando al metodo buscarEmpresa ");
        LOGGER.info("Recibe parametro "+id);
        Empresa empresa = empresaDao.findOne(id);
        return empresa;
    }

    @Override
    public List<Empresa> buscarEmpresas() {
        LOGGER.info("Ingresando al metodo buscarEmpresa ");
        List<Empresa> empresa = empresaDao.findAll();
        return empresa;
    }
    
    @Override
    public void crearEmpresa(Empresa empresa) {
        LOGGER.info("Creando empresa datos: " +empresa);
        empresaDao.save(empresa);
    }
    
    @Override
    public void eliminarEmpresa(Long id) {
        empresaDao.delete(id);
    }

    @Override
    public void actualizarEmpresa(Empresa empresa) {
        empresaDao.save(empresa);
    }   

    @Override
    public Empresa buscarEmpresaPorNit(String nit) {
        Empresa empresa = empresaDao.findByNit(nit);
        return empresa;
    }
}
