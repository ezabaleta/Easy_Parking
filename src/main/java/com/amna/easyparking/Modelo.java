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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elsa Mellissa
 */
public class Modelo {

    public Optional<UsuarioVO> consultarUsuario(String cuenta) {

        Connection con = null;
        try {
            con = Conexion.getConexion();
            UsuarioDAO UsuarioDAO = new UsuarioDAO(con);
            return UsuarioDAO.consultar(cuenta);
            
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return Optional.empty();
    }

}
