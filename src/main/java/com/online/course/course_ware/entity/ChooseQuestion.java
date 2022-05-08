/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "choose_question")
public class ChooseQuestion  implements  Serializable{
         @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="choose_question_id")
     private Long chooseQuestionId;
     @Column(name = "question_name")
     private String questionName;
     @Column(name="choose_a")
     private String chooseA;
    @Column(name="choose_b")
     private String chooseB;
    @Column(name="choose_c")
     private String chooseC;
     @Column(name="choose_d")
     private String chooseD;
    @OneToOne(mappedBy = "chooseQuestion")
    private Answer answer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="question_category_id")
    private QuestionCategory questionCategory;
    public Long getChooseQuestionId() {
        return chooseQuestionId;
    }

    public void setChooseQuestionId(Long chooseQuestionId) {
        this.chooseQuestionId = chooseQuestionId;
    }

   

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getChooseA() {
        return chooseA;
    }

    public void setChooseA(String chooseA) {
        this.chooseA = chooseA;
    }

    public String getChooseB() {
        return chooseB;
    }

    public void setChooseB(String chooseB) {
        this.chooseB = chooseB;
    }

    public String getChooseC() {
        return chooseC;
    }

    public void setChooseC(String chooseC) {
        this.chooseC = chooseC;
    }

    public String getChooseD() {
        return chooseD;
    }

    public void setChooseD(String chooseD) {
        this.chooseD = chooseD;
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
