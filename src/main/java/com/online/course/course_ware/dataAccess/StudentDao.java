
package com.online.course.course_ware.dataAccess;


import com.online.course.course_ware.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

/**
 *
 * @author mntemnte
 */
@Repository
public interface StudentDao extends  JpaRepository<Student, Long>{

      public Student  findByStudentCode(String studentCode);
          
 @Query("SELECT s FROM Student s  LEFT OUTER JOIN  s.user u  WHERE u.userId =:userId")
  Student  getStudentByUserId(@Param (value ="userId") Long userId); 
    
}
