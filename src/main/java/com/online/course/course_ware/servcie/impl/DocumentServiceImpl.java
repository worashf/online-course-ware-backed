/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.DocumentDao;
import com.online.course.course_ware.dataAccess.MaterialDao;
import com.online.course.course_ware.entity.Document;
import com.online.course.course_ware.entity.Material;
import com.online.course.course_ware.servcie.DocumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
   private DocumentDao documentDao;
    @Autowired
    private MaterialDao materialDao;
    
    @Override
    public Document saveDocument(Long materialId, Document doc) {
        Material mat =null;
        Document document =null;
        try {
            mat = materialDao.getById(materialId);
            document.setMaterial(mat);
            document =documentDao.save(doc);
        } catch (Exception e) {
            document =null;
        }
    return document;
    }

    @Override
    public void deleteDocument(Long documentId) {
    
     documentDao.deleteById(documentId);
    
    }

    @Override
    public List<Document> listDocumentsByMaterialId(Long materialId) {
       List<Document> listDocu =null;
        try {
           listDocu =null;  
        } catch (Exception e) {
            listDocu =null;
        }
     return listDocu;
    }
    
}
