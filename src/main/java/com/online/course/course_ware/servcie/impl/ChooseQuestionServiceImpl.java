
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.ChooseQuestionDao;
import com.online.course.course_ware.dataAccess.QuestionCategoryDao;
import com.online.course.course_ware.entity.ChooseQuestion;
import com.online.course.course_ware.entity.QuestionCategory;
import com.online.course.course_ware.servcie.ChooseQuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChooseQuestionServiceImpl implements ChooseQuestionService{

    @Autowired
    private ChooseQuestionDao chooseQDao;
    @Autowired 
    private QuestionCategoryDao questionCatDao;
    
    
    @Override
    public ChooseQuestion saveChooseQuestion(Long questionCategoryId, ChooseQuestion cq) {
        QuestionCategory quCategory =null;
        try {
            quCategory = questionCatDao.getById(questionCategoryId);
            cq.setQuestionCategory(quCategory);
            cq = chooseQDao.save(cq);
            
        } catch (Exception e) {
            cq=null;
        }
    return cq;
    
    }

    @Override
    public ChooseQuestion updateChooseQuestion(Long chooseQuestionId, ChooseQuestion cq) {
        ChooseQuestion  chooseQue =null;
        try {
            chooseQue = chooseQDao.getById(chooseQuestionId);
            chooseQue.setChooseA(cq.getChooseA());
              chooseQue.setChooseB(cq.getChooseB());
                chooseQue.setChooseC(cq.getChooseC());
                  chooseQue.setChooseD(cq.getChooseD());
                  chooseQue.setQuestionName(cq.getQuestionName());
                  chooseQue =chooseQDao.save(chooseQue);
        } catch (Exception e) {
            chooseQue =null;
        }
    return chooseQue;
    }

    @Override
    public void deleteChooseQuestion(Long chooseQuestionId) {
        try {
            chooseQDao.deleteById(chooseQuestionId);
            
        } catch (Exception e) {
        }
 }

    @Override
    public List<ChooseQuestion> listChooseQuestionByQuestionCategory(Long questionCategoryId) {
       List<ChooseQuestion> listChooseQuestions = null;
        try {
            listChooseQuestions = chooseQDao.getAllChooseQuestionByQuestionCategoryId(questionCategoryId);
        } catch (Exception e) {
             listChooseQuestions =null;
        }
    return   listChooseQuestions;
    
    }
    
}
