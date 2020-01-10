/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dedicahya.latihanmvcjdbc.impl;

import java.sql.Connection;
import edu.dedicahya.latihanmvcjdbc.entity.Pelanggan;
import edu.dedicahya.latihanmvcjdbc.error.PelangganException;
import edu.dedicahya.latihanmvcjdbc.service.PelangganDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Nama     : Dedi Cahya
 * Nim      : 10118901
 * Kelas    : IF11k
 * 
 */

public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA, ALAMAT, TELEPON, EMAIL) VALUES (?, ?, ?, ?)";
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA = ?, ALAMAT=?, TELEPON=?, EMAIL=? WHERE ID=?";
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";
    private final String selectAll = "SELECT * FROM PELANGGAN";
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        
        PreparedStatement st = null;
        
        try {
            connection.setAutoCommit(false);
            st = connection.prepareStatement(insertPelanggan, st.RETURN_GENERATED_KEYS);
            st.setString(1, pelanggan.getNama());
            st.setString(2, pelanggan.getAlamat());
            st.setString(3, pelanggan.getTelepon());
            st.setString(4, pelanggan.getEmail());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()) {
                pelanggan.setId(rs.getInt(1));
            }
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement(updatePelanggan);
            st.setString(1, pelanggan.getNama());
            st.setString(2, pelanggan.getAlamat());
            st.setString(3, pelanggan.getTelepon());
            st.setString(4, pelanggan.getEmail());
            st.setInt(5, pelanggan.getId());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void deletePelanggan(int id) throws PelangganException {
           PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement(deletePelanggan);
            st.setInt(1, id);

            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(int id) throws PelangganException {
          PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement(getById);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            Pelanggan pelanggan = null;
            if (rs.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(rs.getInt("ID"));
                pelanggan.setNama(rs.getString("NAMA"));
                pelanggan.setEmail(rs.getString("EMAIL"));
                pelanggan.setTelepon(rs.getString("TELEPON"));
                pelanggan.setAlamat(rs.getString("ALAMAT"));
            } else {
                throw new PelangganException("Pelanggan dengan id "+id+" tidak Ditemukan");
            }
        return pelanggan;    
            
        } catch (SQLException e) {
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
        
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
            PreparedStatement st = null;
        
        try {
            st = connection.prepareStatement(getByEmail);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            Pelanggan pelanggan = null;
            if (rs.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(rs.getInt("ID"));
                pelanggan.setNama(rs.getString("NAMA"));
                pelanggan.setEmail(rs.getString("EMAIL"));
                pelanggan.setTelepon(rs.getString("TELEPON"));
                pelanggan.setAlamat(rs.getString("ALAMAT"));
            } else {
                throw new PelangganException("Pelanggan dengan id "+email+" tidak Ditemukan");
            }
        return pelanggan;    
            
        } catch (SQLException e) {
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement st = null;
         List<Pelanggan> list = new ArrayList<>();
        
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Pelanggan pelanggan = null;
            while (rs.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(rs.getInt("ID"));
                pelanggan.setNama(rs.getString("NAMA"));
                pelanggan.setEmail(rs.getString("EMAIL"));
                pelanggan.setTelepon(rs.getString("TELEPON"));
                pelanggan.setAlamat(rs.getString("ALAMAT"));
                
                list.add(pelanggan);
            }
            return list;
            
        } catch (SQLException e) {
            throw new PelangganException(e.getMessage());
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
}
