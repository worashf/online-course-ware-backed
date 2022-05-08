
package com.online.course.course_ware.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer  implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="answer_id")
    private Long answerId;
     @Column(name = "answer_value")
     private String answerValue;
      @OneToOne
     @JoinColumn(name = "choose_question_id")
    private ChooseQuestion chooseQuestion;
      @OneToOne
     @JoinColumn(name = "blank_question_id")
    private BlankQuestion blankQuestion;
      @OneToOne
     @JoinColumn(name = "tf_question_id")
    private TFQuestion tfQuestion;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    public ChooseQuestion getChooseQuestion() {
        return chooseQuestion;
    }

    public void setChooseQuestion(ChooseQuestion chooseQuestion) {
        this.chooseQuestion = chooseQuestion;
    }

    public BlankQuestion getBlakQuestion() {
        return blankQuestion;
    }

    public void setBlakQuestion(BlankQuestion blankQuestion) {
        this.blankQuestion = blankQuestion;
    }

    public TFQuestion getTfQuestion() {
        return tfQuestion;
    }

    public void setTfQuestion(TFQuestion tfQuestion) {
        this.tfQuestion = tfQuestion;
    }

 
      
      
      
}
