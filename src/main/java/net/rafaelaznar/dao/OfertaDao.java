/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.dao;

import net.rafaelaznar.bean.OfertaBean;
import net.rafaelaznar.helper.Conexion;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class OfertaDao extends GenericDaoImplementation<OfertaBean> {
  
    public OfertaDao() throws Exception {
        super(Conexion.getConection(),"oferta");
        oMysql.conexion(enumTipoConexion);
    }
    
}
