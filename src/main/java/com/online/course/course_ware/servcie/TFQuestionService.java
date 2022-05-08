
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.TFQuestion;
import java.util.List;


public interface TFQuestionService {
    
    public TFQuestion saveTFQuestion(Long questionCategoryId, TFQuestion tfq);
    public TFQuestion updateTFQuestion(Long tfQuestionId,TFQuestion tfq);
    public  void    deleteTFQuestion(Long tfQuestionId);
    public  List<TFQuestion> listTFQuestionByQuestionCategory(Long questionCategoryId);
  
}
