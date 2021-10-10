/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import com.amna.easyparking.vo.PuestoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Elsa Mellissa
 */
public class PuestoDAO {

    private final Connection con;

    public PuestoDAO(Connection con) {
        this.con = con;
    }

    public void actualizarEstado(PuestoVO puestoVO) throws SQLException { //throws indica que el método puede lanzar una exepción
        //void no devuelve nada
        String sql = "Update puesto set estado = ? where id_puesto = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, puestoVO.getEstado());
            ps.setInt(2, puestoVO.getIdPuesto());
            ps.executeUpdate(); //devuelve cuantas filas modificó
        }
    }

    public Optional<PuestoVO> consultarLibre() throws SQLException { //optional es una clase que indica que el objeto puede devolver o no un dato
        String sql = "Select * from puesto where estado = 'LIBRE'";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) { // execute Query ejecuta la consulta
                if (rs.next()) {
                    PuestoVO puestoVO = new PuestoVO();
                    puestoVO.setIdPuesto(rs.getInt("id_puesto"));
                    puestoVO.setPlaza(rs.getString("plaza"));
                    puestoVO.setEstado(rs.getString("estado"));
                    return Optional.of(puestoVO);
                }
            }
        }
        return Optional.empty();
    }

}
