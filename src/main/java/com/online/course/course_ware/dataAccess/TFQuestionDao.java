
package com.online.course.course_ware.dataAccess;


import com.online.course.course_ware.entity.TFQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TFQuestionDao  extends JpaRepository<TFQuestion, Long>{
          @Query("SELECT tfq FROM TFQuestion tfq  JOIN  tfq.questionCategory qc   WHERE"
                 + " qc.questionCategoryId=:questionCategoryId")
     List<TFQuestion>  getAllTFQuestionByQuestionCategoryId(@Param (value ="questionCategoryId") 
             Long questionCategoryId);
}
