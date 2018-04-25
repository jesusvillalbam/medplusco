/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jdvillalba
 */
@Entity
@Table(name="ADMINISTRADORAS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Administradora implements Serializable {
    
    @Id
    @Column(name="ADM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name= "CODIGO")
    private String codigo;
    
    @Column(name= "NIT")
    private String nit;
    
    @Column(name= "DV")
    private String digitoVerificacion;
    
    @Column(name= "NOMBRE")
    private String nombreAdministradora;
    
    @Column(name= "DIRECCION")
    private String direccion;
    
    @Column(name= "TELEFONO")
    private String telefono;
    
    @Column(name= "REPRESENTANTE_LEGAL")
    private String representanteLegal;
    
    @Column(name= "ACTIVO")
    private String activo;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idAdministradora")
    private List<PlanAdministradora> planesAdministradoras;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNombreAdministradora() {
        return nombreAdministradora;
    }

    public void setNombreAdministradora(String nombreAdministradora) {
        this.nombreAdministradora = nombreAdministradora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public List<PlanAdministradora> getPlanesAdministradoras() {
        return planesAdministradoras;
    }

    public void setPlanesAdministradoras(List<PlanAdministradora> planesAdministradoras) {
        this.planesAdministradoras = planesAdministradoras;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.codigo);
        hash = 67 * hash + Objects.hashCode(this.nit);
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
        final Administradora other = (Administradora) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.digitoVerificacion, other.digitoVerificacion)) {
            return false;
        }
        if (!Objects.equals(this.nombreAdministradora, other.nombreAdministradora)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.representanteLegal, other.representanteLegal)) {
            return false;
        }
        if (!Objects.equals(this.activo, other.activo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Administradora{" + "id=" + id + ", "
                + "codigo=" + codigo + ", "
                + "nit=" + nit + ", "
                + "digitoVerificacion=" + digitoVerificacion + ", "
                + "nombreAdministradora=" + nombreAdministradora + ", "
                + "direccion=" + direccion + ", "
                + "telefono=" + telefono + ", "
                + "representanteLegal=" + representanteLegal + ", "
                + "activo=" + activo + '}';
    }


    
    
    
    
}
