/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.P01peru;
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
public class P01peruCtrl  extends P01peru{
    public DefaultTableModel getParameter() {
        try {
            MySQLConn conn = new MySQLConn();

            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  kdperu      ,\n"
                    + "  nmperu      ,\n"
                    + "  alamat      ,\n"
                    + "  kota        , \n"
                    + "  telp1       , \n"
                    + "  telp2       , \n"
                    + "  email, \n"
                    + "  npwp, \n"
                    + "  kdsiup \n"
                    + "FROM\n"
                    + "  kkp.p01peru");

            ResultSet rs = stm.executeQuery();

            DefaultTableModel mdlCust = new DefaultTableModel();
            mdlCust.addColumn("KODE");
            mdlCust.addColumn("NAMA");
            mdlCust.addColumn("ALAMAT");
            mdlCust.addColumn("KOTA");
            mdlCust.addColumn("TELEPON");
            mdlCust.addColumn("TELEPON 2");
            mdlCust.addColumn("EMAIL");
            mdlCust.addColumn("NPWP");
            mdlCust.addColumn("KDSIUP");

            Object[] os = new Object[9];
            while (rs.next()) {
                os[0] = rs.getString("kdperu");
                os[1] = rs.getString("nmperu");
                os[2] = rs.getString("alamat");
                os[3] = rs.getString("kota");
                os[4] = rs.getString("telp1");
                os[5] = rs.getString("telp2");
                os[6] = rs.getString("email");
                os[7] = rs.getString("npwp");
                os[8] = rs.getString("kdsiup");
                mdlCust.addRow(os);
            }
            return mdlCust;
        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void editParameter() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("UPDATE \n"
                    + "  kkp.p01peru \n"
                    + "SET\n"
                    + "  alamat      = ?,\n"
                    + "  kota        = ?,\n"
                    + "  telp1       = ?,\n"
                    + "  telp2       = ?,\n"
                    + "  email       = ?,\n"
                    + "  npwp        = ?,\n"
                    + "  kdsiup      = ?\n");
            stm.setString(1, getAlamat());
            stm.setString(2, getKota());
            stm.setString(3, getTelp1());
            stm.setString(4, getTelp2());
            stm.setString(5, getEmail());
            stm.setString(6, getNpwp());
            stm.setString(7, getSiup());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Parameter Perusahaan berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(M05custCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
