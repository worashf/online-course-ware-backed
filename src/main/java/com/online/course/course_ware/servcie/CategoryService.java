/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Category;
import java.util.List;

/**
 *
 * @author deva
 */
public interface CategoryService {
    
    public Category saveCategory(Category cat);
    public Category updatCategory(Long categoryId,Category  cat);
    public  void    deleteCategory(Long categoryId);
    public  List<Category> listCategories();
       
}
