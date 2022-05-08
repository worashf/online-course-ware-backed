
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.BlankQuestion;
import com.online.course.course_ware.entity.QuestionCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlankQuestionDao extends JpaRepository<BlankQuestion, Long>{
         @Query("SELECT bq FROM BlankQuestion bq  JOIN  bq.questionCategory qc   WHERE"
                 + " qc.questionCategoryId=:questionCategoryId")
     List<BlankQuestion>  getAllBlankQuestionByQuestionCategoryId(@Param (value ="questionCategoryId") 
             Long questionCategoryId);
    
}
