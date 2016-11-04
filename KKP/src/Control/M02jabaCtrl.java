/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M02jaba;
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
public class M02jabaCtrl extends M02jaba{
    public DefaultTableModel getDaftarJabatan() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  kdjab  ,\n"
                    + "  nmjab,\n"
                    + "  keterangan \n"
                    + "FROM\n"
                    + "  kkp.m02jaba");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("KETERANGAN");

            Object[] os = new Object[3];
            while (rs.next()) {
                os[0] = rs.getString("kdjab");
                os[1] = rs.getString("nmjab");
                os[2] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void tambahJabatan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO kkp.m02jaba (\n"
                    + "  kdjab,\n"
                    + "  nmjab,\n"
                    + "  keterangan\n"
                    + ") \n"
                    + "VALUES ( ?,?,?,?,?,?) ;");
            stm.setString(1, getKdjab());
            stm.setString(2, getNmjab());
//            stm.setString(3, getAlamat());
//            stm.setString(4, getKota());
//            stm.setString(5, getTelp());
            stm.setString(6, getKeterangan());
            
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Jabatan baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
     
     public void editJabatan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE \n"
                    + "  kkp.m02jaba \n"
                    + "SET\n"
//                    + "  alamat= ?,\n"
//                    + "  kota = ?,\n"
//                    + "  telp= ?,\n"
                    + "  keterangan = ?\n"
                    + "WHERE kdjab = ? \n"
                    + "  AND nmjab= ?");
//            stm.setString(1, getAlamat());
//            stm.setString(2, getKota());
//            stm.setString(3, getTelp());
            stm.setString(4, getKeterangan());
            stm.setString(5, getKdjab());
            stm.setString(6, getNmjab());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Jabatan berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusJabatan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE \n"
                    + "FROM\n"
                    + "  kkp.m02jaba\n"
                    + "WHERE kdjab= ? \n"
                    + "  AND nmjab= ? ;");
            
            stm.setString(1, getKdjab());
            stm.setString(2, getNmjab());
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Jabatan Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void printJabatan() {
        
        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_m02jaba.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel getCariJabatan() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT\n"
                    + "  kdjab,\n"
                    + "  nmjab,\n"
                    + "  keterangan\n"
                    + "FROM kkp.m02jaba \n"
                    + "WHERE kdjab LIKE ?"
                    + "AND nmjab LIKE ?"
                    );
            
            stm.setString(1, "%" + getKdjab()+ "%");
            stm.setString(2, "%" + getNmjab()+ "%");
            

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("KETERANGAN");

            Object[] os = new Object[3];
            while (rs.next()) {
                os[0] = rs.getString("kdjab");
                os[1] = rs.getString("nmjab");
                os[2] = rs.getString("keterangan");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M02jabaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
