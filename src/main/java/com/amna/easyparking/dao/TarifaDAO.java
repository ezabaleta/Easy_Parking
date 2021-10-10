/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.TarifaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author k_bet
 */
public class TarifaDAO {
    
    private Connection con;
    
    public TarifaDAO (Connection con){
        this.con = con;
    }
    
    public Optional<TarifaVO> consultar () throws SQLException {
        String sql = "Select * from tarifa";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        
        if (rs.next()){
            TarifaVO tarifaVO = new TarifaVO();
            tarifaVO.setIdTarifa (rs.getInt("id_tarifa"));
            tarifaVO.setValorFraccion(rs.getInt("valor_fraccion"));
            return Optional.of(tarifaVO);   
        }
        return Optional.empty();
    }
    
}
