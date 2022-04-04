/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.contoller;


import com.online.course.course_ware.entity.Course;

import com.online.course.course_ware.servcie.CourseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
public class CourseController {

     
     @Autowired
     private CourseService courseService;
    
    @PostMapping("/courses/{categoryId}")
    public ResponseEntity<Course> createCourse(@PathVariable Long categoryId,@RequestBody Course course){
          Course co = courseService.saveCourse(categoryId, course);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(co);
    }
    
        @PutMapping("/course/{categoryId}/courseId")
    public ResponseEntity<Course> updateCourse(@PathVariable Long categoryId,
            @PathVariable Long courseId,
            @RequestBody Course course){
      Course co = courseService.updatCourse(categoryId, courseId, course);
       
        return ResponseEntity.ok().body(co);
    }
 @GetMapping("/courses")
 public  ResponseEntity<List<Course>> ListAllCourses(){
   List<Course> listCourse = courseService.listCourses();
   return  ResponseEntity.ok().body(listCourse);
 }
 @GetMapping("/courses/{cateoryId}")
 public  ResponseEntity<List<Course>> ListAllCoursesByCategory(@PathVariable Long categoryId){
   List<Course> listCourse = courseService.listCoursesByCategoryId(categoryId);
   return  ResponseEntity.ok().body(listCourse);
 }
   @DeleteMapping("/courses/{courseId}")
 public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable  Long courseId){
          
     courseService.deleteCourse(courseId);
   
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
}
