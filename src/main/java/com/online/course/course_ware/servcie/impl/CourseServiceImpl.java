/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CategoryDao;
import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.dataAccess.StudentDao;
import com.online.course.course_ware.dataAccess.UserDao;
import com.online.course.course_ware.entity.Category;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Student;
import com.online.course.course_ware.entity.User;
import com.online.course.course_ware.servcie.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
@Autowired
private UserDao userDao;
@Autowired
private StudentDao studDao;

    
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
    public Course updatCourse(Long courseId, Course course) {
        
         Course co = null;
        try {

             co = courseDao.getById(courseId);
             co.setCourseName(course.getCourseName());
             co.setDescription(course.getDescription());
             co.setObjective(course.getObjective());
             co.setRequirements(course.getRequirements());
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

    @Transactional
    @Override
    public List<Course> listCoursesByCategoryId(Long categoryId) {
            List<Course> listCourse =null;
        try {
            listCourse = courseDao.getAllCourseByCategoryId(categoryId);
            
        } catch (Exception e) {
            listCourse = null;
        }
        return  listCourse;
    }

    @Override
    public List<Course> listCoursesByUser(String userName) {
              List<Course> listCourse =null;
        try {
            listCourse = courseDao.getAllCourseByUserName(userName);
            
        } catch (Exception e) {
            listCourse = null;
        }
        return  listCourse;
    }

    @Override
    public String uploadCourseThumbnail(Long courseId, MultipartFile file) {
       Course course = null;
       String message = null;
       try {
             course = courseDao.getById(courseId);
//              course.setThumbnail(filePath);
              course = courseDao.save(course);
              message ="success";
        } catch (Exception e) {
            course =null;
            message="error";
        }
       return message;
    
    }

    @Override
    public List<Course> listCoursesByStudent(String userName) {
            List<Course> listCourse =null;
             User user = userDao.findByUserName(userName);
            Student stud = studDao.getStudentByUserId(user.getUserId());
        try {
            listCourse = courseDao.getCourseByStudentId(stud.getStudentId());
             System.out.println(user.getUserId());
             System.out.println(stud.getStudentId());
             System.out.println(listCourse);
             
        } catch (Exception e) {
            listCourse = null;
        }
        return  listCourse; 
    
    }

    @Override
    public Course findCourse(Long courseId) {
        Course cou =null;
        try {
            cou = courseDao.findByCourseId(courseId);
        } catch (Exception e) {
            cou =null;
        }
     return  cou;
    
    }

    
   
    
}
