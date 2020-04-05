/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Tblcategory;
import entities.Tblproduct;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author mitul
 */
@Local
public interface AdminBeanLocal {
    Collection<Tblcategory> getAllCategory();
    Tblcategory getCategory(int CategoryId);
    void addCategory(Tblcategory fiCategory);
    void updateCategory(Tblcategory fiCategory);
    void removeCategory(int CategoryId);
    
    
    Collection<Tblproduct> getAllProducts();
    Tblproduct getProduct(int ProductId);
    void addProduct(Tblproduct fiProduct);
    void updateProduct(Tblproduct fiProduct);
    void removeProduct(int ProductID);
}
