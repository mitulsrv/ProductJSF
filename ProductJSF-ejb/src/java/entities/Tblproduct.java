/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mitul
 */
@Entity
@Table(name = "tblproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblproduct.findAll", query = "SELECT t FROM Tblproduct t"),
    @NamedQuery(name = "Tblproduct.findByProductId", query = "SELECT t FROM Tblproduct t WHERE t.productId = :productId"),
    @NamedQuery(name = "Tblproduct.findByProductName", query = "SELECT t FROM Tblproduct t WHERE t.productName = :productName"),
    @NamedQuery(name = "Tblproduct.findByPrice", query = "SELECT t FROM Tblproduct t WHERE t.price = :price"),
    @NamedQuery(name = "Tblproduct.findByDescription", query = "SELECT t FROM Tblproduct t WHERE t.description = :description")})
public class Tblproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductId")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "Price")
    private int price;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    @ManyToOne(optional = false)
    private Tblcategory categoryId;

    public Tblproduct() {
    }

    public Tblproduct(Integer productId) {
        this.productId = productId;
    }

    public Tblproduct(Integer productId, String productName, int price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tblcategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Tblcategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblproduct)) {
            return false;
        }
        Tblproduct other = (Tblproduct) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tblproduct[ productId=" + productId + " ]";
    }
    
}
