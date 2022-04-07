/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Request;
import com.online.course.course_ware.entity.User;
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
public interface RequestDao  extends JpaRepository<Request, Long>{
          @Query("SELECT r FROM Request r  JOIN  r.course c  WHERE c.courseId =:courseId")
     List<Request>  getAllRequestByCourseId(@Param (value ="courseId") Long courseId); 
      
     @Query("SELECT u FROM User u  LEFT OUTER JOIN  u.requests r  WHERE r.requestId =:requestId")
  User  getUserByRequestId(@Param (value ="requestId") Long requestId); 
      @Query("SELECT c FROM Course c  LEFT OUTER JOIN  c.requests r  WHERE r.requestId =:requestId")
 Course getCourseByRequestId(@Param (value ="requestId") Long requestId); 
}
