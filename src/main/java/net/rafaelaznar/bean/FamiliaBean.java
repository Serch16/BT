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
public class FamiliaBean {

    private Integer id = 0;
    private String codfamilia = "";
    private String nombrefam = "";

    public FamiliaBean() {
    }

    public FamiliaBean(Integer id) {
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
     * @return the codfamilia
     */
    public String getCodfamilia() {
        return codfamilia;
    }

    /**
     * @param codfamilia the codfamilia to set
     */
    public void setCodfamilia(String codfamilia) {
        this.codfamilia = codfamilia;
    }

    /**
     * @return the nombrefam
     */
    public String getNombrefam() {
        return nombrefam;
    }

    /**
     * @param nombrefam the nombrefam to set
     */
    public void setNombrefam(String nombrefam) {
        this.nombrefam = nombrefam;
    }

}