
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao  extends JpaRepository<Answer, Long>{
     @Query("SELECT as1 FROM Answer as1 LEFT OUTER JOIN  as1.chooseQuestion cq WHERE cq.chooseQuestionId=:chooseQuestionId")
   public  Answer  findAnswerByChooseQuestionId(@Param (value ="chooseQuestionId") Long chooseQuestionId); 
       
     @Query("SELECT as2 FROM Answer as2  LEFT OUTER JOIN as2.blankQuestion  bq WHERE bq.blankQuestionId=:blankQuestionId")
     Answer  findAnswerByBlankQuestionId(@Param (value ="blankQuestionId") Long blankQuestionId); 
      
     @Query("SELECT as3 FROM Answer as3  LEFT OUTER JOIN as3.tfQuestion  tfq WHERE tfq.tfQuestionId=:tfQuestionId")
     Answer  findAnswerByTFQuestionId(@Param (value ="tfQuestionId") Long tfQuestionId); 
       
         

}
