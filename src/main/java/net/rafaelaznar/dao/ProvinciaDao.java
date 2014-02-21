/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.dao;

import net.rafaelaznar.bean.ProvinciaBean;
import net.rafaelaznar.helper.Conexion;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class ProvinciaDao extends GenericDaoImplementation<ProvinciaBean> {
  
    public ProvinciaDao() throws Exception {
        super(Conexion.getConection(),"provincia");
        oMysql.conexion(enumTipoConexion);
    }
    
}
