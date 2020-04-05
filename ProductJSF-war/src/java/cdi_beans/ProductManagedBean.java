/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi_beans;

import beans.AdminBeanLocal;
import entities.Tblcategory;
import entities.Tblproduct;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mitul
 */
@Named(value = "productManagedBean")
@RequestScoped
public class ProductManagedBean {

    @EJB AdminBeanLocal ab;
    
    private int ProductId;
    private String ProductName;
    private int Price;
    private String Description;
    private int CategoryId;
    private Collection<Tblcategory> CollectionCategory;
    
    public ProductManagedBean() {
    }
    @PostConstruct
    public void init(){
        CollectionCategory = ab.getAllCategory();
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Collection<Tblcategory> getCollectionCategory() {
        return CollectionCategory;
    }

    public void setCollectionCategory(Collection<Tblcategory> CollectionCategory) {
        this.CollectionCategory = CollectionCategory;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }
    
    
    public Collection<Tblproduct> getAllProducts(){
        return ab.getAllProducts();
    }
    
    public String saveProduct(){
        if(this.ProductId == 0){
            Tblproduct fiProduct = new Tblproduct();
            fiProduct.setDescription(this.Description);
            fiProduct.setPrice(this.Price);
            fiProduct.setProductName(this.ProductName);
            fiProduct.setCategoryId(new Tblcategory(this.CategoryId));
            ab.addProduct(fiProduct);
        }else{
            Tblproduct fiProduct = new Tblproduct();
            fiProduct.setDescription(this.Description);
            fiProduct.setPrice(this.Price);
            fiProduct.setProductName(this.ProductName);
            fiProduct.setProductId(this.ProductId);
            fiProduct.setCategoryId(new Tblcategory(this.CategoryId));
            ab.updateProduct(fiProduct);
        }
        return "/faces/product.xhtml?faces-redirect=true";
    }
    
    public String deleteProduct(int ProductId_){
        ab.removeProduct(ProductId_);
        return "/faces/product.xhtml?faces-redirect=true";
    }
    public String getProduct(int ProductId_){
        Tblproduct fiProduct = ab.getProduct(ProductId_);
        this.CategoryId = fiProduct.getCategoryId().getCategoryId();
        this.Description = fiProduct.getDescription();
        this.Price = fiProduct.getPrice();
        this.ProductName = fiProduct.getProductName();
        this.ProductId = fiProduct.getProductId();
        return "/faces/add-edit-product.xhtml?faces-redirect=true";
    }
    
    public String redirectToaddProduct(){
        return "/faces/add-edit-product.xhtml?faces-redirect=true";
    }
    
    public String redirectToProducts(){
        return "/faces/product.xhtml?faces-redirect=true";
    }
    
}
