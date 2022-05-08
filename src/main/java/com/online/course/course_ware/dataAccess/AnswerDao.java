
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao  extends JpaRepository<Answer, Long>{
     @Query("SELECT as FROM Answer as  JOIN  as.chooseQuestion  cq WHERE cq.chooseQuestionId=:chooseQuestionId")
     Answer  findAnswerByChooseQuestionId(@Param (value ="chooseQuestionId") Long chooseQuestionId); 
       
     @Query("SELECT as FROM Answer as  JOIN  as.blankQuestion  bq WHERE bq.blankQuestionId=:blankQuestionId")
     Answer  findAnswerByBlankQuestionId(@Param (value ="blankQuestionId") Long blankQuestionId); 
      
     @Query("SELECT as FROM Answer as  JOIN  as.tfQuestion  tfq WHERE tfq.tfQuestionId=:tfQuestionId")
     Answer  findAnswerByTFQuestionId(@Param (value ="tfQuestionId") Long tfQuestionId); 
       
}
