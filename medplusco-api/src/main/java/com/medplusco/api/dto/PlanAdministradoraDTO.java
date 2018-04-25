/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.api.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jdvillalba
 */
public class PlanAdministradoraDTO {
    
    private Long id;
    private String nombre;
    private String codigo;
    private String contrato;
    private Date fechaInicial;
    private Date fechaFinal;
    private double valorContrato;
    private String activo;
    private Integer administradora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getAdministradora() {
        return administradora;
    }

    public void setAdministradora(Integer administradora) {
        this.administradora = administradora;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlanAdministradoraDTO other = (PlanAdministradoraDTO) obj;
        if (Double.doubleToLongBits(this.valorContrato) != Double.doubleToLongBits(other.valorContrato)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.contrato, other.contrato)) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicial, other.fechaInicial)) {
            return false;
        }
        if (!Objects.equals(this.fechaFinal, other.fechaFinal)) {
            return false;
        }
        if (!Objects.equals(this.administradora, other.administradora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlanAdministradoraDTO{" + "id=" + id + ", "
                + "nombre=" + nombre + ", "
                + "codigo=" + codigo + ", "
                + "contrato=" + contrato + ", "
                + "fechaInicial=" + fechaInicial + ", "
                + "fechaFinal=" + fechaFinal + ", "
                + "valorContrato=" + valorContrato + ", "
                + "activo=" + activo + ", "
                + "administradoraDTO=" + administradora + '}';
    }
    
    
    
}
