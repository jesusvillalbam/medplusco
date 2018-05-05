/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao;

import com.medplusco.dao.modelo.PlanAdministradora;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jdvillalba
 */
@Repository
public interface PlanAdministradoraDAO extends JpaRepository<PlanAdministradora, Serializable>{
    
}
