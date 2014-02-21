/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.bean;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class ProvinciaBean {

    private Integer id = 0;
    private String nombrepro;

    public ProvinciaBean() {
    }

    public ProvinciaBean(Integer id) {
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
     * @return the nombrepro
     */
    public String getNombrepro() {
        return nombrepro;
    }

    /**
     * @param nombrepro the nombrepro to set
     */
    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }
}