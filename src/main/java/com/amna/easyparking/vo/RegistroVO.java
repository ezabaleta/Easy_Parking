/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.vo;

import com.amna.easyparking.Conexion;
import java.util.Date;


/**
 * @author Angelica
 */
public class RegistroVO {
    private int id_registro;
    private String placa;
    private Date fecha_ingreso;
    private int id_tipo_vehiculo;
    private int permanencia;
    private int tarifa;
    private int subtotal;
    private int iva;
    private int total;
    private Date fecha_salida;
    private int id_usuario;
    private int id_puesto;
    private String nombreTipoVehiculo;

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public int getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(int permanencia) {
        this.permanencia = permanencia;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    
    private String plaza;

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }
    
   public boolean guardarRegistro() {
        Conexion conexion = new Conexion();
        String sentencia = "INSERT INTO REGISTRO(id_registro, placa, fecha_ingreso, id_tipo_vehiculo, permanencia,tarifa,subtotal,iva,total,fecha_salida,id_usuario,id_puesto)"
                + " VALUES ('"+this.id_registro + "','" +this.placa+ "','" +this.fecha_ingreso+ "','" +this.id_tipo_vehiculo+ "','" +this.permanencia+ "','" +this.tarifa+ "','" +this.subtotal+ "','" +this.iva+"','" +this.total+ "','" +this.fecha_salida+ "','" +this.id_usuario+ "','" +this.id_puesto+ "'); ";    
            if (conexion.setAutoCommitBD(false)) {
            if (conexion.insertarBD(sentencia)) {
                conexion.commitBD();
                conexion.cerrarConexion();
                return true;
            } else {
                conexion.rollbackBD();
                conexion.cerrarConexion();
                return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }
  @Override
    public String toString() {                          //consultar los datos de registro
        return id_registro+ ":" +placa+ ":" +fecha_ingreso+ ":" +id_tipo_vehiculo+ ":" +permanencia+ ":" +tarifa+ ":" +subtotal+ ":" +iva+ ":" +total+ ":" +fecha_salida+ ":" +id_usuario+ ":" +id_puesto;

    }
          
}
