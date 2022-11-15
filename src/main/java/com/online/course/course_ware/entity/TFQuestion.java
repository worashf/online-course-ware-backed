
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
@Table(name = "tf_question")
public class TFQuestion implements  Serializable{
           @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="tf_question_id")
    private Long tfQuestionId;
    @Column(name = "question_name")
    private String questionName;
     @OneToOne(mappedBy = "tfQuestion")
    private Answer answer; 
 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="question_category_id")
    private QuestionCategory questionCategory;
    public Long getTfQuestionId() {
        return tfQuestionId;
    }

    public void setTfQuestionId(Long tfQuestionId) {
        this.tfQuestionId = tfQuestionId;
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
