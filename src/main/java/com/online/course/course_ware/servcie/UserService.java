/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.User;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface UserService {
       public User saveUser ( Long roleId ,User user);
    public User updatUser(Long userId,User user);
    public  void    deleteUser(Long userId);
    public  List<User> listUsers();
    
}
