/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.dao;

import net.rafaelaznar.bean.FamiliaBean;
import net.rafaelaznar.helper.Conexion;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class FamiliaDao extends GenericDaoImplementation<FamiliaBean> {
  
    public FamiliaDao() throws Exception {
        super(Conexion.getConection(),"familia");
        oMysql.conexion(enumTipoConexion);
    }
    
}
