/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.dataAccess.TopicDao;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Topic;
import com.online.course.course_ware.servcie.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mntemnte
 */
@Service
public class TopicServiceImpl implements TopicService{
    
    
 @Autowired
 private CourseDao courseDao;
 @Autowired
 private TopicDao topicDao;
    @Override
    public Topic saveTopic(Long courseId, Topic topic) {
         Course co = null;

        try {
            co = courseDao.getById(courseId);
            topic.setCourse(co);
            topic = topicDao.save(topic);
            
        } catch (Exception e) {
            topic =null;
        }
    return topic;
    }

    @Override
    public Topic updatTopic(Long topicId, Topic topic) {
        Topic to = null;
        try {
             to = topicDao.getById(topicId);
             to.setTopicName(topic.getTopicName());
             to = topicDao.save(to);
        } catch (Exception e) {
            to =null;
        }
  
   return to; 
    }

    @Override
    public void deleteTopic(Long topicId) {
        try {
             topicDao.deleteById(topicId);
        } catch (Exception e) {
        }
   }

    @Override
    public List<Topic> listTopics() {
        List<Topic> listTopic =null;
        try {
            listTopic = topicDao.findAll();
        } catch (Exception e) {
            listTopic =null;
        }
        
        return listTopic;
    }

    @Override
    public List<Topic> listTopicsByCourseId(Long courseId) {
        List<Topic> listTopic =null;
        try {
            listTopic = topicDao.getAllTopicByCourseId(courseId);
        } catch (Exception e) {
            listTopic =null;
        }
        
        return listTopic;
    }

    
}
