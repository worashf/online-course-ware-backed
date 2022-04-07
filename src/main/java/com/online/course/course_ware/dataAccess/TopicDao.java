/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Topic;
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
public interface TopicDao extends JpaRepository<Topic, Long>{
   @Query("SELECT t FROM Topic t  JOIN   t.course c  WHERE c.courseId =:courseId")
   List<Topic>  getAllTopicByCourseId(@Param (value ="courseId") Long courseId); 
    
    
    
}
