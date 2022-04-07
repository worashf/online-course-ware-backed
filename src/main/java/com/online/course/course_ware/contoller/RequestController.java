/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.contoller;


import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Request;
import com.online.course.course_ware.entity.User;
import com.online.course.course_ware.servcie.RequestService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mntemnte
 */
 @RestController
 @RequestMapping("/api")
public class RequestController {
      @Autowired
     private RequestService reqService;
    
    @PostMapping("/requests/{courseId}/{userName}")
    public ResponseEntity<Request> createRequest(@PathVariable Long courseId, 
            @PathVariable String userName,
      @RequestBody Request req){
 Request request = reqService.saveRequest(courseId, userName, req);
        System.out.println(courseId + " " + userName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "RequestController");
        return ResponseEntity.accepted().headers(headers).body(request);
    }
    
        @PutMapping("/requests/{requestId}")
    public ResponseEntity<Request> updateRequest(@PathVariable Long requestId,@RequestBody Request req){
        Request request = reqService.updatRequest(requestId, req);
       
        return ResponseEntity.ok(request);
    }
 @GetMapping("/requests")
 public  ResponseEntity<List<Request>> ListAllReuqests(){
  List<Request> listReq = reqService.listRequests();
          
   return  ResponseEntity.ok().body(listReq);
 }
  @GetMapping("/requests/{courseId}")
 public  ResponseEntity<List<Request>> ListAllRequestsByCourse(@PathVariable Long courseId){
  List<Request> listReq = reqService.listRequestsByCourseId(courseId);
  
   return  ResponseEntity.ok().body(listReq);
 }
   @GetMapping("/user/requests/{requestId}")
 public  ResponseEntity<User>  findUserByRequestId(@PathVariable Long requestId){
  User user= reqService.getUserByRequestId(requestId);
  System.out.print(requestId);
   return  ResponseEntity.ok().body(user);
 }
    @GetMapping("/course/requests/{requestId}")
 public  ResponseEntity<Course>  findCourseByRequestId(@PathVariable Long requestId){
 Course c = reqService.getCourseByRequestId(requestId);
  System.out.print(requestId);
   return  ResponseEntity.ok().body(c);
 }
    @PostMapping("/requests/approve/{requestId}")
 public  ResponseEntity<Request>  aproveRequest(@PathVariable Long requestId,
         @RequestParam Long userId,@RequestParam Long courseId){
Request req = reqService.approveRequest(requestId, userId, courseId);
  System.out.print(requestId);
   return  ResponseEntity.ok().body(req);
 }
   @DeleteMapping("/requests/{requestId}")
 public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable  Long requestId){
          
        reqService.deleteRequest(requestId);
    Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
}



