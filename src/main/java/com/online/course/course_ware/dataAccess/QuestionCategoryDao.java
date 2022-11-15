
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.QuestionCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionCategoryDao  extends JpaRepository<QuestionCategory, Long>{
     @Query("SELECT qc FROM QuestionCategory qc  JOIN  qc.course c  WHERE c.courseId=:courseId")
     List<QuestionCategory>  getAllQuestionCategoryByCourseId(@Param (value ="courseId") Long courseId); 
}
