/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CategoryDao;
import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.entity.Category;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.servcie.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author deva
 */
@Service
public class CourseServiceImpl implements CourseService{
@Autowired
private CategoryDao catDao;
@Autowired
private CourseDao courseDao;

    
    @Override
    public Course saveCourse(Long categoryId, Course course) {
       Category cat = null;
    
        try {
             cat = catDao.getById(categoryId);
             course.setCategory(cat);
             course = courseDao.save(course);
            
        } catch (Exception e) {
            course = null;
        }
         return course;
    }

    @Override
    public Course updatCourse(Long categoryId, Long courseId, Course course) {
         Category cate = null;
         Course co = null;
        try {
             cate = catDao.getById(categoryId);
             co = courseDao.getById(courseId);
             co.setCategory(cate);
             co.setCourseName(course.getCourseName());
             co = courseDao.save(co);
        } catch (Exception e) {
            co =null;
        }
        return co;
    }

    @Override
    public void deleteCourse(Long courseId) {
        try {
             courseDao.deleteById(courseId);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Course> listCourses() {
           List<Course> listCourse =null;
        try {
         
           listCourse = courseDao.findAll();
        } catch (Exception e) {
            listCourse =null;
        }
        return listCourse;
    }

    @Override
    public List<Course> listCoursesByCategoryId(Long categoryId) {
        try {
            
        } catch (Exception e) {
        }
        return  null;
    }
    
}
