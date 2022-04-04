/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.RoleDao;
import com.online.course.course_ware.dataAccess.UserDao;
import com.online.course.course_ware.entity.Role;
import com.online.course.course_ware.entity.User;
import com.online.course.course_ware.servcie.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author mntemnte
 */
@Service("userDetailService")
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    private UserDao  userDao;
    @Autowired
    private RoleDao roleDao;
    @Override
    public User saveUser(Long roleId,User user) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         Role role = roleDao.getById(roleId);
          System.out.println(role);
        try {
         
              user.setPassword(encoder.encode(user.getPassword()));
              user.setStatus("enabled");
                user.addRole(role);
              user = userDao.save(user);
            
            
                 System.out.println(user);
            
        } catch (Exception e) {
            user =null;
        }
        return user;
    }

    @Override
    public User updatUser(Long userId, User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(Long userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> listUsers() {
      List<User > listUser = null;
        try {
             listUser = userDao.findAll();
        } catch (Exception e) {
        }
  return  listUser;
    }    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.findByUserName(username);
    if(user == null){
        throw  new UsernameNotFoundException("no user with this user name found");
    }
    else{
           Collection<SimpleGrantedAuthority> authList =  new ArrayList<>();
           user.getRoles().forEach(role -> {
            authList.add(new SimpleGrantedAuthority(role.getRoleName()));
           });
        return new org.springframework.security.core.userdetails.User(
					user.getUserName(),
                                        user.getPassword(),
					authList);
    }
  
    }
    
}
