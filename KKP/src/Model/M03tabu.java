/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Thinkpad
 */
public class M03tabu {
    BigInteger m03_id;
    String kd_tabung;
    String jenis_tabung;
    Double harga;
    String keterangan;
    BigInteger version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

//    public M03tabu(BigInteger m03_id, String kd_tabung, String jenis_tabung, Double harga, String keterangan, BigInteger version, String created_by, Date created_on, String updated_by, Date updated_on) {
//        this.m03_id = m03_id;
//        this.kd_tabung = kd_tabung;
//        this.jenis_tabung = jenis_tabung;
//        this.harga = harga;
//        this.keterangan = keterangan;
//        this.version = version;
//        this.created_by = created_by;
//        this.created_on = created_on;
//        this.updated_by = updated_by;
//        this.updated_on = updated_on;
//    }

    public BigInteger getM03_id() {
        return m03_id;
    }

    public void setM03_id(BigInteger m03_id) {
        this.m03_id = m03_id;
    }

    public String getKd_tabung() {
        return kd_tabung;
    }

    public void setKd_tabung(String kd_tabung) {
        this.kd_tabung = kd_tabung;
    }

    public String getJenis_tabung() {
        return jenis_tabung;
    }

    public void setJenis_tabung(String jenis_tabung) {
        this.jenis_tabung = jenis_tabung;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Date updated_on) {
        this.updated_on = updated_on;
    }
    
    
    
}
