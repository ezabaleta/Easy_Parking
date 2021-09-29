/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.vo;
import java.util.Date;
/**
 *
 * @author Nataly Durán S
 */
public class CierreVO {
    private int id_cierre;
    private Date fecha;
    private int subtotal;
    private int iva;
    private int total;
    private int id_usuario;

    public void setId_cierre(int id_cierre) {
        this.id_cierre = id_cierre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cierre() {
        return id_cierre;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getIva() {
        return iva;
    }

    public int getTotal() {
        return total;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    
}
