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
@Table(name = "MEDICOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medico implements Serializable{
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private long id;
    
    @Column(name="TPOID")
    private String tipoIdentificacion;
    
    @Column(name="IDENTIFICACION")
    private String identificacionMedico;
    
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
    
    private String sexo;
    
    private String direccion;
    
    private String Telefono;
    
    private String celular;
    
    private String email;
    
    private String departamento;
    
    private String municipio;
    
    @Column(name="REGISTRO_MEDICO")
    private String registroMedico;
    
    private String firma;
    
    private String estado;
    
    @JsonIgnore
    @Column(name="CREATED_AT")
    private Date createdAt;
    
    @JsonIgnore
    @Column(name="UPDATED_AT")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IDEMPRESA")
    private Empresa empresa;

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

    public String getIdentificacionMedico() {
        return identificacionMedico;
    }

    public void setIdentificacionMedico(String identificacionMedico) {
        this.identificacionMedico = identificacionMedico;
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

    public String getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(String registroMedico) {
        this.registroMedico = registroMedico;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ","
                + " tipoIdentificacion=" + tipoIdentificacion + ","
                + " identificacionMedico=" + identificacionMedico + ","
                + " nombreCompleto=" + nombreCompleto + ","
                + " primerNombre=" + primerNombre + ","
                + " segundoNombre=" + segundoNombre + ","
                + " primerApellido=" + primerApellido + ","
                + " segundoApellido=" + segundoApellido + ","
                + " sexo=" + sexo + ","
                + " direccion=" + direccion + ","
                + " Telefono=" + Telefono + ","
                + " celular=" + celular + ","
                + " email=" + email + ","
                + " departamento=" + departamento + ","
                + " municipio=" + municipio + ","
                + " registroMedico=" + registroMedico + ","
                + " firma=" + firma + ","
                + " estado=" + estado + ","
                + " empresa=" + empresa + '}';
    }
    
    
}
