/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.contoller;


import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.entity.Course;

import com.online.course.course_ware.servcie.CourseService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mntemnte
 */
@RestController
@RequestMapping("/api")
public class CourseController {

     public static final String uploadingDir = System.getProperty("user.dir")+"uploads/";
     @Autowired
     private CourseService courseService;
    @Autowired
    private CourseDao couDao;
    @PostMapping("/courses/{categoryId}")
    public ResponseEntity<Course> createCourse(@PathVariable Long categoryId,@RequestBody Course course){
          Course co = courseService.saveCourse(categoryId, course);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CategoryController");
        return ResponseEntity.accepted().headers(headers).body(co);
    }
    
        @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course course){
      Course co = courseService.updatCourse(courseId, course);
       
        return ResponseEntity.ok().body(co);
    }

 @GetMapping("/courses")
					
 public  ResponseEntity<List<Course>> ListAllCourses(){
   List<Course> listCourse = courseService.listCourses();
   return  ResponseEntity.ok().body(listCourse);
 }
 
  @GetMapping("/courses/{categoryId}")
 public  ResponseEntity<List<Course>> ListAllCoursesByCategory(@PathVariable Long categoryId){
   List<Course> listCourse = courseService.listCoursesByCategoryId(categoryId);
  
   return  ResponseEntity.ok().body(listCourse);
 }
   @GetMapping("/your/courses/{userName}")
 public  ResponseEntity<List<Course>> ListAllCoursesByuser(@PathVariable String userName){
   List<Course> listCourse = courseService.listCoursesByUser(userName);
      
   return  ResponseEntity.ok().body(listCourse);
 }
   @DeleteMapping("/courses/{courseId}")
 public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable  Long courseId){
          
     courseService.deleteCourse(courseId);
   
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
 
    @PostMapping("/course/upload/{courseId}")
 public ResponseEntity<String> uploadCourseThumbnail(@RequestParam("file")
         MultipartFile file, @PathVariable  Long courseId) throws IOException{
        
       String message;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
         Course cou = couDao.getById(courseId);
         cou.setThumbnail(fileName);
         Course course = couDao.save(cou);
         String uploadDir = "./courses-thumbnail/"+course.getCourseId();
         Path uploadPath = Paths.get(uploadDir);

         if(!Files.exists(uploadPath)){
             Files.createDirectories(uploadPath);
         }
                     System.out.println(uploadPath);
         try (InputStream inputSteam = file.getInputStream()){
         Path filePath = uploadPath.resolve(fileName);
      
             System.out.println(filePath.toFile().getAbsolutePath());
         Files.copy(inputSteam, filePath, StandardCopyOption.REPLACE_EXISTING);
         message ="success";
         }
         catch(IOException ex){
             message ="not saved";
             throw  new IOException("could not saved image file:" +fileName,ex);
         }
             
      
         
//        file.transferTo( new File(uploadPath));
         
 
 
       return ResponseEntity.ok(message);
 
}
  @RequestMapping(value = "/courses/image/{courseId}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(HttpServletResponse response,@PathVariable Long courseId) throws IOException {
        Course cou = couDao.getById(courseId);
      System.out.println(courseId);
        String path = cou.getThumbnailPath();
        System.out.println(path);
        ClassPathResource imgFile = new ClassPathResource(path);
         
byte[] imageBytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
      System.out.println(imageBytes.toString());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
 
 
}
