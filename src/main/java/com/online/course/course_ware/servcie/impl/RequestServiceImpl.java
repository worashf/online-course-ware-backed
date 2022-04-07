/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.dataAccess.RequestDao;
import com.online.course.course_ware.dataAccess.UserDao;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Request;
import com.online.course.course_ware.entity.User;
import com.online.course.course_ware.servcie.RequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mntemnte
 */
@Service
public class RequestServiceImpl implements RequestService{
      @Autowired
      private RequestDao requestDao;
      @Autowired
      private CourseDao courseDao;
      @Autowired 
      private  UserDao userDao;
    
    
    @Override
    public Request saveRequest(Long courseId, String userName, Request req) {
        Course co = null;
        User user = null;
        
        try {
             co = courseDao.getById(courseId);
             user = userDao.findByUserName(userName);
             req.setCourse(co);
             req.setUser(user);
             req = requestDao.save(req);
            
        } catch (Exception e) {
            req =null;
        }
    return req;
    
    }

    @Override
    public Request updatRequest(Long requestId, Request req) {
        Request request = requestDao.getById(requestId);
        try {
            request.setRequestName(req.getRequestName());
         request.setExperiance(req.getExperiance());
         request.setReason(req.getReason());
         request = requestDao.save(request);
            
        } catch (Exception e) {
           request =null;
        }
        return request;
    }

    @Override
    public void deleteRequest(Long requestId) {
        try {
            requestDao.deleteById(requestId);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Request> listRequests() {
  List<Request> listReq = null;
        try {
            listReq = requestDao.findAll();
        } catch (Exception e) {
            listReq =null;
        }
        return  listReq;
        
    }

    @Transactional
    @Override
    public List<Request> listRequestsByCourseId(Long courseId) {
       List<Request> listReq =null;
        try {
            listReq = requestDao.getAllRequestByCourseId(courseId);
        } catch (Exception e) {
            listReq =null;
        }
    return listReq;
    }

    @Override
    public User getUserByRequestId(Long requestId) {
        User u = null;
        try {
             u = requestDao.getUserByRequestId(requestId);
        } catch (Exception e) {
        }
    return u;
    }

    @Override
    public Course getCourseByRequestId(Long requestId) {
      
  Course c = null;
        try {
             c= requestDao.getCourseByRequestId(requestId);
        } catch (Exception e) {
        }
    return c;
    }

    @Override
    public Request approveRequest(Long requestId, Long userId, Long courseId) {
       Request req = null;
       User user =null;
       Course co =null;
     
        try {
            
            req = requestDao.getById(requestId);
            user = userDao.getById(userId);
            co = courseDao.getById(courseId);
              user.setIsTeacher(true);
              user = userDao.save(user);
              co.setUser(user);
             co = courseDao.save(co);
             req.setRequestStatus("approved");
             req = requestDao.save(req);
            
            
        } catch (Exception e) {
        }
   return  req;
    
    
    }
    
}
