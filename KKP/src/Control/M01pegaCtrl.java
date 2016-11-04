/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M01pega;
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
public class M01pegaCtrl extends M01pega {

    public String cekLogin() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("SELECT nik, nama, username, PASSWORD \n"
                    + "FROM m01pega \n"
                    + "WHERE username = ?\n"
                    + "AND PASSWORD = ?;");
            stm.setString(1, getUsername());
            stm.setString(2, getPassword());

            ResultSet rs = stm.executeQuery();
            String hasil = "Username atau Password salah";
            if (rs.next()) {
                hasil = /*"sukses" atau*/ "boleh";
//                return "boleh";
//            } else {
//                return "tidak";
            }
            return hasil;

        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
//            System.err.println(ex.getMessage());
            return ex.getMessage();

        }

    }

    public DefaultTableModel getDaftarPegawai() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT *"
                    + "FROM\n"
                    + "  kkp.m01pega");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("NIK");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("USENAME");
            mdlCust.addColumn("PASSWORD");
            mdlCust.addColumn("GENDER");
            mdlCust.addColumn("STATUS");
            mdlCust.addColumn("TELEPON");
            mdlCust.addColumn("ALAMAT");
            mdlCust.addColumn("AGAMA");
            mdlCust.addColumn("TANGGAL LAHIR");
            mdlCust.addColumn("EMAIL");
            mdlCust.addColumn("TANGGAL MASUK");
            mdlCust.addColumn("KD JABATAN");

            Object[] os = new Object[12];
            while (rs.next()) {
                os[0] = rs.getString("nik");
                os[1] = rs.getString("nama");
                os[2] = rs.getString("username");
                os[3] = rs.getString("password");
                os[4] = rs.getString("gender");
                os[5] = rs.getString("status");
                os[6] = rs.getString("telepon");
                os[7] = rs.getString("alamat");
                os[8] = rs.getString("agama");
                os[9] = rs.getString("tgllahir");
                os[10] = rs.getString("email");
                os[11] = rs.getString("tglmasuk");
                os[12] = rs.getString("kdjab");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void tambahPegawai() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("INSERT INTO m01pega (\n"
                    + "nik, \n"
                    + "nama, \n"
                    + "username,\n"
                    + "PASSWORD, \n"
                    + "gender, \n"
                    + "STATUS, \n"
                    + "telepon, \n"
                    + "alamat, \n"
                    + "agama, \n"
                    + "tgllahir, \n"
                    + "email, \n"
                    + "tglmasuk, \n"
                    + "kdjab)\n"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            stm.setString(1, getNik());
            stm.setString(2, getNama());
            stm.setString(3, getUsername());
            stm.setString(4, getPassword());
            stm.setString(5, getGender());
            stm.setString(6, getStatus());
            stm.setString(7, getTelepon());
            stm.setString(8, getAlamat());
            stm.setString(9, getAgama());
            stm.setDate(10, new Date(getTgllahir().getTime()));
            stm.setString(11, getEmail());
            stm.setDate(12, new Date(getTglmasuk().getTime()));
            stm.setString(13, getKdjab());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pegawai baru berhasil ditambahkan", "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void editPegawai() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE m01pega SET \n"
                    + "nama=?, \n"
                    + "username=?,\n"
                    + "PASSWORD=?, \n"
                    + "gender=?, \n"
                    + "STATUS=?, \n"
                    + "telepon=?, \n"
                    + "alamat=?, \n"
                    + "agama=?, \n"
                    + "tgllahir=?, \n"
                    + "email=?, \n"
                    + "tglmasuk=?, \n"
                    + "kdjab = ?\n"
                    + "WHERE nik = ?; ");
            stm.setString(1, getNama());
            stm.setString(2, getUsername());
            stm.setString(3, getPassword());
            stm.setString(4, getGender());
            stm.setString(5, getStatus());
            stm.setString(6, getTelepon());
            stm.setString(7, getAlamat());
            stm.setString(8, getAgama());
            stm.setDate(9, new Date(getTgllahir().getTime()));
            stm.setString(10, getEmail());
            stm.setDate(11, new Date(getTglmasuk().getTime()));
            stm.setString(12, getKdjab());
            stm.setString(13, getNik());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pegawai berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hapusPegawai() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("DELETE \n"
                    + "FROM\n"
                    + "  kkp.m01pega\n"
                    + "WHERE nik= ? ;");

            stm.setString(1, getNik());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Pegawai Berhasil Dihapus", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void printPegawai() {

        try {
            MySQLConn conn = new MySQLConn();
            File file = new File("./src/Laporan/l_m01pega.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            HashMap param = new HashMap();
            param.clear();

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getCariPegawai() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect(
                    "SELECT * \n"
                    + "FROM kkp.m01pega \n"
                    + "WHERE nik LIKE ?"
                    + "AND nama LIKE ?"
                    + "AND username LIKE ?"
                    + "AND gender LIKE ?"
                    + "AND STATUS LIKE ?"
                    + "AND tglmasuk LIKE ?"
                    + "AND kdjab LIKE ?"
            );

            stm.setString(1, "%" + getNik()+ "%");
            stm.setString(2, "%" + getNama()+ "%");
            stm.setString(3, "%" + getUsername()+ "%");
            stm.setString(4, "%" + getGender()+ "%");
            stm.setString(5, "%" + getStatus()+ "%");
            stm.setString(6, "%" + getTglmasuk()+ "%");
            stm.setString(7, "%" + getKdjab()+ "%");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("NIK");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("USENAME");
            mdlCust.addColumn("PASSWORD");
            mdlCust.addColumn("GENDER");
            mdlCust.addColumn("STATUS");
            mdlCust.addColumn("TELEPON");
            mdlCust.addColumn("ALAMAT");
            mdlCust.addColumn("AGAMA");
            mdlCust.addColumn("TANGGAL LAHIR");
            mdlCust.addColumn("EMAIL");
            mdlCust.addColumn("TANGGAL MASUK");
            mdlCust.addColumn("KD JABATAN");

            Object[] os = new Object[12];
            while (rs.next()) {
                os[0] = rs.getString("nik");
                os[1] = rs.getString("nama");
                os[2] = rs.getString("username");
                os[3] = rs.getString("password");
                os[4] = rs.getString("gender");
                os[5] = rs.getString("status");
                os[6] = rs.getString("telepon");
                os[7] = rs.getString("alamat");
                os[8] = rs.getString("agama");
                os[9] = rs.getString("tgllahir");
                os[10] = rs.getString("email");
                os[11] = rs.getString("tglmasuk");
                os[12] = rs.getString("kdjab");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
