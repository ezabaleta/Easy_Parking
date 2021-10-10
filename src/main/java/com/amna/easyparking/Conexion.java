/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.dao.RegistroDAO;
import com.amna.easyparking.dao.TipoVehiculoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/easyparking";
    public static final String USER = "root";
    public static final String CLAVE = "";
    
     // Configuracion de la conexion a la base de datos 
    private String DB_driver = "";
    private String url = "";
    private String db = "";
    private String host = "";
    private String username = "";
    private String password = "";
    public Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private boolean local;

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

    
     //Cerrar la conexin
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Mtodo que devuelve un ResultSet de una consulta (tratamiento de SELECT)
    public ResultSet consultarBD(String sentencia) {
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sentencia);
        } catch (SQLException sqlex) {
        } catch (RuntimeException rex) {
        } catch (Exception ex) {
        }

        return rs;
    }

    // Mtodo que realiza un INSERT y devuelve TRUE si la operacin fue existosa
    public boolean insertarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    public boolean borrarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.execute(sentencia);
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    // Mtodo que realiza una operacin como UPDATE, DELETE, CREATE TABLE, entre otras
    // y devuelve TRUE si la operacin fue existosa
    public boolean actualizarBD(String sentencia) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sentencia);
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR RUTINA: " + sqlex);
            return false;
        }
        return true;
    }

    public boolean setAutoCommitBD(boolean parametro) {
        try {
            con.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error al configurar el autoCommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public void cerrarConexion() {
        closeConnection(con);
    }

    public boolean commitBD() {
        try {
            con.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer commit " + sqlex.getMessage());
            return false;
        }
    }

    public boolean rollbackBD() {
        try {
            con.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }

   /* public static void main(String[] args) {
        Conexion b = new Conexion();
        b.cerrarConexion();
    }
    */
       
    //Se prueba la conexión
    public static void main(String[] args) throws SQLException { 
        Connection con = null;
        try {
            con = Conexion.getConexion();
            TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO(con);
            tipoVehiculoDAO.listar().forEach(System.out::println);
            
            RegistroDAO registroDAO = new RegistroDAO(con);
            registroDAO.listar_registro().forEach(System.out::println);
            registroDAO.getClass();
             
            } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
    }
    
}
