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
public class M03tabuPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "m03_id")
    private long m03Id;
    @Basic(optional = false)
    @Column(name = "kd_tabung")
    private String kdTabung;

    public M03tabuPK() {
    }

    public M03tabuPK(long m03Id, String kdTabung) {
        this.m03Id = m03Id;
        this.kdTabung = kdTabung;
    }

    public long getM03Id() {
        return m03Id;
    }

    public void setM03Id(long m03Id) {
        this.m03Id = m03Id;
    }

    public String getKdTabung() {
        return kdTabung;
    }

    public void setKdTabung(String kdTabung) {
        this.kdTabung = kdTabung;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) m03Id;
        hash += (kdTabung != null ? kdTabung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof M03tabuPK)) {
            return false;
        }
        M03tabuPK other = (M03tabuPK) object;
        if (this.m03Id != other.m03Id) {
            return false;
        }
        if ((this.kdTabung == null && other.kdTabung != null) || (this.kdTabung != null && !this.kdTabung.equals(other.kdTabung))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.M03tabuPK[ m03Id=" + m03Id + ", kdTabung=" + kdTabung + " ]";
    }
    
}
