/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.online.course.course_ware.servcie;

import com.online.course.course_ware.entity.Video;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;


public interface VideoService {
     public Video addVideo(Long materialId, String videoTitle,String videoName);
    public  void    deleteVideo(Long videoId);
    public  List<Video> listVideosByMaterialId(Long materialId);  
    public Video findVideoByvideoId(Long videoId);
}
