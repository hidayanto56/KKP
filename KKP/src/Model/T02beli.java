/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "t02beli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "T02beli.findAll", query = "SELECT t FROM T02beli t"),
    @NamedQuery(name = "T02beli.findByT02Id", query = "SELECT t FROM T02beli t WHERE t.t02Id = :t02Id"),
    @NamedQuery(name = "T02beli.findByTanggal", query = "SELECT t FROM T02beli t WHERE t.tanggal = :tanggal"),
    @NamedQuery(name = "T02beli.findByM03Id", query = "SELECT t FROM T02beli t WHERE t.m03Id = :m03Id"),
    @NamedQuery(name = "T02beli.findByM04Id", query = "SELECT t FROM T02beli t WHERE t.m04Id = :m04Id"),
    @NamedQuery(name = "T02beli.findByJumlah", query = "SELECT t FROM T02beli t WHERE t.jumlah = :jumlah"),
    @NamedQuery(name = "T02beli.findByKeterangan", query = "SELECT t FROM T02beli t WHERE t.keterangan = :keterangan"),
    @NamedQuery(name = "T02beli.findByVersion", query = "SELECT t FROM T02beli t WHERE t.version = :version"),
    @NamedQuery(name = "T02beli.findByCreatedBy", query = "SELECT t FROM T02beli t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "T02beli.findByCreatedOn", query = "SELECT t FROM T02beli t WHERE t.createdOn = :createdOn"),
    @NamedQuery(name = "T02beli.findByUpdatedBy", query = "SELECT t FROM T02beli t WHERE t.updatedBy = :updatedBy"),
    @NamedQuery(name = "T02beli.findByUpdatedOn", query = "SELECT t FROM T02beli t WHERE t.updatedOn = :updatedOn")})
public class T02beli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "t02_id")
    private Long t02Id;
    @Basic(optional = false)
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Basic(optional = false)
    @Column(name = "m03_id")
    private long m03Id;
    @Basic(optional = false)
    @Column(name = "m04_id")
    private long m04Id;
    @Column(name = "jumlah")
    private BigInteger jumlah;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "version")
    private BigInteger version;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    private Date createdOn;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    @Temporal(TemporalType.DATE)
    private Date updatedOn;

    public T02beli() {
    }

    public T02beli(Long t02Id) {
        this.t02Id = t02Id;
    }

    public T02beli(Long t02Id, Date tanggal, long m03Id, long m04Id) {
        this.t02Id = t02Id;
        this.tanggal = tanggal;
        this.m03Id = m03Id;
        this.m04Id = m04Id;
    }

    public Long getT02Id() {
        return t02Id;
    }

    public void setT02Id(Long t02Id) {
        this.t02Id = t02Id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public long getM03Id() {
        return m03Id;
    }

    public void setM03Id(long m03Id) {
        this.m03Id = m03Id;
    }

    public long getM04Id() {
        return m04Id;
    }

    public void setM04Id(long m04Id) {
        this.m04Id = m04Id;
    }

    public BigInteger getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigInteger jumlah) {
        this.jumlah = jumlah;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (t02Id != null ? t02Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T02beli)) {
            return false;
        }
        T02beli other = (T02beli) object;
        if ((this.t02Id == null && other.t02Id != null) || (this.t02Id != null && !this.t02Id.equals(other.t02Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.T02beli[ t02Id=" + t02Id + " ]";
    }
    
}
