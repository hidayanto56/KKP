/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Thinkpad
 */
public class T02beli {
    Long t02_id;
    Date tanggal;
    String kd_tabung;
    String kdsupl;
    Integer jumlah;
    String keterangan;
    Long version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

    public Long getT02_id() {
        return t02_id;
    }

    public void setT02_id(Long t02_id) {
        this.t02_id = t02_id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
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

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
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
