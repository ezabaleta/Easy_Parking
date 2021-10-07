/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.CierreVO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k_bet
 */
public class CierreDAO {
    
    private final Connection con;
    
    public CierreDAO (Connection con){
        this.con = con;   
    }
    
    public void insertar (CierreVO cierreVO) throws SQLException {
        String sql= "Insert into cierre (fecha, subtotal, iva, total, id_usuario) values (?,?,?,?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new Date(cierreVO.getFecha().getTime()));   // Date Sql, Date util
            ps.setInt(2, cierreVO.getSubtotal());
            ps.setInt(3, cierreVO.getIva());
            ps.setInt(4, cierreVO.getTotal());
            ps.setInt(5, cierreVO.getId_usuario());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                cierreVO.setId_cierre(rs.getInt(1));                
            }            
        }    
    }
    
    public List<CierreVO> listar () throws SQLException {
        List<CierreVO> listaCierres = new ArrayList<>();
        String sql = "Select * from cierre;";
        try (PreparedStatement sentencia =con.prepareStatement(sql)) {
            try (ResultSet resultado =sentencia.executeQuery()) {
                while (resultado.next()) {
                    CierreVO cierreVO = new CierreVO();
                    cierreVO.setId_cierre(resultado.getInt("id_cierre"));
                    cierreVO.setFecha(resultado.getDate("fecha"));
                    cierreVO.setSubtotal(resultado.getInt("subtotal"));
                    cierreVO.setIva(resultado.getInt("iva"));
                    cierreVO.setTotal(resultado.getInt("total"));
                    cierreVO.setId_usuario(resultado.getInt("id_usuario"));
                    listaCierres.add(cierreVO);
                }
            }
        } 
        return listaCierres;
    }
    
    public void eliminar (int id) throws SQLException {
        String sql = "delete from cierre where id_cierre =? ";
        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }
    
    
}


