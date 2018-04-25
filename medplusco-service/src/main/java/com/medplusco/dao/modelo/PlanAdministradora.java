/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author Jdvillalba
 */
@Entity
@Table(name="PLANADM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlanAdministradora implements Serializable {
    
    @Id
    @Column(name="PA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="CODIGO")
    private String codigo;
    
    @Column(name="CONTRATO")
    private String contrato;
    
    @Column(name="FECHAINI")
    private Date fechaInicial;
    
    @Column(name="FECHAFIN")
    private Date fechaFinal;
    
    @Column(name="VALOR_CONTRATO")
    private double valorContrato;
    
    @Column(name="ACTIVO")
    private String activo;
    
    @Column(nullable = false, updatable = false)
    @CreatedDate
    @JsonIgnore
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    @JsonIgnore
    private Date updatedAt;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_ADMINISTRADORA")
    private Administradora idAdministradora;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Administradora getAdministradora() {
        return idAdministradora;
    }

    public void setAdministradora(Administradora idAdministradora) {
        this.idAdministradora = idAdministradora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.codigo);
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
        final PlanAdministradora other = (PlanAdministradora) obj;
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
        return true;
    }

    

    @Override
    public String toString() {
        return "PlanAdministradora{" + "id=" + id + ", "
                + "nombre=" + nombre + ", "
                + "codigo=" + codigo + ", "
                + "contrato=" + contrato + ", "
                + "fechaInicial=" + fechaInicial + ", "
                + "fechaFinal=" + fechaFinal + ", "
                + "valorContrato=" + valorContrato + ", "
                + "activo=" + activo + ", "
                + "createdAt=" + createdAt + ", "
                + "updatedAt=" + updatedAt + '}';
    }

    
}
