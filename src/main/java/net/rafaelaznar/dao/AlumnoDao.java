/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.rafaelaznar.dao;

import net.rafaelaznar.bean.AlumnoBean;
import net.rafaelaznar.helper.Conexion;

/**
 *
 * @author Sergio Martín Tárraga
 * @version 1.0v
 */
public class AlumnoDao extends GenericDaoImplementation<AlumnoBean> {
  
    public AlumnoDao() throws Exception {
        super(Conexion.getConection(),"alumno");
        oMysql.conexion(enumTipoConexion);
    }
    
}
