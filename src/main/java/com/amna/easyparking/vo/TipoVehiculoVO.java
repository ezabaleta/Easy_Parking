/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.vo;

/**
 *
 * @author Elsa Mellissa
 */
public class TipoVehiculoVO {
    private int idTipoVehiculo;

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {                          //consultar los datos de Tipo vehículo
        return idTipoVehiculo + ":" + nombre;
    }
    
    
    
}
