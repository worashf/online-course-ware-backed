/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.contoller;

import com.online.course.course_ware.entity.Category;
import com.online.course.course_ware.servcie.CategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mntemnte
 */
 @RestController
 @RequestMapping("/api")

public class CategoryController {
   
    @Autowired
     private CategoryService catService;
    
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category cat){
         Category savedCat = catService.saveCategory(cat);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(savedCat);
    }
    
        @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long categoryId,@RequestBody Category cat){
         Category updatedCat = catService.updatCategory(categoryId, cat);
       
        return ResponseEntity.ok(updatedCat);
    }
 @GetMapping("/categories")
 public  ResponseEntity<List<Category>> ListAllCategories(){
   List<Category> catList =  catService.listCategories();
   return  ResponseEntity.ok().body(catList);
 }

   @DeleteMapping("/categories/{categoryId}")
 public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable  Long categoryId){
          
     catService.deleteCategory(categoryId);
     
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
}

