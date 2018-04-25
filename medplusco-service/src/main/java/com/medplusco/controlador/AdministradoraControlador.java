/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.controlador;

import com.medplusco.dao.modelo.Administradora;
import com.medplusco.servicio.AdministradoraServicio;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Win 10
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AdministradoraControlador {
    
    private static final Logger LOGGER = Logger.getLogger(AdministradoraControlador.class);
    
    @Autowired
    AdministradoraServicio administradoraServicio;
    
    @RequestMapping(value = "/Administradoras", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Administradora>> buscarAdministradoras() {
        
        List<Administradora> administradoras = administradoraServicio.buscarAdministradoras();
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarAdministradoras(): " +administradoras.size());
        }
        if (administradoras == null || administradoras.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(administradoras, HttpStatus.OK);
    }
    
    /**
     * Metodo para buscar administradora por ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/Administradora/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarAdministradora(@PathVariable Long id) {
        
        Administradora administradora = administradoraServicio.buscarEmpresa(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarAdministradora(): " +administradora);
        }
        if (administradora == null || !administradora.equals(administradora)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(administradora, HttpStatus.OK);
    }
    
    /**
     * Busqueda de administradora por Nit
     * @param nit
     * @return
     */
    @RequestMapping(value = "/Administradora/Nit/{nit}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarAdministradoraPorNit(@PathVariable String nit) {
        Administradora administradora = administradoraServicio.buscarAdministradoraPorNit(nit);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarAdministradoraPorNit(): " +administradora);
        }
        if (administradora == null || !administradora.equals(administradora)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(administradora, HttpStatus.OK);
    }
    
    /**
     * Metodo para crear administradora
     * @param adm
     * @param uriComponentsBuilder
     * @return
     */
    @RequestMapping(value = "/Administradora/Crear", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> crearAdministradora(@RequestBody Administradora adm, UriComponentsBuilder uriComponentsBuilder) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto crearAdministradora(): " +adm);
        }        
            administradoraServicio.crearAdministradora(adm);
            Administradora adm2 = administradoraServicio.buscarEmpresa(adm.getId());
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id de la Administradora creada " +adm2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/administradoras/{id}")
				.buildAndExpand(adm2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo Para Actualizar administradora
     * @param adm
     * @param uriComponentsBuilder
     * @param id
     * @return
     */
    @RequestMapping(value = "/Administradora/Actualizar/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> actualizarAdministradora(@RequestBody Administradora adm, 
                                                UriComponentsBuilder uriComponentsBuilder, 
                                                @PathVariable Long id) 
    {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto actualizarAdministradora() " +adm);
            LOGGER.info("Recibe id: " +id);
        }        
                Administradora adm2 = administradoraServicio.buscarEmpresa(id);
                adm.setId(adm2.getId());
                administradoraServicio.actualizarAdministradora(adm);
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id de la administradora actualizada " +adm2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/administradoras/{id}")
				.buildAndExpand(adm2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar administradora
     * @param id
     * @return Status.OK
     */
    @RequestMapping(value = "/Administradora/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> eliminarAdministradora(@PathVariable Long id) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto eliminarAdministradoras(): " +id);
        }
        administradoraServicio.eliminarAdministradora(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
