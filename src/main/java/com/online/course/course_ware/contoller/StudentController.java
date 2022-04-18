
package com.online.course.course_ware.contoller;


import com.online.course.course_ware.entity.Student;
import com.online.course.course_ware.servcie.StudentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studService;

    
     
    @PostMapping("/students")
public ResponseEntity<Student>  saveStudent(@RequestBody Student stud){
       Student student = studService.saveStudent(stud);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "StudentController");
        return ResponseEntity.accepted().headers(headers).body(student);
    }
    
        @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,@RequestBody Student stud){
      Student student = studService.updatStudent(studentId, stud);
      return ResponseEntity.ok(student);
    }
         @PutMapping("/enroll/{courseId}")
    public ResponseEntity<Student> enrollStudent(@PathVariable Long courseId,

            @RequestBody Student stud){
      Student student = studService.enrollToCourse(stud, courseId);
      return ResponseEntity.ok(student);
    }
 @GetMapping("/students")
 public  ResponseEntity<List<Student>> ListAllStudents(){
   List<Student> studList = studService.listStudents();
   return  ResponseEntity.ok().body(studList);
 }


   @DeleteMapping("/students/{studentId}")
 public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable  Long studentId){
          
studService.deleteStudnet(studentId);
     
     Map<String,Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
       return ResponseEntity.ok(response);
 
}
//   @GetMapping("/students/{courseId}")
// public  ResponseEntity<List<Student>> ListAllStudentsByCourse(@PathVariable Long courseId){
//   List<Student> listStud = studService.listStudentsByCourse(courseId);
//  
//   return  ResponseEntity.ok().body(listStud);
// }
}

