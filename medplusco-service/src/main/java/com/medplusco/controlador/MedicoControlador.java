/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.controlador;

import com.medplusco.dao.modelo.Medico;
import com.medplusco.servicio.MedicoServicio;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Win 10
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MedicoControlador {
    
    private static final Logger LOGGER = Logger.getLogger(EmpresaControlador.class);
    
    @Autowired
    MedicoServicio medicoServicio;
    
    @RequestMapping(value = "/Medico/{id}",
            method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarMedico(@PathVariable Long id) {
        
        Medico medico = medicoServicio.buscarMedico(id);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarMedico(): " +medico+" con ID: "+ id);
        }
        if (medico == null || !medico.equals(medico)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Medico/Identifiacion/{identificacion}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> buscarMedicoPorIdentificacion(@PathVariable String identificacion) {
        
        Medico medico = medicoServicio.buscarMedicoPorIdentificacion(identificacion);
        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Ejecutanto medoto buscarMedicoPorIdentificacion(): " +identificacion);
        }
        if (medico == null || !medico.equals(medico)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }
}
