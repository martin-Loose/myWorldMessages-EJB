/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_messages", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")
    , @NamedQuery(name = "Messages.findById", query = "SELECT m FROM Messages m WHERE m.id = :id")
    , @NamedQuery(name = "Messages.findBySenderID", query = "SELECT m FROM Messages m WHERE m.senderID = :senderID")
    , @NamedQuery(name = "Messages.findByReceiverID", query = "SELECT m FROM Messages m WHERE m.receiverID = :receiverID")
        , @NamedQuery(name = "Messages.findMyInbox", query = "SELECT m FROM Messages m WHERE m.receiverID = :receiverID AND m.isRead = :isRead")
        , @NamedQuery(name = "Messages.findMyGarbage", query = "SELECT m FROM Messages m WHERE m.receiverID = :receiverID AND m.toDelete =:toDelete")
    , @NamedQuery(name = "Messages.findByWann", query = "SELECT m FROM Messages m WHERE m.wann = :wann")
    , @NamedQuery(name = "Messages.findByToDelete", query = "SELECT m FROM Messages m WHERE m.toDelete = :toDelete")
    , @NamedQuery(name = "Messages.findByIsRead", query = "SELECT m FROM Messages m WHERE m.isRead = :isRead")
    , @NamedQuery(name = "Messages.findByBetreff", query = "SELECT m FROM Messages m WHERE m.betreff = :betreff")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int senderID;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int receiverID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date wann;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean toDelete;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean isRead;
    @Size(max = 50)
    @Column(length = 50)
    private String betreff;

    public Messages() {
    }

    public Messages(Integer id) {
        this.id = id;
    }

    public Messages(Integer id, int senderID, int receiverID, String message, Date wann, boolean toDelete, boolean isRead) {
        this.id = id;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.message = message;
        this.wann = wann;
        this.toDelete = toDelete;
        this.isRead = isRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getWann() {
        return wann;
    }

    public void setWann(Date wann) {
        this.wann = wann;
    }

    public boolean getToDelete() {
        return toDelete;
    }

    public void setToDelete(boolean toDelete) {
        this.toDelete = toDelete;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getBetreff() {
        return betreff;
    }

    public void setBetreff(String betreff) {
        this.betreff = betreff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Messages[ id=" + id + " ]";
    }
    
}
