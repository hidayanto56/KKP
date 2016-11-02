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
public class M04supl {
    Long m04_id;
    String kdsup;
    String nmsup;
    String alamat;
    String kota;
    String telp;
    String keterangan;
    Long version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

    public Long getM04_id() {
        return m04_id;
    }

    public void setM04_id(Long m04_id) {
        this.m04_id = m04_id;
    }

    public String getKdsup() {
        return kdsup;
    }

    public void setKdsup(String kdsup) {
        this.kdsup = kdsup;
    }

    public String getNmsup() {
        return nmsup;
    }

    public void setNmsup(String nmsup) {
        this.nmsup = nmsup;
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
