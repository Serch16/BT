/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.bean;

import java.util.Date;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class OfertaBean {

    private Integer id = 0;
    private String referencia = "";
    private Date fechaini;
    private Date fechafin;
    private Integer id_empresa = 0;
    private String puesto = "";
    private String categoria = "";
    private Integer vacantes = 0;
    private String descripcion = "";
    private String requisitos = "";
    private String funciones = "";
    private String experiencia = "";
    private String formacion = "";
    private Double salario = 0.0;
    private Integer id_contrato = 0;
    private String notas = "";

    public OfertaBean() {
    }

    public OfertaBean(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the fechaini
     */
    public Date getFechaini() {
        return fechaini;
    }

    /**
     * @param fechaini the fechaini to set
     */
    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    /**
     * @return the fechafin
     */
    public Date getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * @return the id_empresa
     */
    public Integer getId_empresa() {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the vacantes
     */
    public Integer getVacantes() {
        return vacantes;
    }

    /**
     * @param vacantes the vacantes to set
     */
    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the requisitos
     */
    public String getRequisitos() {
        return requisitos;
    }

    /**
     * @param requisitos the requisitos to set
     */
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * @return the funciones
     */
    public String getFunciones() {
        return funciones;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    /**
     * @return the experiencia
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the formacion
     */
    public String getFormacion() {
        return formacion;
    }

    /**
     * @param formacion the formacion to set
     */
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the id_contratos
     */
    public Integer getId_contrato() {
        return id_contrato;
    }

    /**
     * @param id_contratos the id_contratos to set
     */
    public void setId_contrato(Integer id_contratos) {
        this.id_contrato = id_contratos;
    }

    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }
}