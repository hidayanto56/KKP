/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M03tabu;
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
public class M03tabuCtrl extends M03tabu{
   
    public DefaultTableModel getDaftarTabung() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  kd_tabung  ,\n"
                    + "  jenis_tabung,\n"
                    + "  harga,\n"
                    + "  keterangan \n"
                    + "FROM\n"
                    + "  kkp.m03tabu");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlTabu = new DefaultTableModel();
            mdlTabu.addColumn("KODE");
            mdlTabu.addColumn("JENIS TABUNG");
            mdlTabu.addColumn("HARGA JUAL");
            mdlTabu.addColumn("KETERANGAN");

            Object[] os = new Object[4];
            while (rs.next()) {
                os[0] = rs.getString("kd_tabung");
                os[1] = rs.getString("jenis_tabung");
                os[2] = rs.getString("harga");
                os[3] = rs.getString("keterangan");
                mdlTabu.addRow(os);
            }
            return mdlTabu;
        } catch (SQLException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahTabung() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.m03tabu (\n"
                    + "  kd_tabung,\n"
                    + "  jenis_tabung,\n"
                    + "  harga,\n"
                    + "  keterangan\n"
                    + ") \n"
                    + "VALUES ( ?,?,?,?) ;");
            stm.setString(1, getKd_tabung());
            stm.setString(2, getJenis_tabung());
            stm.setDouble(3, getHarga());
            stm.setString(4, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Tabung baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
     
     public void editTabung() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE \n"
                    + "  kkp.m03tabu \n"
                    + "SET\n"
                    + "  jenis_tabung= ?,\n"
                    + "  harga = ?,\n"
                    + "  keterangan = ?\n"
                    + "WHERE kd_tabung = ? \n");
            stm.setString(1, getJenis_tabung());
            stm.setDouble(2, getHarga());
            stm.setString(3, getKeterangan());
            stm.setString(4, getKd_tabung());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Data Tabung berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusTabung() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE \n"
                    + "FROM\n"
                    + "  kkp.m03tabu\n"
                    + "WHERE kd_tabung= ? \n"
                    + "  AND jenis_tabung= ? ;");
            
            stm.setString(1, getKd_tabung());
            stm.setString(2, getJenis_tabung());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Data Tabung Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printTabung() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_m03tabu.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel getCariTabung() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT\n"
                    + "  kd_tabung,\n"
                    + "  jenis_tabung,\n"
                    + "  harga,\n"
                    + "  keterangan\n"
                    + "FROM kkp.m03tabu \n"
                    + "WHERE kd_tabung LIKE ?"
                    + "AND jenis_tabung LIKE ?"
//                    + "AND Merek_Customer LIKE ?"
//                    + "AND Satuan LIKE ?"
//                    + "AND Harga LIKE ?"
                    );
            
            stm.setString(1, "%" + getKd_tabung()+ "%");
            stm.setString(2, "%" + getJenis_tabung()+ "%");
//            stm.setString(3, "%" + getMerek() + "%");
//            stm.setString(4, "%" + getSatuan() + "%");
//            stm.setString(5, "%" + getHarga() + "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlTabu = new DefaultTableModel();
            mdlTabu.addColumn("KODE");
            mdlTabu.addColumn("JENIS TABUNG");
            mdlTabu.addColumn("HARGA JUAL");
            mdlTabu.addColumn("KETERANGAN");

            Object[] os = new Object[4];
            while (rs.next()) {
                os[0] = rs.getString("kd_tabung");
                os[1] = rs.getString("jenis_tabung");
                os[2] = rs.getString("harga");
                os[3] = rs.getString("keterangan");
                mdlTabu.addRow(os);
            }
            return mdlTabu;
        } catch (SQLException ex) {
            Logger.getLogger(M03tabuCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
