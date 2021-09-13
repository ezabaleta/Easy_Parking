/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.TipoVehiculoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elsa Mellissa
 */
public class TipoVehiculoDAO {

    private Connection con;

    public TipoVehiculoDAO(Connection con) {
        this.con = con;
    }
    
    public List<TipoVehiculoVO> listar() throws SQLException {
        String sql = "Select * from tipo_vehiculo";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<TipoVehiculoVO> lista = new ArrayList<>();
        while(rs.next()){
            TipoVehiculoVO tipoVehiculoVO = new TipoVehiculoVO();
            tipoVehiculoVO.setIdTipoVehiculo(rs.getInt("id_tipo_vehiculo"));
            tipoVehiculoVO.setNombre(rs.getString("nombre"));
            lista.add(tipoVehiculoVO);
        }
        return lista;
    }
}
