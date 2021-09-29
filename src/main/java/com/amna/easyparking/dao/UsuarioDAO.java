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
    
    public void actualizar (UsuarioVO usuarioVO) throws SQLException { //throws indica que el método puede lanzar una exepción
       //void no devuelve nada
        String sql = "Update usuario set nombre = ?, tipo = ?, cuenta = ?, contrasena = ? where id_usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuarioVO.getNombre());
        ps.setString(2, usuarioVO.getTipo());
        ps.setString(3, usuarioVO.getCuenta());
        ps.setString(4, usuarioVO.getContrasena());
        ps.setInt(5, usuarioVO.getIdUsuario());
        ps.executeUpdate(); //devuelve cuantas filas modificó
        
        
    }
    
    public Optional<UsuarioVO> consultar (String cuenta) throws SQLException { //optional es una clase que indica que el objeto puede devolver o no un dato
        String sql = "Select * from usuario where cuenta = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cuenta);
        ResultSet rs =ps.executeQuery();// execute Query ejecuta la consulta
        
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
