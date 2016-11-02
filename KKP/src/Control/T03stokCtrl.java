/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.T03stok;
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
public class T03stokCtrl extends T03stok{
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
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getDaftarStok() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT t03_id, \n" +
                    "tanggal,  \n" +
                    "m03.kd_tabung AS kd_tabung, \n" +
                    "m03.jenis_tabung AS jenis_tabung, \n" +
                    "jumlah, \n" +
                    "t03.keterangan \n" +
                    "FROM kkp.t03stok t03\n" +
                    "INNER JOIN m03tabu m03\n" +
                    "ON m03.kd_tabung = t03.kd_tabung;");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[6];
            while (rs.next()) {
                os[0] = rs.getString("t01_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("jumlah");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahStok() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.t03stok (tanggal, \n" +
                    "kd_tabung, \n" +
                    "jumlah, \n" +
                    "keterangan)\n" +
                    "VALUES (?,?,?,?,?);");
            
            stm.setDate(1, (Date) getTanggal());
            stm.setString(2, getKd_tabung());
            stm.setString(3, getKd_tabung());
            stm.setDouble(4, getJumlah());
            stm.setString(5, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Stok baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    public DefaultTableModel getCariStok() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("SELECT t03_id, \n" +
                "tanggal,  \n" +
                "m03.kd_tabung AS kd_tabung, \n" +
                "m03.jenis_tabung AS jenis_tabung, \n" +
                "jumlah, \n" +
                "t03.keterangan \n" +
                "FROM kkp.t03stok t03\n" +
                "INNER JOIN m03tabu m03\n" +
                "ON m03.kd_tabung = t03.kd_tabung\n" +
                "WHERE tanggal = ? \n" +
                "AND m03.kd_tabung LIKE ? ;");
            
            stm.setString(1, "%" + getTanggal()+ "%");
            stm.setString(2, "%" + getKd_tabung()+ "%");
//            stm.setString(3, "%" + getKdcust()+ "%");
//            stm.setString(4, "%" + getSatuan() + "%");
//            stm.setString(5, "%" + getHarga() + "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[6];
            while (rs.next()) {
                os[0] = rs.getString("t01_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("jumlah");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void printStok() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_t03stok.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapusStok() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE FROM t03stok WHERE t03_id= ?;");
            
            stm.setLong(1, getT03_id());
//            stm.setString(2, getNmcust());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Stok Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editStok() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE  t03stok SET \n" +
                    "tanggal = ?, \n" +
                    "kd_tabung= ?, \n" +
                    "jumlah = ? \n" +
                    "keterangan = ?\n" +
                    "WHERE t03_id = ?;");
            stm.setDate(1, (Date) getTanggal());
            stm.setString(2, getKd_tabung());
            stm.setDouble(3, getJumlah());
            stm.setString(4, getKeterangan());
            stm.setLong(5, getT03_id());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Stok berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T03stokCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
