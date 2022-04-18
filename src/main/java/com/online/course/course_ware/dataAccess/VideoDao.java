/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.dataAccess;

import com.online.course.course_ware.entity.Video;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoDao extends JpaRepository<Video, Long>{
     @Query("SELECT v FROM Video v  JOIN   v.material m  WHERE m.materialId =:materialId")
   List<Video>  getAllVideoByMaterialId(@Param (value ="materialId") Long materialId); 
public Video  findByVideoId(Long videoId);
}
