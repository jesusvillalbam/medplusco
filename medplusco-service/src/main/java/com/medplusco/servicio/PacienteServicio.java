/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio;

import com.medplusco.dao.modelo.Paciente;

/**
 *
 * @author Win 10
 */
public interface PacienteServicio {
    
    Paciente buscarPaciente(Long id);
    
    Paciente buscarPacientePorIdentificacion(String identificacion);     
    
    void crearPaciente(Paciente paciente);       
    
    void eliminarPaciente(Long id);
    
    void actualizarPaciente(Paciente paciente);
}
