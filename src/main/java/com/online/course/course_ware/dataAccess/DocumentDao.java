
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Document;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends JpaRepository<Document, Long>{
  @Query("SELECT d  FROM Document d  JOIN   d.material m  WHERE m.materialId =:materialId")
   List<Document>  getAllDocumentByMaterialId(@Param (value ="materialId") Long materialId); 
}
