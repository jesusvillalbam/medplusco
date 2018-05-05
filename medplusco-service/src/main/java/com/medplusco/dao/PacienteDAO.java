/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao;

import com.medplusco.dao.modelo.Paciente;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Win 10
 */
@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Serializable>{

    @Query("select pa from Paciente pa where pa.identificacionPaciente = :identificacion")
    Paciente findByIdentificacionPaciente(@Param("identificacion") String identificacion);
    
}
