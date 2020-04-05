/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mitul
 */
@Entity
@Table(name = "tblcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcategory.findAll", query = "SELECT t FROM Tblcategory t"),
    @NamedQuery(name = "Tblcategory.findByCategoryId", query = "SELECT t FROM Tblcategory t WHERE t.categoryId = :categoryId"),
    @NamedQuery(name = "Tblcategory.findByCategoryName", query = "SELECT t FROM Tblcategory t WHERE t.categoryName = :categoryName")})
public class Tblcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CategoryId")
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "CategoryName")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Tblproduct> tblproductCollection;

    public Tblcategory() {
    }

    public Tblcategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Tblcategory(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public Collection<Tblproduct> getTblproductCollection() {
        return tblproductCollection;
    }

    public void setTblproductCollection(Collection<Tblproduct> tblproductCollection) {
        this.tblproductCollection = tblproductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcategory)) {
            return false;
        }
        Tblcategory other = (Tblcategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tblcategory[ categoryId=" + categoryId + " ]";
    }
    
}
