/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M05cust;
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
public class M05custCtrl extends M05cust{
    public DefaultTableModel getDaftarCustomer() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  kdcust  ,\n"
                    + "  nmcust,\n"
                    + "  alamat,\n"
                    + "  kota, \n"
                    + "  telp, \n"
                    + "  keterangan \n"
                    + "FROM\n"
                    + "  kkp.m05cust");

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
                os[0] = rs.getString("kdcust");
                os[1] = rs.getString("nmcust");
                os[2] = rs.getString("alamat");
                os[3] = rs.getString("kota");
                os[4] = rs.getString("telp");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahCustomer() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.m05cust (\n"
                    + "  kdcust,\n"
                    + "  nmcust,\n"
                    + "  alamat,\n"
                    + "  kota,\n"
                    + "  telp,\n"
                    + "  keterangan\n"
                    + ") \n"
                    + "VALUES ( ?,?,?,?,?,?) ;");
            stm.setString(1, getKdcust());
            stm.setString(2, getNmcust());
            stm.setString(3, getAlamat());
            stm.setString(4, getKota());
            stm.setString(5, getTelp());
            stm.setString(6, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Customer baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
     
     public void editCustomer() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE \n"
                    + "  kkp.m05cust \n"
                    + "SET\n"
                    + "  alamat= ?,\n"
                    + "  kota = ?,\n"
                    + "  telp= ?,\n"
                    + "  keterangan = ?\n"
                    + "WHERE kdcust = ? \n"
                    + "  AND nmcust= ?");
            stm.setString(1, getAlamat());
            stm.setString(2, getKota());
            stm.setString(3, getTelp());
            stm.setString(4, getKeterangan());
            stm.setString(5, getKdcust());
            stm.setString(6, getNmcust());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Customer berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusCustomer() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE \n"
                    + "FROM\n"
                    + "  kkp.m05cust\n"
                    + "WHERE kdcust= ? \n"
                    + "  AND nmcust= ? ;");
            
            stm.setString(1, getKdcust());
            stm.setString(2, getNmcust());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Customer Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printCustomer() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_m05cust.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel getCariCustomer() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT\n"
                    + "  kdcust,\n"
                    + "  nmcust,\n"
                    + "  alamat,\n"
                    + "  kota,\n"
                    + "  telp,\n"
                    + "  keterangan\n"
                    + "FROM kkp.m05cust \n"
                    + "WHERE kdcust LIKE ?"
                    + "AND nmcust LIKE ?"
//                    + "AND Merek_Customer LIKE ?"
//                    + "AND Satuan LIKE ?"
//                    + "AND Harga LIKE ?"
                    );
            
            stm.setString(1, "%" + getKdcust()+ "%");
            stm.setString(2, "%" + getNmcust()+ "%");
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
                os[0] = rs.getString("kdcust");
                os[1] = rs.getString("nmcust");
                os[2] = rs.getString("alamat");
                os[3] = rs.getString("kota");
                os[4] = rs.getString("telp");
                os[5] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
