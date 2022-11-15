
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.QuestionCategory;
import java.util.List;


public interface QuestionCategoryService {
       
    public QuestionCategory saveQuestionCategory(Long courseId, QuestionCategory qc);
    public QuestionCategory updatQuestionCategory(Long questionCategoryId,QuestionCategory qc);
    public  void    deleteQuestionCategory(Long questionCategoryId);
    public  List<QuestionCategory> listQuestionCategoryByCourse(Long courseId);
}
