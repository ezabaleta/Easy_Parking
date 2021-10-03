/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking.dao;

import java.sql.Connection;

/**
 *
 * @author k_bet
 */
public class RegistroDAO {
    
    private Connection con;
    
    public RegistroDAO (Connection con){
        this.con = con;
    }
}
   
