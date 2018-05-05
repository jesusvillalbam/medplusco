/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medplusco.dao.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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

/**
 *
 * @author JDVILLALBA
 */
@Entity
@Table(name = "PACIENTES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente implements Serializable {
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;
    
    @Column(name="TPOID")
    private String tipoIdentificacion;
    
    @Column(name="PID")
    private String identificacionPaciente;
    
    @Column(name="NOMBRE")
    private String nombreCompleto;
    
    @Column(name="PPNOMBRE")
    private String primerNombre;
    
    @Column(name="PSNOMBRE")
    private String segundoNombre;
    
    @Column(name="PPAPELLIDO")
    private String primerApellido;
    
    @Column(name="PSAPELLIDO")
    private String segundoApellido;
    
    @Column(name="PROFESION")
    private String especialidad;
    
    @Column(name="FECHANAC")
    private LocalDate fechaNacimiento;
    
    @Column(name="SEXO")
    private String sexo;
    
    @Column(name="DIRECCION")
    private String direccion;
    
    @Column(name="TELEFONO")
    private String Telefono;
    
    @Column(name="CELULAR")
    private String celular;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="ESTADO_CIVIL")
    private String estadoCivil;
    
    @Column(name="REGIMEN")
    private String regimen;
    
    @Column(name="ZONA")
    private String zona;
    
    @Column(name="DEPARTAMENTO")
    private String departamento;
    
    @Column(name="MUNICIPIO")
    private String municipio;
    
    @Column(name="RESPONSABLE")
    private String responsable;
    
    @Column(name="TEL_RESPONSABLE")
    private String telefonoResponsable;
    
    @Column(name="ACOMPANANTE")
    private String acompanante;
    
    @Column(name="TEL_ACOMPANANTE")
    private String telefonoAcompanante;
    
    @Column(name="SANGRE")
    private String tipoSangre;
    
    @Column(name="ETNIA")
    private String etnia;
    
    @Column(name="ESTADO")
    private String estado;
    
    @JsonIgnore
    @Column(name="CREATED_AT")
    private Date createdAt;
    
    @JsonIgnore
    @Column(name="UPDATED_AT")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IDADMINISTRADORA")
    private Administradora administradora;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacionPaciente() {
        return identificacionPaciente;
    }

    public void setIdentificacionPaciente(String identificacionPaciente) {
        this.identificacionPaciente = identificacionPaciente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    public String getAcompanante() {
        return acompanante;
    }

    public void setAcompanante(String acompanante) {
        this.acompanante = acompanante;
    }

    public String getTelefonoAcompanante() {
        return telefonoAcompanante;
    }

    public void setTelefonoAcompanante(String telefonoAcompanante) {
        this.telefonoAcompanante = telefonoAcompanante;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        return administradora;
    }

    public void setAdministradora(Administradora administradora) {
        this.administradora = administradora;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + Objects.hashCode(this.tipoIdentificacion);
        hash = 31 * hash + Objects.hashCode(this.identificacionPaciente);
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
        final Paciente other = (Paciente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tipoIdentificacion, other.tipoIdentificacion)) {
            return false;
        }
        if (!Objects.equals(this.identificacionPaciente, other.identificacionPaciente)) {
            return false;
        }
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.primerNombre, other.primerNombre)) {
            return false;
        }
        if (!Objects.equals(this.segundoNombre, other.segundoNombre)) {
            return false;
        }
        if (!Objects.equals(this.primerApellido, other.primerApellido)) {
            return false;
        }
        if (!Objects.equals(this.segundoApellido, other.segundoApellido)) {
            return false;
        }
        if (!Objects.equals(this.especialidad, other.especialidad)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.estadoCivil, other.estadoCivil)) {
            return false;
        }
        if (!Objects.equals(this.regimen, other.regimen)) {
            return false;
        }
        if (!Objects.equals(this.zona, other.zona)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (!Objects.equals(this.responsable, other.responsable)) {
            return false;
        }
        if (!Objects.equals(this.telefonoResponsable, other.telefonoResponsable)) {
            return false;
        }
        if (!Objects.equals(this.acompanante, other.acompanante)) {
            return false;
        }
        if (!Objects.equals(this.telefonoAcompanante, other.telefonoAcompanante)) {
            return false;
        }
        if (!Objects.equals(this.tipoSangre, other.tipoSangre)) {
            return false;
        }
        if (!Objects.equals(this.etnia, other.etnia)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Paciente{" + "id=" + id 
                + ", tipoIdentificacion=" + tipoIdentificacion 
                + ", identificacionPaciente=" + identificacionPaciente 
                + ", nombreCompleto=" + nombreCompleto 
                + ", primerNombre=" + primerNombre 
                + ", segundoNombre=" + segundoNombre 
                + ", primerApellido=" + primerApellido 
                + ", segundoApellido=" + segundoApellido 
                + ", especialidad=" + especialidad 
                + ", fechaNacimiento=" + fechaNacimiento 
                + ", sexo=" + sexo 
                + ", direccion=" + direccion 
                + ", Telefono=" + Telefono 
                + ", celular=" + celular 
                + ", email=" + email 
                + ", estadoCivil=" + estadoCivil 
                + ", regimen=" + regimen 
                + ", zona=" + zona 
                + ", departamento=" + departamento 
                + ", municipio=" + municipio 
                + ", responsable=" + responsable 
                + ", telefonoResponsable=" + telefonoResponsable 
                + ", acompanante=" + acompanante 
                + ", telefonoAcompanante=" + telefonoAcompanante 
                + ", tipoSangre=" + tipoSangre 
                + ", etnia=" + etnia 
                + ", estado=" + estado 
                + ", createdAt=" + createdAt 
                + ", updatedAt=" + updatedAt +  '}';
    }

    
}
