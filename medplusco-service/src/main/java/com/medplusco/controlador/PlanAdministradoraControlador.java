/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.controlador;


import com.medplusco.dao.modelo.PlanAdministradora;
import com.medplusco.servicio.PlanAdministradoraServicio;
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
 * @author Jdvillalba
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PlanAdministradoraControlador {
    
    private static final Logger LOGGER = Logger.getLogger(PlanAdministradoraControlador.class);
    
    @Autowired
    PlanAdministradoraServicio PlanAdministradoraServicio;
    
    /**
     * Metodo para buscar planes de administradoras por ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/PlanAdministradoras/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarPlanAdministradora(@PathVariable Long id) {
        
        PlanAdministradora planAdm = PlanAdministradoraServicio.buscarPlanAdministradora(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarPlanAdministradora(): " +planAdm);
        }
        if (planAdm == null || !planAdm.equals(planAdm)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(planAdm, HttpStatus.OK);
    }
    
    /**
     * Busqueda de planes de administadoras por codigo
     * @param codigo
     * @return
     */
    @RequestMapping(value = "/PlanAdministradoras/codigo/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarPlanAdministradoraPorCodigo(@PathVariable String codigo) {
        
        PlanAdministradora planAdm = PlanAdministradoraServicio.buscarPlanAdministradoraPorCodigo(codigo);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarPlanAdministradoraPorCodigo(): " +planAdm);
        }
        if (planAdm == null || !planAdm.equals(planAdm)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(planAdm, HttpStatus.OK);
    }
    
    /**
     * Metodo para crear planes de administradoras
     * @param planAdm
     * @param uriComponentsBuilder
     * @return
     */
    @RequestMapping(value = "/CrearPlanAdministradoras", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> crearPlanAdministradora(@RequestBody PlanAdministradora planAdm,
            UriComponentsBuilder uriComponentsBuilder) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto crearPlanAdministradora(): " +planAdm);
        }        
            PlanAdministradoraServicio.crearPlanAdministradora(planAdm);
            PlanAdministradora planAdm2 = PlanAdministradoraServicio.buscarPlanAdministradoraPorCodigo(planAdm.getCodigo());
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id del plan: " +planAdm2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/planAdministradoras/{id}")
				.buildAndExpand(planAdm2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo Para Actualizar empresa
     * @param planAdm
     * @param uriComponentsBuilder
     * @param id
     * @return
     */
    @RequestMapping(value = "/planAdministradoras/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> actualizarPlanAdministradora(@RequestBody PlanAdministradora planAdm, 
                                                UriComponentsBuilder uriComponentsBuilder, 
                                                @PathVariable Long id) 
    {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto actualizarPlanAdministradora() " +planAdm);
            LOGGER.info("Recibe id: " +id);
        }        
                PlanAdministradora planAdm2 = PlanAdministradoraServicio.buscarPlanAdministradora(id);
                planAdm.setId(planAdm2.getId());
                PlanAdministradoraServicio.actualizarPlanAdministradora(planAdm);
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id del plan: " +planAdm2.getId());
		headers.setLocation(
				uriComponentsBuilder.path("/planAdministradoras/{id}")
				.buildAndExpand(planAdm2.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo para eliminar empresa
     * @param id
     * @return Status.OK
     */
    @RequestMapping(value = "/planAdministradoras/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Void> eliminarPlanAdministradora(@PathVariable Long id) {
        
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto eliminarPlanAdministradora(): " +id);
        }
        PlanAdministradoraServicio.eliminarPlanAdministradora(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
