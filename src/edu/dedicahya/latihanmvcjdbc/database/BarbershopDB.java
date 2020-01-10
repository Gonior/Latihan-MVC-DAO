/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dedicahya.latihanmvcjdbc.database;

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.dedicahya.latihanmvcjdbc.service.PelangganDao;
import edu.dedicahya.latihanmvcjdbc.impl.PelangganDaoImpl;
import java.sql.SQLException;

/**
 *
 * Nama     : Dedi Cahya
 * Nim      : 10118901
 * Kelas    : IF11k
 * 
 */
public class BarbershopDB {
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static PelangganDao getPelangganDao() throws SQLException {
        if (pelangganDao == null) {
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        return pelangganDao;
    }
    
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/barbershop");
            datasource.setUser("root");
            datasource.setPassword("");
            connection = (Connection) datasource.getConnection();
        }
        return connection;
    }
    
    
}
