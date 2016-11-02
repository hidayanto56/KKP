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
public class T01jual {
    Long t01_id;
    Date tanggal;
    Integer tipe;
    Double jumlah;
    String kd_tabung;
    String kdsupl;
    String keterangan;
    Long version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

    public Long getT01_id() {
        return t01_id;
    }

    public void setT01_id(Long t01_id) {
        this.t01_id = t01_id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKd_tabung() {
        return kd_tabung;
    }

    public void setKd_tabung(String kd_tabung) {
        this.kd_tabung = kd_tabung;
    }

    public String getKdsupl() {
        return kdsupl;
    }

    public void setKdsupl(String kdsupl) {
        this.kdsupl = kdsupl;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
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
