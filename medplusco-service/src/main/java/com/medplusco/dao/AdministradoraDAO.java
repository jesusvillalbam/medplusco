/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao;

import com.medplusco.dao.modelo.Administradora;
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
public interface AdministradoraDAO extends JpaRepository<Administradora, Serializable>{
    
    @Query("select adm from Administradora adm where adm.nit = :nit")
    Administradora findByNit(@Param("nit") String nit);
    
    @Query("select adm from Administradora adm where adm.codigo = :codigo")
    Administradora findByCodigo(@Param("codigo") String codigo);
        
    
}
