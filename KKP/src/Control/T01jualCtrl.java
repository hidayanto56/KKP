/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.T01jual;
import java.io.File;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Thinkpad
 */
public class T01jualCtrl  extends T01jual{
    public DefaultTableModel getKodeTabung() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT kd_tabung FROM m03tabu");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
//            mdlCust.addColumn("M03_ID");
            mdlCust.addColumn("KODE");

            Object[] os = new Object[1];
            while (rs.next()) {
//                os[0] = rs.getString("m03_id");
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

            PreparedStatement stm = conn.connect("SELECT kdcust FROM m05cust");

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

            PreparedStatement stm = conn.connect("SELECT t01_id, tanggal,  \n" +
                "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                "m03.harga AS harga, m05.kdcust AS kdcust, \n" +
                "m05.nmcust AS nmcust, jumlah, t01.keterangan \n" +
                "FROM kkp.t01jual t01\n" +
                "INNER JOIN m03tabu m03\n" +
                "ON m03.kd_tabung = t01.kd_tabung\n" +
                "INNER JOIN m05cust m05\n" +
                "ON m05.kdcust = t01.kdcust;");

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
    
    public void tambahTransaksiJual() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.t01jual (tanggal, kd_tabung, kdcust, jumlah, keterangan)\n" +
                "VALUES (?,?,?,?,?);");
            
            stm.setDate(1,  new Date(getTanggal().getTime()));
            stm.setString(2, getKd_tabung());
            stm.setString(3, getKdcust());
            stm.setDouble(4, getJumlah());
            stm.setString(5, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Penjualan baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    public DefaultTableModel getCariTransaksiJual() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT t01_id, tanggal, \n" +
                    "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                    "m03.harga AS harga, m05.kdcust AS kdcust, \n" +
                    "m05.nmcust AS nmcust, jumlah, t01.keterangan \n" +
                    "FROM kkp.t01jual t01\n" +
                    "INNER JOIN m03tabu m03\n" +
                    "ON m03.kd_tabung = t01.kd_tabung\n" +
                    "INNER JOIN m05cust m05\n" +
                    "ON m05.kdcust = t01.kdcust\n" +
                    "WHERE tanggal = ? AND m03.kd_tabung LIKE ? AND m05.kdcust LIKE ?;"
                    );
            
            stm.setString(1, "%" + getTanggal()+ "%");
            stm.setString(2, "%" + getKd_tabung()+ "%");
            stm.setString(3, "%" + getKdcust()+ "%");
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
    
    public void printPenjualan() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_t01jual.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapusPenjualan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE FROM t01jual WHERE t01_id = ?;");
            
            stm.setLong(1, getT01_id());
//            stm.setString(2, getNmcust());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Penjualan Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editPenjualan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE  t01jual SET \n" +
                "tanggal = ?, \n" +
                "kd_tabung= ?, \n" +
                "kdcust= ?, \n" +
                "jumlah = ? \n" +
                "keterangan = ?\n" +
                "WHERE t01_id = ?;");
            stm.setDate(1, (Date) getTanggal());
            stm.setString(2, getKd_tabung());
            stm.setString(3, getKdcust());
            stm.setDouble(4, getJumlah());
            stm.setString(5, getKeterangan());
            stm.setLong(6, getT01_id());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Penjualan berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public DefaultTableModel getTabung(){
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT kd_tabung, jenis_tabung, harga FROM m03tabu WHERE kd_tabung = ?;");
            stm.setString(1, getKd_tabung());

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("HARGA");

            Object[] os = new Object[3];
            while (rs.next()) {
                os[0] = rs.getString("kd_tabung");
                os[1] = rs.getString("jenis_tabung");
                os[2] = rs.getString("harga");
                mdlCust.addRow(os);
            }
            
            
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getCustomer(){
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT kdcust, nmcust FROM m05cust WHERE kdcust = ?;");
            stm.setString(1, getKdcust());

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");

            Object[] os = new Object[2];
            while (rs.next()) {
                os[0] = rs.getString("kdcust");
                os[1] = rs.getString("nmcust");
                mdlCust.addRow(os);
            }
            
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T01jualCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
