/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Elsa Mellissa
 */
 
public class UsuarioDAO {
    
    private Connection con;
    
    public UsuarioDAO (Connection con){
        this.con = con;
    }
    
    public Optional<UsuarioVO> consultar (String cuenta) throws SQLException {
        String sql = "Select * from usuario where cuenta = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cuenta);
        ResultSet rs =ps.executeQuery();
        
        if (rs.next()){
            UsuarioVO usuarioVO = new UsuarioVO();
            usuarioVO.setIdUsuario (rs.getInt("id_usuario"));
            usuarioVO.setCuenta(rs.getString("cuenta"));
            usuarioVO.setNombre(rs.getString("nombre"));
            usuarioVO.setContrasena(rs.getString("contrasena"));
            usuarioVO.setTipo(rs.getString("tipo"));
            return Optional.of(usuarioVO);   
        }
        return Optional.empty();
    }
    
}
