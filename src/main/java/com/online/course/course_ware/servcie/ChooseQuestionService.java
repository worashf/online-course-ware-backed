
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.ChooseQuestion;
import java.util.List;


public interface ChooseQuestionService {
       public ChooseQuestion saveChooseQuestion(Long questionCategoryId, ChooseQuestion cq);
    public ChooseQuestion updateChooseQuestion(Long chooseQuestionId,ChooseQuestion cq);
    public  void    deleteChooseQuestion(Long chooseQuestionId);
    public  List<ChooseQuestion> listChooseQuestionByQuestionCategory(Long questionCategoryId);
}
