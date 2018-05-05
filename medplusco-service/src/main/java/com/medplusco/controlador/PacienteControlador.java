/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.controlador;

import com.medplusco.dao.modelo.Paciente;
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
import com.medplusco.servicio.PacienteServicio;

/**
 *
 * @author JDVILLALBA
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PacienteControlador {
    
    private static final Logger LOGGER = Logger.getLogger(EmpresaControlador.class);
    
    @Autowired
    PacienteServicio pacienteServicio;
    
    @RequestMapping(value = "/Paciente/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id) {
        
        Paciente paciente = pacienteServicio.buscarPaciente(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarPaciente(): " +paciente+" con ID: "+ id);
        }
        if (paciente == null || !paciente.equals(paciente)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Paciente/Identifiacion/{identificacion}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarPacientePorIdentificacion(@PathVariable String identificacion) {
        
        Paciente paciente = pacienteServicio.buscarPacientePorIdentificacion(identificacion);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarPacientePorIdentificacion(): " +paciente);
        }
        if (paciente == null || !paciente.equals(paciente)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Paciente/Crear", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente,
            UriComponentsBuilder uriComponentsBuilder) {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto crearPaciente(): " +paciente);
        }        
            pacienteServicio.crearPaciente(paciente);
            Paciente pac = pacienteServicio.buscarPacientePorIdentificacion(
                    paciente.getIdentificacionPaciente());
		HttpHeaders headers = new HttpHeaders();
                LOGGER.info("Se obtiene el id del paciente creado " +pac.getIdentificacionPaciente());
		headers.setLocation(
				uriComponentsBuilder.path("/Paciente/{id}")
				.buildAndExpand(pac.getId())
				.toUri()
				);
                return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/Paciente/Actualizar/{id}", method = RequestMethod.PUT, 
            produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente, 
                                                UriComponentsBuilder uriComponentsBuilder, 
                                                @PathVariable Long id) 
    {
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto actualizarPaciente() " +paciente);
            LOGGER.info("Recibe id: " +id);
        }        
        Paciente pac = pacienteServicio.buscarPaciente(id);
        paciente.setId(pac.getId());
        pacienteServicio.crearPaciente(paciente);
            HttpHeaders headers = new HttpHeaders();
            LOGGER.info("Se obtiene el id del paciente actualizado " +pac.getId());
            headers.setLocation(
                            uriComponentsBuilder.path("/paciente/{id}")
                            .buildAndExpand(pac.getId())
                            .toUri()
                            );
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/Paciente/Eliminar/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto eliminarEmpresa(): " +id);
        }
        pacienteServicio.eliminarPaciente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
