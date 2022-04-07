/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mntemnte
 */
@Entity
@Table(name = "request")
public class Request implements Serializable{
       @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="request_id")
    private Long requestId; 
    @Column(name = "request_name") 
    private String requestName;
    @Column(name ="experiance")
    @Lob
    private String experiance;
    @Column(name ="reason")
    @Lob
    private  String reason;
    @Column(name = "request_status")
     private String  requestStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="course_id")
    private Course course;
      @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    private User user;

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
      
   @JsonBackReference(value = "user-request")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
      
      
   @JsonBackReference(value = "course-request")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getExperiance() {
        return experiance;
    }

    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
       
       
}
