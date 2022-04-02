/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Course;
import java.util.List;

/**
 *
 * @author deva
 */
public interface CourseService {
    public Course saveCourse(Long categoryId,Course course);
    public Course updatCourse(Long categoryId, Long courseId,Course course);
    public  void    deleteCourse(Long courseId);
    public  List<Course> listCourses();
    public  List<Course> listCoursesByCategoryId(Long categoryId);
}
