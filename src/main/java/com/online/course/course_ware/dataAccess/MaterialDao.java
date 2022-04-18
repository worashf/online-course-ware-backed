
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Material;
import com.online.course.course_ware.entity.Topic;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MaterialDao extends JpaRepository<Material, Long>{
   @Query("SELECT m FROM Material m  JOIN   m.topic t  WHERE t.topicId =:topicId")
   List<Material>  getAllMaterialByTopicId(@Param (value ="topicId") Long topicId); 
     
}
