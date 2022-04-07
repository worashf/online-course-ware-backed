/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mntemnte
 */
@Repository
public interface CourseDao extends JpaRepository<Course, Long>{
       @Query("SELECT co FROM Course  co  JOIN  co.category c  WHERE c.categoryId =:categoryId")
     List<Course>  getAllCourseByCategoryId(@Param (value ="categoryId") Long categoryId); 
          @Query("SELECT co FROM Course  co  JOIN  co.user u  WHERE u.userName =:userName")
     List<Course>  getAllCourseByUserName(@Param (value ="userName") String userName); 
}
