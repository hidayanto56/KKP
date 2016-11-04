/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M04supl;
import java.io.File;
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
public class M04suplCtrl extends M04supl{
    public DefaultTableModel getDaftarSupplier() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  kdsup  ,\n"
                    + "  nmsup,\n"
                    + "  alamat,\n"
                    + "  kota, \n"
                    + "  telp, \n"
                    + "  keterangan \n"
                    + "FROM\n"
                    + "  kkp.m04supl");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("ALAMAT");
            mdlCust.addColumn("KOTA");
            mdlCust.addColumn("TELEPON");
            mdlCust.addColumn("KETERANGAN");

            Object[] os = new Object[6];
            while (rs.next()) {
                os[0] = rs.getString("kdsup");
                os[1] = rs.getString("nmsup");
                os[2] = rs.getString("alamat");
                os[3] = rs.getString("kota");
                os[4] = rs.getString("telp");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahSupplier() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.m04supl (\n"
                    + "  kdsup,\n"
                    + "  nmsup,\n"
                    + "  alamat,\n"
                    + "  kota,\n"
                    + "  telp,\n"
                    + "  keterangan\n"
                    + ") \n"
                    + "VALUES ( ?,?,?,?,?,?) ;");
            stm.setString(1, getKdsup());
            stm.setString(2, getNmsup());
            stm.setString(3, getAlamat());
            stm.setString(4, getKota());
            stm.setString(5, getTelp());
            stm.setString(6, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Supplier baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
     
     public void editSupplier() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE \n"
                    + "  kkp.m04supl \n"
                    + "SET\n"
                    + "  alamat= ?,\n"
                    + "  kota = ?,\n"
                    + "  telp= ?,\n"
                    + "  keterangan = ?\n"
                    + "WHERE kdsup = ? \n"
                    + "  AND nmsup= ?");
            stm.setString(1, getAlamat());
            stm.setString(2, getKota());
            stm.setString(3, getTelp());
            stm.setString(4, getKeterangan());
            stm.setString(5, getKdsup());
            stm.setString(6, getNmsup());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Supplier berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusSupplier() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE \n"
                    + "FROM\n"
                    + "  kkp.m04supl\n"
                    + "WHERE kdsup= ? \n"
                    + "  AND nmsup= ? ;");
            
            stm.setString(1, getKdsup());
            stm.setString(2, getNmsup());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Supplier Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printSupplier() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_m04supl.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel getCariSupplier() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT\n"
                    + "  kdsup,\n"
                    + "  nmsup,\n"
                    + "  alamat,\n"
                    + "  kota,\n"
                    + "  telp,\n"
                    + "  keterangan\n"
                    + "FROM kkp.m04supl \n"
                    + "WHERE kdsup LIKE ?"
                    + "AND nmsup LIKE ?"
//                    + "AND Merek_Supplier LIKE ?"
//                    + "AND Satuan LIKE ?"
//                    + "AND Harga LIKE ?"
                    );
            
            stm.setString(1, "%" + getKdsup()+ "%");
            stm.setString(2, "%" + getNmsup()+ "%");
//            stm.setString(3, "%" + getMerek() + "%");
//            stm.setString(4, "%" + getSatuan() + "%");
//            stm.setString(5, "%" + getHarga() + "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("ALAMAT");
            mdlCust.addColumn("KOTA");
            mdlCust.addColumn("TELEPON");
            mdlCust.addColumn("KETERANGAN");

            Object[] os = new Object[6];
            while (rs.next()) {
                os[0] = rs.getString("kdsup");
                os[1] = rs.getString("nmsup");
                os[2] = rs.getString("alamat");
                os[3] = rs.getString("kota");
                os[4] = rs.getString("telp");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M04suplCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
