
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.dataAccess.QuestionCategoryDao;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.QuestionCategory;
import com.online.course.course_ware.servcie.QuestionCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionCategoryServiceImpl  implements QuestionCategoryService{
@Autowired
private QuestionCategoryDao questionCatDao;
@Autowired
private CourseDao couDao;
    
    @Override
    public QuestionCategory saveQuestionCategory(Long courseId, QuestionCategory qc) {
       Course course =null;
        try {
            course = couDao.getById(courseId);
            qc.setCourse(course);
            qc= questionCatDao.save(qc);
        } catch (Exception e) {
            qc=null;
        }
    return qc;
    }

    @Override
    public QuestionCategory updatQuestionCategory(Long questionCategoryId,
            QuestionCategory qc) {
     QuestionCategory queCategory = questionCatDao.getById(questionCategoryId);
        try {
            queCategory.setQuestionCategoryName(qc.getQuestionCategoryName());
            queCategory =questionCatDao.save(queCategory);
            
        } catch (Exception e) {
           queCategory =null;
        }
        return  queCategory;   
    
    }

    @Override
    public void deleteQuestionCategory(Long questionCategoryId) {
      try {
           questionCatDao.deleteById(questionCategoryId);
        } catch (Exception e) {
        } }

    @Override
    public List<QuestionCategory> listQuestionCategoryByCourse(Long courseId) {
       List<QuestionCategory> listQueCate =null;
        try {
            listQueCate = questionCatDao.getAllQuestionCategoryByCourseId(courseId);
        } catch (Exception e) {
            listQueCate =null;
        }
    
    return listQueCate;
    }
    
}
