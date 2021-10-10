/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.dao.CierreDAO;
import com.amna.easyparking.dao.PuestoDAO;
import com.amna.easyparking.dao.RegistroDAO;
import com.amna.easyparking.dao.TarifaDAO;
import com.amna.easyparking.dao.TipoVehiculoDAO;
import com.amna.easyparking.dao.UsuarioDAO;
import com.amna.easyparking.vo.CierreVO;
import com.amna.easyparking.vo.PuestoVO;
import com.amna.easyparking.vo.RegistroVO;
import com.amna.easyparking.vo.TarifaVO;
import com.amna.easyparking.vo.TipoVehiculoVO;
import com.amna.easyparking.vo.UsuarioVO;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Elsa Mellissa
 */
public class Modelo {

    static boolean actualizarUsuario(RegistroVO registroVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// la clase modelo se encarga de la lógica del negocio, se agregan todos los métodos que se necesiten, indica al DAO lo que hay que hacer

    public Optional<UsuarioVO> consultarUsuario(String cuenta) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.consultar(cuenta);//Consulto el usuario

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();
    }

    public boolean actualizarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.actualizar(usuarioVO);//actualizo el usuario
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public boolean insertarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.insertar(usuarioVO);//actualizo el usuario
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public List<UsuarioVO> listarUsuario() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            return usuarioDAO.listar();

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return Collections.EMPTY_LIST;//devuelve una lista vacía para evitar nullpointer exeption
    }

    public boolean eliminarUsuario(UsuarioVO usuarioVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            UsuarioDAO usuarioDAO = new UsuarioDAO(con); //instancio el DAO
            usuarioDAO.eliminar(usuarioVO.getIdUsuario());
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return false;
    }

    public boolean insertarRegistro(RegistroVO registroVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            RegistroDAO registroDAO = new RegistroDAO(con); //instancio el DAO
            registroDAO.insertar(registroVO);//actualizo el usuario
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public Optional<RegistroVO> consultarRegistro(String placa) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            RegistroDAO registroDAO = new RegistroDAO(con); //instancio el DAO
            return registroDAO.consultar(placa);//Consulto el registro

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();
    }

    public boolean actualizarRegistro(RegistroVO registroVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            RegistroDAO registroDAO = new RegistroDAO(con); //instancio el DAO
            registroDAO.actualizar(registroVO);//actualizo el registro
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public boolean insertarCierre(CierreVO cierreVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            cierreDAO.insertar(cierreVO);//actualizo el cierre
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public List<CierreVO> listarCierre() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            return cierreDAO.listar();

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return Collections.EMPTY_LIST;//devuelve una lista vacía para evitar nullpointer exeption
    }

    public boolean eliminarCierre(CierreVO cierreVO) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            CierreDAO cierreDAO = new CierreDAO(con); //instancio el DAO
            cierreDAO.eliminar(cierreVO.getId_cierre());
            return true;

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            if (con != null) {
                Conexion.close(con);
            }
        }
        return false;
    }

    public List<TipoVehiculoVO> listarTipoVehiculo() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO(con); //instancio el DAO
            return tipoVehiculoDAO.listar();

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return Collections.EMPTY_LIST;//devuelve una lista vacía para evitar nullpointer exeption
    }

    public Optional<TarifaVO> consultarTarifa() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            TarifaDAO tarifaDAO = new TarifaDAO(con); //instancio el DAO
            return tarifaDAO.consultar();//Consulto el registro

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();
    }

    public Optional<PuestoVO> consultarPuestoLibre() {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            PuestoDAO puestoDAO = new PuestoDAO(con); //instancio el DAO
            return puestoDAO.consultarLibre();//Consulto el registro

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(con);
        }
        return Optional.empty();
    }

    public boolean ocuparPuesto(int idPuesto) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            PuestoDAO puestoDAO = new PuestoDAO(con); //instancio el DAO
            PuestoVO puestoVO = new PuestoVO();
            puestoVO.setIdPuesto(idPuesto);
            puestoVO.setEstado("OCUPADO");
            puestoDAO.actualizarEstado(puestoVO);//actualizo el usuario
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public boolean liberarPuesto(int idPuesto) {
        Connection con = null;
        try {
            con = Conexion.getConexion(); //Se establece la conexión
            PuestoDAO puestoDAO = new PuestoDAO(con); //instancio el DAO
            PuestoVO puestoVO = new PuestoVO();
            puestoVO.setIdPuesto(idPuesto);
            puestoVO.setEstado("LIBRE");
            puestoDAO.actualizarEstado(puestoVO);//actualizo el usuario
            return true;// se agrega para trbajar con el front

        } catch (SQLException ex) {  //catch atrapa la exepción
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);//imprime la salida en consola
        } finally {
            Conexion.close(con);
        }
        return false;
    }

    public File generarReciboEntrada(RegistroVO registroVO) throws JRException, IOException {
        // InputStream is = getClass().getResourceAsStream("/resources/recibo_entrada.jrxml");
        InputStream is = getClass().getResourceAsStream("/recibo_entrada.jrxml");
        JasperReport report = JasperCompileManager.compileReport(is);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(registroVO));
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), dataSource);

        File file = File.createTempFile("registro_entrada_" + registroVO.getId_registro(), ".pdf");
        JasperExportManager.exportReportToPdfFile(print, file.getAbsolutePath());
        return file;
    }

    public File generarReciboSalida(RegistroVO registroVO) throws JRException, IOException {
        // InputStream is = getClass().getResourceAsStream("/resources/recibo_entrada.jrxml");
        InputStream is = getClass().getResourceAsStream("/recibo_salida.jrxml");
        JasperReport report = JasperCompileManager.compileReport(is);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(registroVO));
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), dataSource);

        File file = File.createTempFile("registro_salida_" + registroVO.getId_registro(), ".pdf");
        JasperExportManager.exportReportToPdfFile(print, file.getAbsolutePath());
        return file;
    }

    public static void main(String[] args) {
        RegistroVO reg = new RegistroVO();
        reg.setId_registro(101);
        reg.setFecha_ingreso(new Date());
        reg.setPlaca("FRP828");
        reg.setPlaza("FRP828--");
        Modelo modelo = new Modelo();
        try {
            File file = modelo.generarReciboEntrada(reg);
            System.out.println("OK " + file.getAbsolutePath());
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
