/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi_beans;

import beans.AdminBeanLocal;
import entities.Tblcategory;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mitul
 */
@Named(value = "categoryManagedBean")
@RequestScoped
public class CategoryManagedBean {
    @EJB AdminBeanLocal adminBean;
    
    
    private int CategoryId;
    private String CategoryName;
    
    public CategoryManagedBean() {
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    
    
    
    public Collection<Tblcategory> getAllCategory(){
        return adminBean.getAllCategory();
    }
    
    public String saveCategory(){
        if(this.CategoryId == 0){
            Tblcategory fiCategory = new Tblcategory();
            fiCategory.setCategoryName(this.CategoryName);
            
            adminBean.addCategory(fiCategory);
        }else{
            Tblcategory fiCategory = new Tblcategory();
            fiCategory.setCategoryId(this.CategoryId);
            fiCategory.setCategoryName(this.CategoryName);
            adminBean.updateCategory(fiCategory);
        }
        
        return "/faces/category.xhtml?faces-redirect=true";
    }
    
    public String removeCategory(int CategoryId_){
        adminBean.removeCategory(CategoryId_);
        return "/faces/category.xhtml?faces-redirect=true";
    }
    
    public String getCategory(int CategoryId_){
        Tblcategory fiCategory = adminBean.getCategory(CategoryId_);
        this.CategoryId = fiCategory.getCategoryId();
        this.CategoryName = fiCategory.getCategoryName();
        return "/faces/add-edit-category.xhtml?faces-redirect=true";
    }
    
    public String redirectToCategory(){
        return "/faces/category.xhtml?faces-redirect=true";
    }
    
    
    
}
