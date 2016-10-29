/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.M01pega;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinkpad
 */
public class M01pegaCtrl extends M01pega{

    public String cekLogin() {
        try {
            MySQLConn conn = new MySQLConn();
            PreparedStatement stm = conn.connect("SELECT \n"
                    + "  Username,\n"
                    + "  Nama,\n"
                    + "  Jabatan,\n"
                    + "  PASSWORD \n"
                    + "FROM\n"
                    + "  m01pega \n"
                    + "WHERE Username = ? \n"
                    + "AND PASSWORD = ? ;");
            stm.setString(1, getUsername());
            stm.setString(2, getPassword());

            ResultSet rs = stm.executeQuery();
            String hasil = "";
            if (rs.next()) {
                hasil = /*"sukses" atau*/ "boleh";
//                return "boleh";
//            } else {
//                return "tidak";
            }
            return hasil;

        } catch (SQLException ex) {
            Logger.getLogger(M01pegaCtrl.class.getName()).log(Level.SEVERE, null, ex);

            return "tidak";
        }

    }
    
    
}
