/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.contoller;


import com.online.course.course_ware.entity.Topic;
import com.online.course.course_ware.servcie.TopicService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *equ
 * @author mntemnte
 */
@RestController
@RequestMapping("/api")
public class TopicController {
    @Autowired
   private TopicService topicService;
    
    @PostMapping("/topics/{courseId}")
    public ResponseEntity<Topic> createTopic(@PathVariable Long courseId,@RequestBody Topic topic){
            Topic top  = topicService.saveTopic(courseId, topic);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "TopicController");
        return ResponseEntity.accepted().headers(headers).body(top);
    }
    
        @PutMapping("/topics/{topicId}")
    public ResponseEntity<Topic> updateTopic(
            @PathVariable Long topicId,
            @RequestBody Topic topic){
     Topic  top = topicService.updatTopic(topicId, topic);
       
        return ResponseEntity.ok().body(top);
    }

 @GetMapping("/topics")
 public  ResponseEntity<List<Topic>> ListAllTopics(){
   List<Topic> listTopic = topicService.listTopics();
   return  ResponseEntity.ok().body(listTopic);
 }
 
  @GetMapping("/topics/{courseId}")
 public  ResponseEntity<List<Topic>> ListAllTopicByCourse(@PathVariable Long courseId){
   List<Topic> listTopic = topicService.listTopicsByCourseId(courseId);
  
   return  ResponseEntity.ok().body(listTopic);
 }
 
   @DeleteMapping("/topics/{topicId}")
 public ResponseEntity<Map<String, Boolean>> deleteTopic(@PathVariable  Long topicId){
          
          topicService.deleteTopic(topicId);
   
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
}
