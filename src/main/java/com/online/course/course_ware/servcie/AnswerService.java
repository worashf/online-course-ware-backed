
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Answer;


public interface AnswerService {
      
    public Answer saveChooseAnswer(Long chooseQuestionId,Answer as);
    public Answer saveBlankAnswer(Long blankQuestionId,Answer as);
   public Answer saveTFAnswer(Long tfQuestionId,Answer as);
    public Answer updatAnswer(Long answerId,Answer as);
    public  void    deleteAnswer(Long answerId);
    public Answer findChooseAnswer(Long chooseQuestionId);
    public Answer findBlankAnswer(Long blankQuestionId);
        public Answer findTfAnswer(Long tfQuestionId);

}
