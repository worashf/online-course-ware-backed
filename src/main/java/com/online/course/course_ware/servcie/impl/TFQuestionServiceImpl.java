
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.QuestionCategoryDao;
import com.online.course.course_ware.dataAccess.TFQuestionDao;
import com.online.course.course_ware.entity.QuestionCategory;
import com.online.course.course_ware.entity.TFQuestion;
import com.online.course.course_ware.servcie.TFQuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TFQuestionServiceImpl implements  TFQuestionService{
@Autowired
private TFQuestionDao tfQuestionDao;
 @Autowired 
 private QuestionCategoryDao questionCatDao;
    
    @Override
    public TFQuestion saveTFQuestion(Long questionCategoryId, TFQuestion tfq) {
       QuestionCategory queCategory =null;
        try {
            queCategory = questionCatDao.getById(questionCategoryId);
            tfq.setQuestionCategory(queCategory);
            tfq = tfQuestionDao.save(tfq);
        } catch (Exception e) {
            tfq =null;
        }
    return  tfq;
    }

    @Override
    public TFQuestion updateTFQuestion(Long tfQuestionId, TFQuestion tfq) {
   
          TFQuestion  tfQue =null;
        try {
            tfQue = tfQuestionDao.getById(tfQuestionId);
           tfQue.setQuestionName(tfq.getQuestionName());
           tfQue = tfQuestionDao.save(tfq);
        } catch (Exception e) {
            tfQue =null;
        }
    return tfQue;
    
    }

    @Override
    public void deleteTFQuestion(Long tfQuestionId) {
        try {
            tfQuestionDao.deleteById(tfQuestionId);
        } catch (Exception e) {
        }
    
    
    }

    @Override
    public List<TFQuestion> listTFQuestionByQuestionCategory(Long questionCategoryId) {
         List<TFQuestion> listTFQuestions = null;
        try {
            listTFQuestions = tfQuestionDao.getAllTFQuestionByQuestionCategoryId(questionCategoryId);
        } catch (Exception e) {
             listTFQuestions  =null;
        }
    return   listTFQuestions ;
    
    
    }
    
}
