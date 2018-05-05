/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao;

import com.medplusco.dao.modelo.Medico;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Win 10
 */
@Repository
public interface MedicoDAO extends JpaRepository<Medico, Serializable>{
    
}
