/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dedicahya.latihanmvcjdbc.main;


import edu.dedicahya.latihanmvcjdbc.error.PelangganException;

import edu.dedicahya.latihanmvcjdbc.view.MainViewPelanggan;

import java.sql.SQLException;


/**
 *
 * Nama     : Dedi Cahya
 * Nim      : 10118901
 * Kelas    : IF11k
 * 
 */
public class PBO11K10118901LATIHANJDBCMVC {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws edu.dedicahya.latihanmvcjdbc.error.PelangganException
     */
    public static void main(String[] args) throws SQLException, PelangganException {
        MainViewPelanggan m = new MainViewPelanggan();
        m.setVisible(true);
        
    }
    
}
