
package com.online.course.course_ware.contoller;

import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Document;
import com.online.course.course_ware.entity.Material;
import com.online.course.course_ware.entity.Video;
import com.online.course.course_ware.servcie.DocumentService;
import com.online.course.course_ware.servcie.MaterialService;
import com.online.course.course_ware.servcie.VideoService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class MaterialController {
    
    @Autowired
    private  MaterialService matService;
    @Autowired
    private VideoService vidService;
    @Autowired
    private DocumentService docuService;
    
    @PostMapping("/materials/{topicId}")
    public ResponseEntity<Material> createMaterial(@PathVariable Long topicId,@RequestBody Material mat){
          Material material =matService.saveMaterial(topicId, mat);
          System.out.println(mat.getMaterialName());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MaterialController");
        return ResponseEntity.accepted().headers(headers).body(material);
    }
       @PutMapping("/materials/{materialId}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long materialId,@RequestBody Material mat){
          Material material =matService.updateMaterial(materialId, mat);
          System.out.println(mat.getMaterialName());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MaterialController");
        return ResponseEntity.accepted().headers(headers).body(material);
    }
    
       @PostMapping("/materials/videos/{materialId}")
    public ResponseEntity<Video> createVideo(@PathVariable Long materialId,
            @RequestParam("videoTitle") String videoTitle,
            @RequestParam("file") MultipartFile file) throws IOException{
         Video vid = new Video();
//           System.out.println(videoTitle);
            
       String message;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//             System.out.println(fileName);
//                  System.out.println(materialId);
        
         
           Video video  =vidService.addVideo(materialId, videoTitle, fileName);
         String uploadDir = "./courses-thumbnail/"+video.getVideoId();
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
             throw  new IOException("could not saved video file:" +fileName,ex);
         }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MaterialController");
        return ResponseEntity.ok().body(video);
    }
@PostMapping("/materials/documents/{materialId}")
    public ResponseEntity<Document> createDocument(@PathVariable Long materialId,
            @RequestBody Document doc,MultipartFile file) throws IOException{
        
            
       String message;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
           doc.setDocumentName(fileName);
         Document document = docuService.saveDocument(materialId, doc);
         String uploadDir = "./courses-thumbnail/"+document.getDocumentId();
         Path uploadPath = Paths.get(uploadDir);

         if(!Files.exists(uploadPath)){
             Files.createDirectories(uploadPath);
         }
                     System.out.println(uploadPath);
         try (InputStream inputSteam = file.getInputStream()){
         Path filePath = uploadPath.resolve(fileName);
      
//             System.out.println(filePath.toFile().getAbsolutePath());
         Files.copy(inputSteam, filePath, StandardCopyOption.REPLACE_EXISTING);
         message ="success";
         }
         catch(IOException ex){
             message ="not saved";
             throw  new IOException("could not saved video file:" +fileName,ex);
         }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MaterialController");
        return ResponseEntity.accepted().headers(headers).body(document);
    }
 @GetMapping("/materials/{topicId}")
 public  ResponseEntity<List<Material>> ListAllMaterialsByTopic(@PathVariable Long topicId){
   List<Material> listMaterial = matService.listMaterialsByTopic(topicId);
   return  ResponseEntity.ok().body(listMaterial);
 }
 
  @GetMapping("/materials/videos/{materialId}")
 public  ResponseEntity<List<Video>> ListAllVideosByMaterial(@PathVariable Long materialId){
   List<Video> listVideo = vidService.listVideosByMaterialId(materialId);
   return  ResponseEntity.ok().body(listVideo);
 }
   
  @GetMapping("/materials/documents/{materialId}")
 public  ResponseEntity<List<Document>> ListAllDocumentsByMaterial(@PathVariable Long materialId){
   List<Document> listDocument = docuService.listDocumentsByMaterialId(materialId);
   return  ResponseEntity.ok().body(listDocument);
 }
 
    @DeleteMapping("/materials/{materialId}")
 public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable  Long materialId){
          
    matService.deleteMaterial(materialId);
   
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
 
}
