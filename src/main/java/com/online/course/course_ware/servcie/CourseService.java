/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Course;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author deva
 */
public interface CourseService {
    public Course saveCourse(Long categoryId,Course course);
    public Course updatCourse( Long courseId,Course course);
    public Course findCourse(Long courseId);
    public  void    deleteCourse(Long courseId);
    public  List<Course> listCourses();
    public  List<Course> listCoursesByCategoryId(Long categoryId);
      public  List<Course> listCoursesByUser(String userName);
        public  List<Course> listCoursesByStudent(String userName);
      public String  uploadCourseThumbnail(Long courseId, MultipartFile file);
}
