
package com.online.course.course_ware.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blank_question")
public class BlankQuestion implements Serializable{
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="blank_question_id")
    private Long blankQuestionId;
    @Column(name = "question_name")
    private String questionName;
     @OneToOne(mappedBy = "blankQuestion")
    private Answer answer; 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="question_category_id")
    private QuestionCategory questionCategory;

    public Long getBlankQuestionId() {
        return blankQuestionId;
    }

    public void setBlankQuestionId(Long blankQuestionId) {
        this.blankQuestionId = blankQuestionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(QuestionCategory questionCategory) {
        this.questionCategory = questionCategory;
    }


     
     
    
    
    
}
