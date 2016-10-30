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
@Table(name = "m05cust", catalog = "kkp", schema = "")
@NamedQueries({
    @NamedQuery(name = "M05cust.findAll", query = "SELECT m FROM M05cust m"),
    @NamedQuery(name = "M05cust.findByM05Id", query = "SELECT m FROM M05cust m WHERE m.m05custPK.m05Id = :m05Id"),
    @NamedQuery(name = "M05cust.findByKdcust", query = "SELECT m FROM M05cust m WHERE m.m05custPK.kdcust = :kdcust"),
    @NamedQuery(name = "M05cust.findByNmcust", query = "SELECT m FROM M05cust m WHERE m.nmcust = :nmcust"),
    @NamedQuery(name = "M05cust.findByAlamat", query = "SELECT m FROM M05cust m WHERE m.alamat = :alamat"),
    @NamedQuery(name = "M05cust.findByKota", query = "SELECT m FROM M05cust m WHERE m.kota = :kota"),
    @NamedQuery(name = "M05cust.findByTelp", query = "SELECT m FROM M05cust m WHERE m.telp = :telp"),
    @NamedQuery(name = "M05cust.findByKeterangan", query = "SELECT m FROM M05cust m WHERE m.keterangan = :keterangan"),
    @NamedQuery(name = "M05cust.findByVersion", query = "SELECT m FROM M05cust m WHERE m.version = :version"),
    @NamedQuery(name = "M05cust.findByCreatedBy", query = "SELECT m FROM M05cust m WHERE m.createdBy = :createdBy"),
    @NamedQuery(name = "M05cust.findByCreatedOn", query = "SELECT m FROM M05cust m WHERE m.createdOn = :createdOn"),
    @NamedQuery(name = "M05cust.findByUpdatedBy", query = "SELECT m FROM M05cust m WHERE m.updatedBy = :updatedBy"),
    @NamedQuery(name = "M05cust.findByUpdatedOn", query = "SELECT m FROM M05cust m WHERE m.updatedOn = :updatedOn")})
public class M05cust implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected M05custPK m05custPK;
    @Basic(optional = false)
    @Column(name = "nmcust")
    private String nmcust;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kota")
    private String kota;
    @Column(name = "telp")
    private String telp;
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

    public M05cust() {
    }

    public M05cust(M05custPK m05custPK) {
        this.m05custPK = m05custPK;
    }

    public M05cust(M05custPK m05custPK, String nmcust) {
        this.m05custPK = m05custPK;
        this.nmcust = nmcust;
    }

    public M05cust(long m05Id, String kdcust) {
        this.m05custPK = new M05custPK(m05Id, kdcust);
    }

    public M05custPK getM05custPK() {
        return m05custPK;
    }

    public void setM05custPK(M05custPK m05custPK) {
        this.m05custPK = m05custPK;
    }

    public String getNmcust() {
        return nmcust;
    }

    public void setNmcust(String nmcust) {
        String oldNmcust = this.nmcust;
        this.nmcust = nmcust;
        changeSupport.firePropertyChange("nmcust", oldNmcust, nmcust);
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        String oldAlamat = this.alamat;
        this.alamat = alamat;
        changeSupport.firePropertyChange("alamat", oldAlamat, alamat);
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        String oldKota = this.kota;
        this.kota = kota;
        changeSupport.firePropertyChange("kota", oldKota, kota);
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        String oldTelp = this.telp;
        this.telp = telp;
        changeSupport.firePropertyChange("telp", oldTelp, telp);
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
        hash += (m05custPK != null ? m05custPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M05cust)) {
            return false;
        }
        M05cust other = (M05cust) object;
        if ((this.m05custPK == null && other.m05custPK != null) || (this.m05custPK != null && !this.m05custPK.equals(other.m05custPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.M05cust[ m05custPK=" + m05custPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
