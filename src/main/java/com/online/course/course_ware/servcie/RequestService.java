/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Category;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Request;
import com.online.course.course_ware.entity.User;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface RequestService {
    
    public Request saveRequest(Long courseId, String userName ,Request req);
    public Request updatRequest(Long requestId,Request req);
    public  void    deleteRequest(Long requestId);
    public  List<Request> listRequests();
    public  List<Request> listRequestsByCourseId(Long courseId);
    public User getUserByRequestId(Long requestId);
      public Course getCourseByRequestId(Long requestId);
        public Request approveRequest(Long requestId, Long userId, Long courseId);
}
