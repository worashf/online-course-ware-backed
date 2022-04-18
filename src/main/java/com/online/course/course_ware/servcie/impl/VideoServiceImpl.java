/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.MaterialDao;
import com.online.course.course_ware.dataAccess.VideoDao;
import com.online.course.course_ware.entity.Material;
import com.online.course.course_ware.entity.Video;
import com.online.course.course_ware.servcie.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VideoServiceImpl implements  VideoService{
@Autowired
private MaterialDao matDao;
@Autowired
private VideoDao videoDao;

    @Override
    public Video addVideo(Long  materialId, String videoTitle,String videoName) {
        Video vid=new Video();
        Material mat =null;
//         System.out.println(videoTitle);
//                  System.out.println("bane " +materialId);
//                   System.out.println( "vvvv" +videoName);
                 
        try {
            mat = matDao.getById(materialId);
            vid.setMaterial(mat);
            vid.setVideoTitle(videoTitle);
            vid.setVideoName(videoName);
            vid = videoDao.save(vid);
        } catch (Exception e) {
            vid=null;
        }
     return vid;
    }

    @Override
    public void deleteVideo(Long videoId) {
     videoDao.deleteById(videoId);
    
    }

    @Override
    public List<Video> listVideosByMaterialId(Long materialId) {
       List<Video> listVideo =null;
        try {
             listVideo = videoDao.getAllVideoByMaterialId(materialId);
        } catch (Exception e) {
            listVideo =null;
        }
       return listVideo;

    }

    @Override
    public Video findVideoByvideoId(Long videoId) {
     Video video =null;
        try {
            video = videoDao.findByVideoId(videoId);
            
        } catch (Exception e) {
            video =null;
        }

return video;
    }
    
}
