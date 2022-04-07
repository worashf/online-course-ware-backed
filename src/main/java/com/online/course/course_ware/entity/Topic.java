/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author deva
 */
@Entity
@Table(name ="topic")
public class Topic implements Serializable{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="topic_id")
    private Long topicId;
    @Column(name ="topic_name")
    private String topicName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="course_id")
    private Course course;
    
    @JsonBackReference(value = "course-topic")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    
    
    
    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
    
}
