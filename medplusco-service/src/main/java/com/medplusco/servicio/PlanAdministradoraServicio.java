/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio;

import com.medplusco.dao.modelo.PlanAdministradora;

/**
 *
 * @author Jdvillalba
 */
public interface PlanAdministradoraServicio {
    
    public PlanAdministradora buscarPlanAdministradora(Long id);
    
    public void crearPlanAdministradora(PlanAdministradora PlanAdministradora);       
    
    public void eliminarPlanAdministradora(Long id);
    
    public void actualizarPlanAdministradora(PlanAdministradora PlanAdministradora);
}
