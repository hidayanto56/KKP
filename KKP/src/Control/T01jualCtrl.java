/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.T01jual;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thinkpad
 */
public class T01jualCtrl  extends T01jual{
    public DefaultTableModel getKodeTabung() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT `kd_tabung` FROM `m03tabu`");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");

            Object[] os = new Object[1];
            while (rs.next()) {
                os[0] = rs.getString("kd_tabung");
                mdlCust.addRow(os);
            }
            
            
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getKodeCustomer() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT `kdcust` FROM `m05cust`");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");

            Object[] os = new Object[1];
            while (rs.next()) {
                os[0] = rs.getString("kdcust");
                mdlCust.addRow(os);
            }
            
            
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getDaftarTransaksiJual() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT t01_id, tanggal, t01.m03_id, \n" +
                "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                "m03.harga AS harga, t01.m05_id, m05.kdcust AS kdcust, \n" +
                "m05.nmcust AS nmcust, jumlah, t01.keterangan \n" +
                "FROM kkp.t01jual t01\n" +
                "INNER JOIN m03tabu m03\n" +
                "ON m03.m03_id = t01.m03_id\n" +
                "INNER JOIN m05cust m05\n" +
                "ON m05.m05_id = t01.m05_id;");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("HARGA");
            mdlCust.addColumn("CUSTOMER");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[9];
            while (rs.next()) {
                os[0] = rs.getString("t01_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("harga");
                os[5] = rs.getString("kdcust");
                os[5] = rs.getString("nmcust");
                os[5] = rs.getString("jumlah");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    public void tambahTransaksiJual() {
//        try {
//            MySQLConn conn = new MySQLConn();
//            PreparedStatement stm = conn.connect("INSERT INTO kkp.t01jual (tanggal, m03_id, m05_id, jumlah, keterangan)\n" +
//                                "VALUES (?,?,?,?,?);");
//            
//            stm.setDate(1, (Date) getTanggal());
//            stm.setLong(2, Long.valueOf(getM03_id()));
//            stm.setString(3, getM05_id());
//            stm.setDouble(4, getJumlah());
//            stm.setString(5, getKeterangan());
//            
//            stm.executeUpdate();
//
//            JOptionPane.showMessageDialog(null,
//                    "Customer baru berhasil ditambahkan", "Berhasil",
//                    JOptionPane.INFORMATION_MESSAGE);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(t01.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null,
//                    ex.getMessage(), "Error",
//                    JOptionPane.INFORMATION_MESSAGE);
//            
//        }
//    }
    
    public DefaultTableModel getCariTransaksiJual() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT t01_id, tanggal, t01.m03_id, \n" +
                    "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                    "m03.harga AS harga, t01.m05_id, m05.kdcust AS kdcust, \n" +
                    "m05.nmcust AS nmcust, jumlah, t01.keterangan \n" +
                    "FROM kkp.t01jual t01\n" +
                    "INNER JOIN m03tabu m03\n" +
                    "ON m03.m03_id = t01.m03_id\n" +
                    "INNER JOIN m05cust m05\n" +
                    "ON m05.m05_id = t01.m05_id\n" +
                    "WHERE tanggal = ? AND m03.kd_tabung = ? AND m05.kdcust = ?;"
                    );
            
            stm.setString(1, "%" + getTanggal()+ "%");
            stm.setString(2, "%" + getM03tabu().getKd_tabung()+ "%");
            stm.setString(3, "%" + getM05cust().getKdcust()+ "%");
//            stm.setString(4, "%" + getSatuan() + "%");
//            stm.setString(5, "%" + getHarga() + "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("HARGA");
            mdlCust.addColumn("CUSTOMER");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[9];
            while (rs.next()) {
                os[0] = rs.getString("t01_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("harga");
                os[5] = rs.getString("kdcust");
                os[5] = rs.getString("nmcust");
                os[5] = rs.getString("jumlah");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
