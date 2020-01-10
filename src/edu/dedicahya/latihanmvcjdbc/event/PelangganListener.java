/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dedicahya.latihanmvcjdbc.event;

import edu.dedicahya.latihanmvcjdbc.entity.Pelanggan;
import edu.dedicahya.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * Nama     : Dedi Cahya
 * Nim      : 10118901
 * Kelas    : IF11k
 * 
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    
    public void onInsert(Pelanggan pelanggan);
    
    public void onUpdate(Pelanggan pelanggan);
    
    public void onDelete();
    
}
