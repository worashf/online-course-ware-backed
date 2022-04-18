/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Document;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;


public interface DocumentService {
     
    public Document saveDocument(Long materialId,Document doc);
    public  void    deleteDocument(Long documentId);
    public  List<Document> listDocumentsByMaterialId(Long materialId);
}
