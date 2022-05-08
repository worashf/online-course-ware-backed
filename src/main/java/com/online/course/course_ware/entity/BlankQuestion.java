
package com.online.course.course_ware.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    
    
}
