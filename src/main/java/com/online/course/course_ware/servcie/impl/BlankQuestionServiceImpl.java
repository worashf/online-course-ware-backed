
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.BlankQuestionDao;
import com.online.course.course_ware.dataAccess.QuestionCategoryDao;
import com.online.course.course_ware.entity.BlankQuestion;
import com.online.course.course_ware.entity.QuestionCategory;
import com.online.course.course_ware.servcie.BlankQuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlankQuestionServiceImpl implements  BlankQuestionService{
@Autowired
private BlankQuestionDao blankQuestionDao;
 @Autowired 
 private QuestionCategoryDao questionCatDao;
    @Override
    public BlankQuestion saveBlankQuestion(Long questionCategoryId, BlankQuestion bq) {
  
           QuestionCategory queCategory =null;
        try {
            queCategory = questionCatDao.getById(questionCategoryId);
            bq.setQuestionCategory(queCategory);
            bq = blankQuestionDao.save(bq);
        } catch (Exception e) {
            bq =null;
        }
    return  bq;
    }

    @Override
    public BlankQuestion updateBlankQuestion(Long chooseQuestionId, BlankQuestion bq) {
            BlankQuestion  bqQue =null;
        try {
            bqQue = blankQuestionDao.getById(chooseQuestionId);
           bqQue.setQuestionName(bq.getQuestionName());
           bqQue = blankQuestionDao.save(bqQue);
        } catch (Exception e) {
            bqQue =null;
        }
    return bqQue; 
    }

    @Override
    public void deleteBlankQuestion(Long blankQuestionId) {
        try {
            blankQuestionDao.deleteById(blankQuestionId);
        } catch (Exception e) {
        }
    
    }

    @Override
    public List<BlankQuestion> listBlankQuestionByQuestionCategory(Long questionCategoryId) {
          List<BlankQuestion> listBlankQuestions = null;
        try {
       listBlankQuestions = blankQuestionDao.getAllBlankQuestionByQuestionCategoryId(questionCategoryId);
        } catch (Exception e) {
             listBlankQuestions  =null;
        }
    return   listBlankQuestions ;
    
    }
    
}
