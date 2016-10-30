/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Thinkpad
 */
@Embeddable
public class M05custPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "m05_id")
    private long m05Id;
    @Basic(optional = false)
    @Column(name = "kdcust")
    private String kdcust;

    public M05custPK() {
    }

    public M05custPK(long m05Id, String kdcust) {
        this.m05Id = m05Id;
        this.kdcust = kdcust;
    }

    public long getM05Id() {
        return m05Id;
    }

    public void setM05Id(long m05Id) {
        this.m05Id = m05Id;
    }

    public String getKdcust() {
        return kdcust;
    }

    public void setKdcust(String kdcust) {
        this.kdcust = kdcust;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) m05Id;
        hash += (kdcust != null ? kdcust.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M05custPK)) {
            return false;
        }
        M05custPK other = (M05custPK) object;
        if (this.m05Id != other.m05Id) {
            return false;
        }
        if ((this.kdcust == null && other.kdcust != null) || (this.kdcust != null && !this.kdcust.equals(other.kdcust))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.M05custPK[ m05Id=" + m05Id + ", kdcust=" + kdcust + " ]";
    }
    
}
