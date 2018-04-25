/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.controlador;

import com.medplusco.dao.modelo.Empresa;
import com.medplusco.servicio.EmpresaServicio;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Jdvillalba
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmpresaControlador {
    
    private static final Logger LOGGER = Logger.getLogger(EmpresaControlador.class);
    
    @Autowired
    EmpresaServicio empresaServicio;
    
    @RequestMapping(value = "/Empresas", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Empresa>> buscarEmpresas() {
        
        List<Empresa> empresas = empresaServicio.buscarEmpresas();
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarEmpresas(): " +empresas);
        }
        if (empresas == null || empresas.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }
    
    /**
     * Metodo para buscar empresa por ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/Empresa/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarEmpresa(@PathVariable Long id) {
        
        Empresa empresa = empresaServicio.buscarEmpresa(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarEmpresa(): " +empresa);
        }
        if (empresa == null || !empresa.equals(empresa)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }
    
    /**
     * Busqueda de empresa por Nit
     * @param nit
     * @return
     */
    @RequestMapping(value = "/Empresa/Nit/{nit}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarEmpresaPorNit(@PathVariable String nit) {
        
        Empresa empresa = empresaServicio.buscarEmpresaPorNit(nit);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarEmpresaPorNit(): " +empresa);
        }
        if (empresa == null || !empresa.equals(empresa)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }
    
    /**
     * Metodo para crear empresa
     * @param emp
     * @param uriComponentsBuilder
     * @return
     */
    @RequestMapping(value = "/Empresa/Crear", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> crearEmpresa(@RequestBody Empresa emp, UriComponentsBuilder uriComponentsBuilder) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto crearEmpresa(): " +emp);
        }        
            empresaServicio.crearEmpresa(emp);
            Empresa emp2 = empresaServicio.buscarEmpresaPorNit(emp.getNit());
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id de la empresa creada " +emp2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/empresas/{id}")
				.buildAndExpand(emp2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo Para Actualizar empresa
     * @param emp
     * @param uriComponentsBuilder
     * @param id
     * @return
     */
    @RequestMapping(value = "/Empresa/Actualizar/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> actualizarEmpresa(@RequestBody Empresa emp, 
                                                UriComponentsBuilder uriComponentsBuilder, 
                                                @PathVariable Long id) 
    {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto actualizarEmpresa() " +emp);
            LOGGER.info("Recibe id: " +id);
        }        
                Empresa emp2 = empresaServicio.buscarEmpresa(id);
                emp.setId(emp2.getId());
                empresaServicio.actualizarEmpresa(emp);
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id de la empresa actualizada " +emp2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/empresas/{id}")
				.buildAndExpand(emp2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar empresa
     * @param id
     * @return Status.OK
     */
    @RequestMapping(value = "/Empresa/Eliminar/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable String id) {
        
        Long idempresa = Long.parseLong(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto eliminarEmpresa(): " +id);
        }
        empresaServicio.eliminarEmpresa(idempresa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
