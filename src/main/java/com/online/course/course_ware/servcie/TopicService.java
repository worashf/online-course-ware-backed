/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Topic;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface TopicService {
        public Topic  saveTopic(Long courseId,Topic topic);
    public Topic  updatTopic( Long topicId,Topic topic);
    public  void    deleteTopic(Long topicId);
    public  List<Topic> listTopics();
    public  List<Topic> listTopicsByCourseId(Long courseId);
 
}
