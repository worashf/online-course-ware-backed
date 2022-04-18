/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.MaterialDao;
import com.online.course.course_ware.dataAccess.TopicDao;
import com.online.course.course_ware.entity.Material;
import com.online.course.course_ware.entity.Topic;
import com.online.course.course_ware.servcie.MaterialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService{
@Autowired
private MaterialDao materialDao;
@Autowired
private TopicDao topicDao;
    
    @Override
    public Material saveMaterial(Long topicId, Material mat) {
        Topic topic =null;
  
        try {
            topic= topicDao.getById(topicId);
            mat.setTopic(topic);
            mat = materialDao.save(mat);
        } catch (Exception e) {
            mat =null;
        }
         
        return mat;
    }

    @Override
    public void deleteMaterial(Long materialId) {
     materialDao.deleteById(materialId);
    }

    @Override
    public List<Material> listMaterialsByTopic(Long topicId) {
         List<Material> listMat=null;
        try {
             listMat = materialDao.getAllMaterialByTopicId(topicId);
        } catch (Exception e) {
            listMat =null;
        }
        return listMat;
    }

    @Override
    public Material updateMaterial(Long materialId, Material mat) {
         Material material = materialDao.getById(materialId);
        try {
            material.setMaterialName(mat.getMaterialName());
            material = materialDao.save(material);
            
        } catch (Exception e) {
            material = null;
        }
        return material;
    }

   
    
}
