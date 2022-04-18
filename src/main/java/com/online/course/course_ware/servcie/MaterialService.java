/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;


import com.online.course.course_ware.entity.Material;
import java.util.List;



public interface MaterialService {
    public Material saveMaterial(Long topicId,Material mat);
       public Material updateMaterial(Long materialId,Material mat);
    public  void    deleteMaterial(Long materialId);
    public  List<Material> listMaterialsByTopic(Long topicId);
}
