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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Elsa Mellissa
 */
public class UsuarioDAO {

    private final Connection con;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public void insertar(UsuarioVO usuarioVO) throws SQLException { //throws indica que el método puede lanzar una exepción
        //void no devuelve nada
        // String sql = "Insert into usuario (nombre, tipo, cuenta, contrasena) values(?,?,?,?) returning id_usuario";
        String sql = "Insert into usuario (nombre, tipo, cuenta, contrasena) values(?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuarioVO.getNombre());
            ps.setString(2, usuarioVO.getTipo());
            ps.setString(3, usuarioVO.getCuenta());
            ps.setString(4, usuarioVO.getContrasena());
            ps.executeUpdate(); //devuelve cuantas filas modificó
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                usuarioVO.setIdUsuario(rs.getInt(1));
            }
        }
    }

    public void actualizar(UsuarioVO usuarioVO) throws SQLException { //throws indica que el método puede lanzar una exepción
        //void no devuelve nada
        String sql = "Update usuario set nombre = ?, tipo = ?, cuenta = ?, contrasena = ? where id_usuario = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuarioVO.getNombre());
            ps.setString(2, usuarioVO.getTipo());
            ps.setString(3, usuarioVO.getCuenta());
            ps.setString(4, usuarioVO.getContrasena());
            ps.setInt(5, usuarioVO.getIdUsuario());
            ps.executeUpdate(); //devuelve cuantas filas modificó
        }
    }

    public Optional<UsuarioVO> consultar(String cuenta) throws SQLException { //optional es una clase que indica que el objeto puede devolver o no un dato
        String sql = "Select * from usuario where cuenta = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cuenta);
            try (ResultSet rs = ps.executeQuery()) { // execute Query ejecuta la consulta
                if (rs.next()) {
                    UsuarioVO usuarioVO = new UsuarioVO();
                    usuarioVO.setIdUsuario(rs.getInt("id_usuario"));
                    usuarioVO.setCuenta(rs.getString("cuenta"));
                    usuarioVO.setNombre(rs.getString("nombre"));
                    usuarioVO.setContrasena(rs.getString("contrasena"));
                    usuarioVO.setTipo(rs.getString("tipo"));
                    return Optional.of(usuarioVO);
                }
            }
        }
        return Optional.empty();
    }

    public List<UsuarioVO> listar() throws SQLException {
        List<UsuarioVO> listaUsuarios = new ArrayList<>();
        String sql = "Select * from usuario;";
        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    UsuarioVO usuarioVO = new UsuarioVO();
                    usuarioVO.setIdUsuario(resultado.getInt("id_usuario"));
                    usuarioVO.setCuenta(resultado.getString("cuenta"));
                    usuarioVO.setNombre(resultado.getString("nombre"));
                    usuarioVO.setContrasena(resultado.getString("contrasena"));
                    usuarioVO.setTipo(resultado.getString("tipo"));
                    listaUsuarios.add(usuarioVO);
                }
            }
        }
        return listaUsuarios;
    }

    public void eliminar(int id) throws SQLException {
        String sql = "delete from usuario where id_usuario = ?";
        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }

}
