/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mntemnte
 */
@Repository
public interface UserDao  extends JpaRepository<User, Long>{
     public User  findByUserName(String userName);
}
