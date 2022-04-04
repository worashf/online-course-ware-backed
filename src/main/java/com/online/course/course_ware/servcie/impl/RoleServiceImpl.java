/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.RoleDao;
import com.online.course.course_ware.entity.Role;
import com.online.course.course_ware.servcie.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mntemnte
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    
    @Override
    public Role saveRole(Role role) {
       Role rol = null;
        try {
           rol  = roleDao.save(role);
        } catch (Exception e) {
            rol =null;
        }
    return rol;    
    }

    @Override
    public Role updateRole(Long roleId, Role role) {
       Role rol = null;
        try {
            rol = roleDao.getById(roleId);
            rol.setRoleName(role.getRoleName());
           rol  = roleDao.save(rol);
        } catch (Exception e) {
            rol = null;
        }
        return rol;
    }

    @Override
    public void deleteRole(Long roleId) {
        try {
           roleDao.deleteById(roleId);
        } catch (Exception e) {
        }
       
    }

    @Override
    public List<Role> listRoles() {
        List<Role> listRole =null;
        try {
             listRole = roleDao.findAll();
        } catch (Exception e) {
           listRole = null;
        }
      return listRole;
    
    }
    
}
