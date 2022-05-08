
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.ChooseQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChooseQuestionDao extends  JpaRepository<ChooseQuestion, Long>{
       @Query("SELECT cq FROM ChooseQuestion cq  JOIN  cq.questionCategory qc   WHERE"
                 + " qc.questionCategoryId=:questionCategoryId")
     List<ChooseQuestion>  getAllChooseQuestionByQuestionCategoryId(@Param (value ="questionCategoryId") 
             Long questionCategoryId);
    
}
