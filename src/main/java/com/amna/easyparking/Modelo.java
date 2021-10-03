/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.dao.TipoVehiculoDAO;
import com.amna.easyparking.dao.UsuarioDAO;
import com.amna.easyparking.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elsa Mellissa
 */
public class Modelo {  // la clase modelo se encarga de la lógica del negocio, se agregan todos los métodos que se necesiten, indica al DAO lo que hay que hacer

    public Optional<UsuarioVO> consultarUsuario(String cuenta) {

        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.consultar(cuenta);//Consulto el usuario

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return Optional.empty();
    }

    public void actualizarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.actualizar(usuarioVO);//actualizo el usuario

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
    }

    public void insertarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.insertar(usuarioVO);//actualizo el usuario

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
    }
    
    public List<UsuarioVO> listarUsuario (){
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.listar();           

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        } 
        return null;
    }
    
    public void eliminarUsuario (UsuarioVO usuarioVO){
         Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.eliminar(usuarioVO.getIdUsuario());

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }       
    }
}
