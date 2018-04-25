/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao;

import com.medplusco.dao.modelo.Empresa;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Jdvillalba
 */
@Repository
public interface EmpresaDAO extends JpaRepository<Empresa, Serializable>{
        	
	@Query("select emp from Empresa emp where emp.nit = :nit")
        Empresa findByNit(@Param("nit") String nit);
        
}
