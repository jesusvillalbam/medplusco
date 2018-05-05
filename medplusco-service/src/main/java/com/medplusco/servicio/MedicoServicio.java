/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio;

import com.medplusco.dao.modelo.Medico;

/**
 *
 * @author Win 10
 */
public interface MedicoServicio {
    
    Medico buscarMedico(Long id);
    
    Medico buscarMedicoPorIdentificacion(String identificacion);     
    
    void crearMedico(Medico medico);       
    
    void eliminarMedico(Long id);
    
    void actualizarMedico(Medico medico);
}
