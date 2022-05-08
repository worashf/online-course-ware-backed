
package com.online.course.course_ware.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "question_category")
public class QuestionCategory  implements  Serializable{
       @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="question_category_id")
    private Long questionCategoryId;
    @Column(name = "question_category_name")
    private String questionCategoryName;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="course_id")
    private Course course;
     @OneToMany(mappedBy = "questionCategory",fetch = FetchType.LAZY)
    private Set<TFQuestion> tfQuestions;

     @OneToMany(mappedBy = "questionCategory",fetch = FetchType.LAZY)
    private Set<ChooseQuestion> chooseQuestions;
      @OneToMany(mappedBy = "questionCategory",fetch = FetchType.LAZY)
    private Set<BlankQuestion> blankQuestions;

    public Long getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(Long questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public String getQuestionCategoryName() {
        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName) {
        this.questionCategoryName = questionCategoryName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<TFQuestion> getTfQuestions() {
        return tfQuestions;
    }

    public void setTfQuestions(Set<TFQuestion> tfQuestions) {
        this.tfQuestions = tfQuestions;
    }

    public Set<ChooseQuestion> getChooseQuestions() {
        return chooseQuestions;
    }

    public void setChooseQuestions(Set<ChooseQuestion> chooseQuestions) {
        this.chooseQuestions = chooseQuestions;
    }

    public Set<BlankQuestion> getBlankQuestions() {
        return blankQuestions;
    }

    public void setBlankQuestions(Set<BlankQuestion> blankQuestions) {
        this.blankQuestions = blankQuestions;
    }
    
}
