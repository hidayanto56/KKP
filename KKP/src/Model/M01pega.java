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
public class M01pega {
    BigInteger m01_id;
    String nik;
    String nama;
    String username;
    String password;
    String gender;
    String status;
    String telepon;
    String alamat;
    String agama;
    Date tgllahir;
    String email    ;
    Date tglmasuk;
    BigInteger m02_id;
    BigInteger version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

//    public M01pega(BigInteger m01_id, String nik, String nama, String gender, String status, String telepon, String alamat, String agama, Date tgllahir, String email, Date tglmasuk, BigInteger m02_id, BigInteger version, String created_by, Date created_on, String updated_by, Date updated_on) {
//        this.m01_id = m01_id;
//        this.nik = nik;
//        this.nama = nama;
//        this.gender = gender;
//        this.status = status;
//        this.telepon = telepon;
//        this.alamat = alamat;
//        this.agama = agama;
//        this.tgllahir = tgllahir;
//        this.email = email;
//        this.tglmasuk = tglmasuk;
//        this.m02_id = m02_id;
//        this.version = version;
//        this.created_by = created_by;
//        this.created_on = created_on;
//        this.updated_by = updated_by;
//        this.updated_on = updated_on;
//    }

    public BigInteger getM01_id() {
        return m01_id;
    }

    public void setM01_id(BigInteger m01_id) {
        this.m01_id = m01_id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTglmasuk() {
        return tglmasuk;
    }

    public void setTglmasuk(Date tglmasuk) {
        this.tglmasuk = tglmasuk;
    }

    public BigInteger getM02_id() {
        return m02_id;
    }

    public void setM02_id(BigInteger m02_id) {
        this.m02_id = m02_id;
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


