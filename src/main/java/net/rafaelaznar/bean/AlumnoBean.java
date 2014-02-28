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
public class AlumnoBean {

    private Integer id = 0;
    private String expediente = "";
    private String nombre = "";
    private String apellido1 = "";
    private String apellido2 = "";
    private String nifnie = "";
    private String domicilio = "";
    private Integer cpostal = 0;
    private String localidad = "";
    private Integer id_provincia = 0;
    private Integer telefono = 0;
    private Integer movil = 0;
    private String email = "";
    private Date fechana;
    private String paisna = "";
    private Integer id_genero = 0;
    private String curriculum = "";
    private Boolean discapacidad = false;
    private Integer id_laboral = 0;
    private Integer id_civil = 0;
    private Boolean carnet = false;
    private Boolean vehiculo = false;
    private String password = "";

    public AlumnoBean() {
    }

    public AlumnoBean(Integer id) {
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
     * @return the expediente
     */
    public String getExpediente() {
        return expediente;
    }

    /**
     * @param expediente the expediente to set
     */
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the nifnie
     */
    public String getNifnie() {
        return nifnie;
    }

    /**
     * @param nifnie the nifnie to set
     */
    public void setNifnie(String nifnie) {
        this.nifnie = nifnie;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the cpostal
     */
    public Integer getCpostal() {
        return cpostal;
    }

    /**
     * @param cpostal the cpostal to set
     */
    public void setCpostal(Integer cpostal) {
        this.cpostal = cpostal;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the id_provincia
     */
    public Integer getId_provincia() {
        return id_provincia;
    }

    /**
     * @param id_provincia the id_provincia to set
     */
    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the movil
     */
    public Integer getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fechana
     */
    public Date getFechana() {
        return fechana;
    }

    /**
     * @param fechana the fechana to set
     */
    public void setFechana(Date fechana) {
        this.fechana = fechana;
    }

    /**
     * @return the paisna
     */
    public String getPaisna() {
        return paisna;
    }

    /**
     * @param paisna the paisna to set
     */
    public void setPaisna(String paisna) {
        this.paisna = paisna;
    }

    /**
     * @return the id_genero
     */
    public Integer getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    /**
     * @return the curriculum
     */
    public String getCurriculum() {
        return curriculum;
    }

    /**
     * @param curriculum the curriculum to set
     */
    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    /**
     * @return the discapacidad
     */
    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    /**
     * @param discapacidad the discapacidad to set
     */
    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * @return the id_laboral
     */
    public Integer getId_laboral() {
        return id_laboral;
    }

    /**
     * @param id_laboral the id_laboral to set
     */
    public void setId_laboral(Integer id_laboral) {
        this.id_laboral = id_laboral;
    }

    /**
     * @return the id_civil
     */
    public Integer getId_civil() {
        return id_civil;
    }

    /**
     * @param id_civil the id_civil to set
     */
    public void setId_civil(Integer id_civil) {
        this.id_civil = id_civil;
    }

    /**
     * @return the carnet
     */
    public Boolean getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(Boolean carnet) {
        this.carnet = carnet;
    }

    /**
     * @return the vehiculo
     */
    public Boolean getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Boolean vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}