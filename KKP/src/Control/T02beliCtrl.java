/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.T02beli;
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
public class T02beliCtrl extends T02beli{
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
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getKodeSuplier() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT kdsup FROM m04supl");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");

            Object[] os = new Object[1];
            while (rs.next()) {
                os[0] = rs.getString("kdsup");
                mdlCust.addRow(os);
            }
            
            
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public DefaultTableModel getDaftarTransaksiBeli() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT t02_id, tanggal,  \n" +
                "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                "m03.harga AS harga, m04.kdsup AS kdsup, \n" +
                "m04.nmsup AS nmsup, jumlah, t02.keterangan \n" +
                "FROM kkp.t02beli t02\n" +
                "INNER JOIN m03tabu m03\n" +
                "ON m03.kd_tabung = t02.kd_tabung\n" +
                "INNER JOIN m04supl m04\n" +
                "ON m04.kdsup = t02.kdsupl;");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("HARGA");
            mdlCust.addColumn("SUPPLIER");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[9];
            while (rs.next()) {
                os[0] = rs.getString("t02_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("harga");
                os[5] = rs.getString("kdsup");
                os[6] = rs.getString("nmsup");
                os[7] = rs.getString("jumlah");
                os[8] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahTransaksiBeli() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.t02beli "
                    + "(tanggal, kd_tabung, kdsupl, jumlah, keterangan)\n" +
                        "VALUES (?,?,?,?,?);");
            
            stm.setDate(1, (Date) getTanggal());
            stm.setString(2, getKd_tabung());
            stm.setString(3, getKdsupl());
            stm.setDouble(4, getJumlah());
            stm.setString(5, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pembelian baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    public DefaultTableModel getCariTransaksiBeli() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("SELECT t02_id, tanggal,  \n" +
                    "m03.kd_tabung AS kd_tabung, m03.jenis_tabung AS jenis_tabung, \n" +
                    "m03.harga AS harga, m04.kdsup AS kdsup, \n" +
                    "m04.nmsup AS nmsup, jumlah, t02.keterangan \n" +
                    "FROM kkp.t02beli t02\n" +
                    "INNER JOIN m03tabu m03\n" +
                    "ON m03.kd_tabung = t02.kd_tabung\n" +
                    "INNER JOIN m04supl m04\n" +
                    "ON m04.kdsup = t02.kdsupl\n" +
                    "WHERE tanggal = ? AND m03.kd_tabung LIKE ? AND m04.kdsup LIKE ?;");
            
            stm.setString(1, "%" + getTanggal()+ "%");
            stm.setString(2, "%" + getKd_tabung()+ "%");
            stm.setString(3, "%" + getKdsupl()+ "%");
//            stm.setString(4, "%" + getSatuan() + "%");
//            stm.setString(5, "%" + getHarga() + "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("TANGGAL");
            mdlCust.addColumn("TABUNG");
            mdlCust.addColumn("JENIS");
            mdlCust.addColumn("HARGA");
            mdlCust.addColumn("SUPPLIER");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("JUMLAH");
            mdlCust.addColumn("KETERANGAN");
            
            Object[] os = new Object[9];
            while (rs.next()) {
                os[0] = rs.getString("t02_id");
                os[1] = rs.getString("tanggal");
                os[2] = rs.getString("kd_tabung");
                os[3] = rs.getString("jenis_tabung");
                os[4] = rs.getString("harga");
                os[5] = rs.getString("kdsup");
                os[6] = rs.getString("kdsup");
                os[7] = rs.getString("jumlah");
                os[8] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void printPembelian() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_t02beli.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hapusPembelian() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE FROM t02beli WHERE t02_id= ?;");
            
            stm.setLong(1, getT02_id());
//            stm.setString(2, getNmcust());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Pembelian Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editPembelian() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE  t02beli SET \n" +
                    "tanggal = ?, \n" +
                    "kd_tabung= ?, \n" +
                    "kdsupl= ?, \n" +
                    "jumlah = ? \n" +
                    "keterangan = ?\n" +
                    "WHERE t02_id = ?;");
            stm.setDate(1, (Date) getTanggal());
            stm.setString(2, getKd_tabung());
            stm.setString(3, getKdsupl());
            stm.setDouble(4, getJumlah());
            stm.setString(5, getKeterangan());
            stm.setLong(6, getT02_id());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pembelian berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(T02beliCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
