    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.servicio;

import com.medplusco.dao.modelo.Empresa;
import java.util.List;

/**
 *
 * @author Jdvillalba
 */
public interface EmpresaServicio {    
    
    public Empresa buscarEmpresa(Long id);
    
    public List<Empresa> buscarEmpresas();
    
    public Empresa  buscarEmpresaPorNit(String nit); 
    
    public void crearEmpresa(Empresa empresa);
    
    public void eliminarEmpresa(Long id);
    
    public void actualizarEmpresa(Empresa empresa);
    
}
