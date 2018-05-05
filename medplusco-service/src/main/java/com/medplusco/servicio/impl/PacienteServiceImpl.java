/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio.impl;

import com.medplusco.dao.PacienteDAO;
import com.medplusco.dao.modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medplusco.servicio.PacienteServicio;


@Service
public class PacienteServiceImpl implements PacienteServicio {
    
    @Autowired
    PacienteDAO pacienteDAO;
    
    @Override
    public Paciente buscarPaciente(Long id) {
        Paciente paciente = pacienteDAO.findOne(id);
        return paciente;
    }

    @Override
    public Paciente buscarPacientePorIdentificacion(String identificacion) {
        Paciente paciente = pacienteDAO.findByIdentificacionPaciente(identificacion);
        return paciente;
    }

    @Override
    public void crearPaciente(Paciente paciente) {
        pacienteDAO.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteDAO.delete(id);
    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        pacienteDAO.save(paciente);
    }
    
}
