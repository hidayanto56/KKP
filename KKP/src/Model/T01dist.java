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
public class T01dist {
    BigInteger t01_id;
    Date tanggal;
    Integer tipe;
    BigInteger m03_id;
    BigInteger m04_id;
    BigInteger m05_id;
    Double jumlah;
    BigInteger version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

//    public T01dist(BigInteger t01_id, Date tanggal, Integer tipe, BigInteger m03_id, BigInteger m04_id, BigInteger m05_id, Double jumlah, BigInteger version, String created_by, Date created_on, String updated_by, Date updated_on) {
//        this.t01_id = t01_id;
//        this.tanggal = tanggal;
//        this.tipe = tipe;
//        this.m03_id = m03_id;
//        this.m04_id = m04_id;
//        this.m05_id = m05_id;
//        this.jumlah = jumlah;
//        this.version = version;
//        this.created_by = created_by;
//        this.created_on = created_on;
//        this.updated_by = updated_by;
//        this.updated_on = updated_on;
//    }

    public BigInteger getT01_id() {
        return t01_id;
    }

    public void setT01_id(BigInteger t01_id) {
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

    public BigInteger getM03_id() {
        return m03_id;
    }

    public void setM03_id(BigInteger m03_id) {
        this.m03_id = m03_id;
    }

    public BigInteger getM04_id() {
        return m04_id;
    }

    public void setM04_id(BigInteger m04_id) {
        this.m04_id = m04_id;
    }

    public BigInteger getM05_id() {
        return m05_id;
    }

    public void setM05_id(BigInteger m05_id) {
        this.m05_id = m05_id;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public void setJumlah(Double jumlah) {
        this.jumlah = jumlah;
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