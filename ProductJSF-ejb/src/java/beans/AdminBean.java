/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Tblcategory;
import entities.Tblproduct;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mitul
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    @Override
    public Collection<Tblcategory> getAllCategory() {
       return em.createNamedQuery("Tblcategory.findAll").getResultList();
    }

    @Override
    public Tblcategory getCategory(int CategoryId) {
        Tblcategory foCategory = em.find(Tblcategory.class, CategoryId);
        return foCategory;
    }

    @Override
    public void addCategory(Tblcategory fiCategory) {
        em.persist(fiCategory);
    }

    @Override
    public void updateCategory(Tblcategory fiCategory) {
        Tblcategory foCategory = em.find(Tblcategory.class, fiCategory.getCategoryId());
        foCategory.setCategoryName(fiCategory.getCategoryName());
        em.merge(foCategory);
    }

    @Override
    public void removeCategory(int CategoryId) {
        Tblcategory foCategory = em.find(Tblcategory.class, CategoryId);
        em.remove(foCategory);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Tblproduct> getAllProducts() {
        return em.createNamedQuery("Tblproduct.findAll").getResultList();
    }

    @Override
    public Tblproduct getProduct(int ProductId) {
        Tblproduct foProduct = em.find(Tblproduct.class, ProductId);
        return foProduct;
    }

    @Override
    public void addProduct(Tblproduct fiProduct) {
        Tblcategory fiCategory = em.find(Tblcategory.class, fiProduct.getCategoryId().getCategoryId());
        Collection<Tblproduct> CollectionProduct = fiCategory.getTblproductCollection();
        CollectionProduct.add(fiProduct);
        em.persist(fiProduct);
        em.merge(fiCategory);
    }

    @Override
    public void updateProduct(Tblproduct fiProduct) {
        Tblcategory foCategory = em.find(Tblcategory.class, fiProduct.getCategoryId().getCategoryId());
        Tblproduct foProduct = em.find(Tblproduct.class, fiProduct.getProductId());
        foProduct.setCategoryId(fiProduct.getCategoryId());
        foProduct.setDescription(fiProduct.getDescription());
        foProduct.setPrice(fiProduct.getPrice());
        foProduct.setProductName(fiProduct.getProductName());   
        
        Collection<Tblproduct> CollectionProduct = foCategory.getTblproductCollection();
        CollectionProduct.add(foProduct);
        
        em.merge(foCategory);
        em.merge(foProduct);
        
        
    }

    @Override
    public void removeProduct(int ProductID) {
        Tblproduct fiProduct = em.find(Tblproduct.class, ProductID);
        em.remove(fiProduct);
    }
}
