
package com.online.course.course_ware.contoller;

import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Video;
import com.online.course.course_ware.servcie.VideoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Autowired
    private VideoService vidService;
    
    
    
     @GetMapping("/videos/{materialId}")
 public  ResponseEntity<List<Video>> ListAllVideosByMaterial(@PathVariable Long materialId){
   List<Video> listVideo = vidService.listVideosByMaterialId(materialId);
  
   return  ResponseEntity.ok().body(listVideo);
 }
   @RequestMapping(value = "/videos/video/{videoId}", method = RequestMethod.GET)
    public  ResponseEntity< ?>  getVideo(HttpServletResponse response,
            @PathVariable Long videoId) throws IOException {
    
        Video video = vidService.findVideoByvideoId(videoId);
       System.out.println("videoId"+ videoId);
        String uploadDir = "courses-thumbnail/"+video.getVideoId();
        String fileName = video.getVideoName();
           Path uploadPath = Paths.get(uploadDir);
             Path filePath = uploadPath.resolve(fileName);
        System.out.println(filePath.toFile().getAbsolutePath());
        ClassPathResource imgFile = new ClassPathResource(uploadDir +fileName);
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(filePath));
      System.out.println(resource.contentLength());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "VideoController");
   
      return ResponseEntity
                        .ok()
                  .contentLength(filePath.toFile().length())
                        .contentType(MediaType.parseMediaType("video/mp4"))
                         .body(resource);  
    }
}
