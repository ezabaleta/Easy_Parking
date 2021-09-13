/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.dao.TipoVehiculoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/easyparking";
    public static final String USER = "root";
    public static final String CLAVE = "";

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            con = Conexion.getConexion();
            TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO(con);
            tipoVehiculoDAO.listar().forEach(System.out::println);
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
    }
}
