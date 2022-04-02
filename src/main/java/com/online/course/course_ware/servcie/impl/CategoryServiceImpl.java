/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CategoryDao;
import com.online.course.course_ware.entity.Category;
import com.online.course.course_ware.servcie.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deva
 */
@Service
public class CategoryServiceImpl  implements CategoryService{

    @Autowired
    private CategoryDao catDao;
    @Override
    public Category saveCategory(Category cat) {
        Category  category =null;
        try {
             category  = catDao.save(cat);
        } catch (Exception e) {
            category =null;
        }
        return category;
    }

    @Override
    public Category updatCategory(Long categoryId, Category cat) {
     Category category = catDao.getById(categoryId);
        try {
            category.setCategoryName(cat.getCategoryName());
            category = catDao.save(category);
            
        } catch (Exception e) {
            category =null;
        }
        return category;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        try {
            catDao.deleteById(categoryId);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Category> listCategories() {
       List<Category> listCat =null;
        try {
            listCat = catDao.findAll();
        } catch (Exception e) {
            listCat =null;
        }
        return listCat;
    }
    
}
