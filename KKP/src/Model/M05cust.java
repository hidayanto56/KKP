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
public class M05cust {
    BigInteger m05_id;
    String kdcust;
    String nmcust;
    String alamat;
    String kota;  
    String telp;
    String keterangan;
    BigInteger version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

//    public M05cust(BigInteger m05_id, String kdcust, String nmcust, String alamat, String kota, String telp, String keterangan, BigInteger version, String created_by, Date created_on, String updated_by, Date updated_on) {
//        this.m05_id = m05_id;
//        this.kdcust = kdcust;
//        this.nmcust = nmcust;
//        this.alamat = alamat;
//        this.kota = kota;
//        this.telp = telp;
//        this.keterangan = keterangan;
//        this.version = version;
//        this.created_by = created_by;
//        this.created_on = created_on;
//        this.updated_by = updated_by;
//        this.updated_on = updated_on;
//    }

    public BigInteger getM05_id() {
        return m05_id;
    }

    public void setM05_id(BigInteger m05_id) {
        this.m05_id = m05_id;
    }

    public String getKdcust() {
        return kdcust;
    }

    public void setKdcust(String kdcust) {
        this.kdcust = kdcust;
    }

    public String getNmcust() {
        return nmcust;
    }

    public void setNmcust(String nmcust) {
        this.nmcust = nmcust;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
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
