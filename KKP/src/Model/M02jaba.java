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
public class M02jaba {
    BigInteger m02_id;
    String kdjab;
    String nmjab;       
    String keterangan;
    BigInteger version;
    String created_by;
    Date created_on;
    String updated_by;
    Date updated_on;

//    public M02jaba(BigInteger m02_id, String kdjab, String nmjab, String keterangan, BigInteger version, String created_by, Date created_on, String updated_by, Date updated_on) {
//        this.m02_id = m02_id;
//        this.kdjab = kdjab;
//        this.nmjab = nmjab;
//        this.keterangan = keterangan;
//        this.version = version;
//        this.created_by = created_by;
//        this.created_on = created_on;
//        this.updated_by = updated_by;
//        this.updated_on = updated_on;
//    }

    public BigInteger getM02_id() {
        return m02_id;
    }

    public void setM02_id(BigInteger m02_id) {
        this.m02_id = m02_id;
    }

    public String getKdjab() {
        return kdjab;
    }

    public void setKdjab(String kdjab) {
        this.kdjab = kdjab;
    }

    public String getNmjab() {
        return nmjab;
    }

    public void setNmjab(String nmjab) {
        this.nmjab = nmjab;
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
