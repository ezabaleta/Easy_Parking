/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.RegistroVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.String;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

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
        String sql = "Insert into registro (placa, fecha_ingreso, id_tipo_vehiculo, permanencia, tarifa, subtotal, iva, total, fecha_salida, id_usuario, id_puesto) values(?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, registroVO.getPlaca());
            ps.setTimestamp(2, new java.sql.Timestamp(registroVO.getFecha_ingreso().getTime()));
            ps.setInt(3, registroVO.getId_tipo_vehiculo());
            ps.setInt(4, registroVO.getPermanencia());
            ps.setInt(5, registroVO.getTarifa());
            ps.setInt(6, registroVO.getSubtotal());
            ps.setInt(7, registroVO.getIva());
            ps.setInt(8, registroVO.getTotal());
            if (registroVO.getFecha_salida() != null) {
                ps.setTimestamp(9, new java.sql.Timestamp(registroVO.getFecha_salida().getTime()));
            } else {
                ps.setTimestamp(9, null);
            }
            ps.setInt(10, registroVO.getId_usuario());
            ps.setInt(11, registroVO.getId_puesto());                  
            System.out.println("SQL " + ps.toString());
            
            ps.executeUpdate(); //devuelve cuantas filas modificó
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                registroVO.setId_registro(rs.getInt(1));
            }
        }
    }
    
    public Optional<RegistroVO> consultar (String placa) throws SQLException {
        String sql = "Select r.*, p.plaza from registro r, puesto p where r.id_puesto = p.id_puesto and placa = ? and fecha_salida is null ";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, placa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    RegistroVO registroVO = new RegistroVO();
                    registroVO.setId_registro(rs.getInt("id_registro"));
                    registroVO.setPlaca(rs.getString("placa"));
                    Timestamp fechaIngreso = rs.getTimestamp("fecha_ingreso");
                    if (fechaIngreso != null) {
                        registroVO.setFecha_ingreso(new Date(fechaIngreso.getTime()));
                    }
                    registroVO.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                    registroVO.setPermanencia(rs.getInt("permanencia"));
                    registroVO.setTarifa(rs.getInt("tarifa"));
                    registroVO.setSubtotal(rs.getInt("subtotal"));
                    registroVO.setIva(rs.getInt("iva"));
                    Timestamp fechaSalida = rs.getTimestamp("fecha_ingreso");
                    if (fechaSalida != null) {
                        registroVO.setFecha_salida(new Date(fechaSalida.getTime()));
                    }
                    registroVO.setId_usuario(rs.getInt("id_usuario"));
                    registroVO.setId_puesto(rs.getInt("id_puesto"));
                    registroVO.setPlaza(rs.getString("plaza"));
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
            ps.setTimestamp(2, new java.sql.Timestamp(registroVO.getFecha_ingreso().getTime()));
            ps.setInt(3, registroVO.getId_tipo_vehiculo());
            ps.setInt(4, registroVO.getPermanencia());
            ps.setInt(5, registroVO.getTarifa());
            ps.setInt(6, registroVO.getSubtotal());
            ps.setInt(7, registroVO.getIva());
            ps.setInt(8, registroVO.getTotal());
            ps.setTimestamp(9,  new java.sql.Timestamp(registroVO.getFecha_salida().getTime()));
            ps.setInt(10, registroVO.getId_usuario());
            ps.setInt(11, registroVO.getId_puesto());
            ps.setInt(12, registroVO.getId_registro());
            ps.executeUpdate();
            System.out.println("SQL " + ps.toString());
        } catch (SQLException excepcion){
            System.out.println("Ocurrió un error actualizando " + excepcion.getMessage());
        }
    }

    
    public List<RegistroVO> listar_registro() throws SQLException {
        String sql = "Select * from registro";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<RegistroVO> lista1 = new ArrayList<>();
        while(rs.next()){
            RegistroVO registroVO = new RegistroVO();
            registroVO.setId_registro(rs.getInt("id_registro"));
            registroVO.setPlaca(rs.getString("placa"));
            registroVO.setFecha_ingreso(rs.getDate("fecha_ingreso"));
            registroVO.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
            registroVO.setPermanencia(rs.getInt("permanencia"));
            registroVO.setTarifa(rs.getInt("tarifa"));
            registroVO.setSubtotal(rs.getInt("subtotal"));
            registroVO.setIva(rs.getInt("iva"));
            registroVO.setTotal(rs.getInt("total"));
            registroVO.setFecha_salida(rs.getDate("fecha_salida"));
            registroVO.setId_usuario(rs.getInt("id_usuario"));
            registroVO.setId_puesto(rs.getInt("id_puesto"));
               
            lista1.add(registroVO);
        }
        return lista1;
    }

}
