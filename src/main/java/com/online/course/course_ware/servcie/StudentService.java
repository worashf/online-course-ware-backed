/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Student;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface StudentService {
    
    public Student saveStudent(Student stud);
   public  Student  enrollToCourse(Student stud,Long courseId);
    public Student updatStudent(Long studnetId,Student stud);
    public  void    deleteStudnet(Long studnetId);
    public  List<Student> listStudents();

}
