/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "m03tabu", catalog = "kkp", schema = "")
@NamedQueries({
    @NamedQuery(name = "M03tabu.findAll", query = "SELECT m FROM M03tabu m"),
    @NamedQuery(name = "M03tabu.findByM03Id", query = "SELECT m FROM M03tabu m WHERE m.m03tabuPK.m03Id = :m03Id"),
    @NamedQuery(name = "M03tabu.findByKdTabung", query = "SELECT m FROM M03tabu m WHERE m.m03tabuPK.kdTabung = :kdTabung"),
    @NamedQuery(name = "M03tabu.findByJenisTabung", query = "SELECT m FROM M03tabu m WHERE m.jenisTabung = :jenisTabung"),
    @NamedQuery(name = "M03tabu.findByHarga", query = "SELECT m FROM M03tabu m WHERE m.harga = :harga"),
    @NamedQuery(name = "M03tabu.findByKeterangan", query = "SELECT m FROM M03tabu m WHERE m.keterangan = :keterangan"),
    @NamedQuery(name = "M03tabu.findByVersion", query = "SELECT m FROM M03tabu m WHERE m.version = :version"),
    @NamedQuery(name = "M03tabu.findByCreatedBy", query = "SELECT m FROM M03tabu m WHERE m.createdBy = :createdBy"),
    @NamedQuery(name = "M03tabu.findByCreatedOn", query = "SELECT m FROM M03tabu m WHERE m.createdOn = :createdOn"),
    @NamedQuery(name = "M03tabu.findByUpdatedBy", query = "SELECT m FROM M03tabu m WHERE m.updatedBy = :updatedBy"),
    @NamedQuery(name = "M03tabu.findByUpdatedOn", query = "SELECT m FROM M03tabu m WHERE m.updatedOn = :updatedOn")})
public class M03tabu implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M03tabuPK m03tabuPK;
    @Basic(optional = false)
    @Column(name = "jenis_tabung")
    private String jenisTabung;
    @Column(name = "harga")
    private Long harga;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "version")
    private BigInteger version;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public M03tabu() {
    }

    public M03tabu(M03tabuPK m03tabuPK) {
        this.m03tabuPK = m03tabuPK;
    }

    public M03tabu(M03tabuPK m03tabuPK, String jenisTabung) {
        this.m03tabuPK = m03tabuPK;
        this.jenisTabung = jenisTabung;
    }

    public M03tabu(long m03Id, String kdTabung) {
        this.m03tabuPK = new M03tabuPK(m03Id, kdTabung);
    }

    public M03tabuPK getM03tabuPK() {
        return m03tabuPK;
    }

    public void setM03tabuPK(M03tabuPK m03tabuPK) {
        this.m03tabuPK = m03tabuPK;
    }

    public String getJenisTabung() {
        return jenisTabung;
    }

    public void setJenisTabung(String jenisTabung) {
        String oldJenisTabung = this.jenisTabung;
        this.jenisTabung = jenisTabung;
        changeSupport.firePropertyChange("jenisTabung", oldJenisTabung, jenisTabung);
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        Long oldHarga = this.harga;
        this.harga = harga;
        changeSupport.firePropertyChange("harga", oldHarga, harga);
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        String oldKeterangan = this.keterangan;
        this.keterangan = keterangan;
        changeSupport.firePropertyChange("keterangan", oldKeterangan, keterangan);
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        BigInteger oldVersion = this.version;
        this.version = version;
        changeSupport.firePropertyChange("version", oldVersion, version);
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        String oldCreatedBy = this.createdBy;
        this.createdBy = createdBy;
        changeSupport.firePropertyChange("createdBy", oldCreatedBy, createdBy);
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        Date oldCreatedOn = this.createdOn;
        this.createdOn = createdOn;
        changeSupport.firePropertyChange("createdOn", oldCreatedOn, createdOn);
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        String oldUpdatedBy = this.updatedBy;
        this.updatedBy = updatedBy;
        changeSupport.firePropertyChange("updatedBy", oldUpdatedBy, updatedBy);
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        Date oldUpdatedOn = this.updatedOn;
        this.updatedOn = updatedOn;
        changeSupport.firePropertyChange("updatedOn", oldUpdatedOn, updatedOn);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (m03tabuPK != null ? m03tabuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M03tabu)) {
            return false;
        }
        M03tabu other = (M03tabu) object;
        if ((this.m03tabuPK == null && other.m03tabuPK != null) || (this.m03tabuPK != null && !this.m03tabuPK.equals(other.m03tabuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.M03tabu[ m03tabuPK=" + m03tabuPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
