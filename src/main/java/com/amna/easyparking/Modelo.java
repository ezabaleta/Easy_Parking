/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.dao.CierreDAO;
import com.amna.easyparking.dao.RegistroDAO;
import com.amna.easyparking.dao.UsuarioDAO;
import com.amna.easyparking.vo.CierreVO;
import com.amna.easyparking.vo.RegistroVO;
import com.amna.easyparking.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elsa Mellissa
 */
public class Modelo {  

    static boolean actualizarUsuario(RegistroVO registroVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// la clase modelo se encarga de la lógica del negocio, se agregan todos los métodos que se necesiten, indica al DAO lo que hay que hacer

    public Optional<UsuarioVO> consultarUsuario(String cuenta) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.consultar(cuenta);//Consulto el usuario

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();
    }

    public boolean actualizarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.actualizar(usuarioVO);//actualizo el usuario
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public boolean insertarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.insertar(usuarioVO);//actualizo el usuario
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public List<UsuarioVO> listarUsuario() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.listar();

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return Collections.EMPTY_LIST;//devuelve una lista vacía para evitar nullpointer exeption
    }

    public boolean eliminarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.eliminar(usuarioVO.getIdUsuario());
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return false;
    }
    
    public boolean insertarRegistro(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.insertar(usuarioVO);//actualizo el usuario
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }
    public Optional<RegistroVO> consultarRegistro(String placa) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            RegistroDAO registroDAO = new RegistroDAO(con); //instancio el DAO
            return registroDAO.consultar(placa);//Consulto el registro

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();       
    }
    
    
    
    public boolean actualizarRegistro (RegistroVO registroVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            RegistroDAO registroDAO = new RegistroDAO(con); //instancio el DAO
            registroDAO.actualizar(registroVO);//actualizo el registro
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }
    
    public boolean insertarCierre(CierreVO cierreVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            cierreDAO.insertar(cierreVO);//actualizo el cierre
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }
    
    public List<CierreVO> listarCierre() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            return cierreDAO.listar();

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return Collections.EMPTY_LIST;//devuelve una lista vacía para evitar nullpointer exeption
    }
    
    public boolean eliminarCierre (CierreVO cierreVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            cierreDAO.eliminar(cierreVO.getId_cierre());
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return false;
    }
    
}
