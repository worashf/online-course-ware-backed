
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.AnswerDao;
import com.online.course.course_ware.dataAccess.BlankQuestionDao;
import com.online.course.course_ware.dataAccess.ChooseQuestionDao;
import com.online.course.course_ware.dataAccess.TFQuestionDao;
import com.online.course.course_ware.entity.Answer;
import com.online.course.course_ware.entity.BlankQuestion;
import com.online.course.course_ware.entity.ChooseQuestion;
import com.online.course.course_ware.entity.TFQuestion;
import com.online.course.course_ware.servcie.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl  implements AnswerService{
@Autowired
private AnswerDao ansDao;
@Autowired
private ChooseQuestionDao chooseQuestionDao;
@Autowired
private BlankQuestionDao blankQuestionDao;
@Autowired
private TFQuestionDao tfQuestionDao;

    
    @Override
    public Answer saveChooseAnswer(Long chooseQuestionId, Answer as) {
        ChooseQuestion chooseQuestion =null;
        try {
            chooseQuestion = chooseQuestionDao.getById(chooseQuestionId);
            as.setChooseQuestion(chooseQuestion);
            as = ansDao.save(as);
            
        } catch (Exception e) {
            as = null;
        }
    return as;
    }

    @Override
    public Answer saveBlankAnswer(Long blankQuestionId, Answer as) {
    BlankQuestion blankQuestion =null;
        try {
            blankQuestion = blankQuestionDao.getById(blankQuestionId);
            as.setBlakQuestion(blankQuestion);
            as = ansDao.save(as);
            
        } catch (Exception e) {
            as = null;
        }
    return as; }

    @Override
    public Answer saveTFAnswer(Long tfQuestionId, Answer as) {
   TFQuestion tfQuestion =null;
        try {
            tfQuestion = tfQuestionDao.getById(tfQuestionId);
            as.setTfQuestion(tfQuestion);
            as = ansDao.save(as);
            
        } catch (Exception e) {
            as = null;
        }
    return as;  }

    @Override
    public Answer updatAnswer(Long answerId, Answer as) {
    Answer ans = ansDao.getById(answerId);
        try {
            ans.setAnswerValue(as.getAnswerValue());
            ans = ansDao.save(ans);
            
        } catch (Exception e) {
            ans=null;
        }
        return ans;
    
    }

    @Override
    public void deleteAnswer(Long answerId) {
          try {
           ansDao.deleteById(answerId);
        } catch (Exception e) {
        }
    }

    @Override
    public Answer findChooseAnswer(Long chooseQuestionId) {
    Answer ans =null;
        try {
            ans = ansDao.findAnswerByChooseQuestionId(chooseQuestionId);
        } catch (Exception e) {
            ans =null;
        }
    
    return ans;
    }

    @Override
    public Answer findBlankAnswer(Long blankQuestionId) {
      Answer ans =null;
        try {
            ans = ansDao.findAnswerByBlankQuestionId(blankQuestionId);
        } catch (Exception e) {
            ans =null;
        }
    
    return ans;  
    }

    @Override
    public Answer findTfAnswer(Long tfQuestionId) {
  
     Answer ans =null;
        try {
            ans = ansDao.findAnswerByTFQuestionId(tfQuestionId);
        } catch (Exception e) {
            ans =null;
        }
    
    return ans;
    }
    
}
