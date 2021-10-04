/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.RegistroVO;
import com.amna.easyparking.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author k_bet
 */
public class RegistroDAO {
    
    private Connection con;
    
    public RegistroDAO (Connection con){
        this.con = con;
    }
    
    public void insertar(RegistroVO registroVO) throws SQLException { //throws indica que el método puede lanzar una exepción
        //void no devuelve nada
        String sql = "Insert into registro (placa, fecha_ingreso, id_tipo_vehiculo, permanencia, tarifa, subtotal, iva, total, fecha_salida, id_usuario, id_puesto) values(?,?,?,?,?,?,?,?,?,?,?) returning id_registro";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, registroVO.getPlaca());
            ps.setString(2, registroVO.getFecha_ingreso());
            ps.setInt(3, registroVO.getId_tipo_vehiculo());
            ps.setInt(4, registroVO.getPermanencia());
            ps.setInt(5, registroVO.getTarifa());
            ps.setInt(6, registroVO.getSubtotal());
            ps.setInt(7, registroVO.getIva());
            ps.setInt(8, registroVO.getTotal());
            ps.setString(9, registroVO.getFecha_salida());
            ps.setInt(10, registroVO.getId_usuario());
            ps.setInt(11, registroVO.getId_puesto());                     
            
            ps.executeUpdate(); //devuelve cuantas filas modificó
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                registroVO.setId_registro(rs.getInt("id_registro"));
            }
        }
    }
    
    public Optional<RegistroVO> consultar (String placa) throws SQLException {
        String sql = "Select * from registro where placa = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, placa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    RegistroVO registroVO = new RegistroVO();
                    registroVO.setFecha_ingreso(rs.getString("fecha_ingreso"));
                    registroVO.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                    registroVO.setPermanencia(rs.getInt("permanencia"));
                    registroVO.setTarifa(rs.getInt("tarifa"));
                    registroVO.setSubtotal(rs.getInt("subtotal"));
                    registroVO.setIva(rs.getInt("iva"));
                    registroVO.setFecha_salida(rs.getString("fecha_salida"));
                    registroVO.setId_usuario(rs.getInt("id_usuario"));
                    registroVO.setId_puesto(rs.getInt("id_puesto"));
                    return Optional.of(registroVO);                 
                }
            }
        }
        return Optional.empty();
    }
    
    public void actualizar (RegistroVO registroVO)  throws SQLException {
        String sql= "Update registro set placa=?, fecha_ingreso=?, id_tipo_vehiculo=?, permanencia=?, tarifa=?, subtotal=?, iva=?, total=?, fecha_salida=?, id_usuario=?, id_puesto=? where id_registro=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, registroVO.getPlaca());
            ps.setString(2, registroVO.getFecha_ingreso());
            ps.setInt(3, registroVO.getId_tipo_vehiculo());
            ps.setInt(4, registroVO.getPermanencia());
            ps.setInt(5, registroVO.getTarifa());
            ps.setInt(6, registroVO.getSubtotal());
            ps.setInt(7, registroVO.getIva());
            ps.setInt(8, registroVO.getTotal());
            ps.setString(9, registroVO.getFecha_salida());
            ps.setInt(10, registroVO.getId_usuario());
            ps.setInt(11, registroVO.getId_puesto());
            ps.setInt(12, registroVO.getId_registro());
            ps.executeUpdate();
        } catch (SQLException excepcion){
            System.out.println("Ocurrió un error actualizando" + excepcion.getMessage());
        }
    }
    
}
