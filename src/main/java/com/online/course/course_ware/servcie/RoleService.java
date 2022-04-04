/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Role;
import java.util.List;

/**
 *
 * @author mntemnte
 */
public interface RoleService {

    public Role saveRole(Role role);

    public Role updateRole(Long roleId, Role role);

    public void deleteRole(Long roleId);

    public List<Role> listRoles();

}
