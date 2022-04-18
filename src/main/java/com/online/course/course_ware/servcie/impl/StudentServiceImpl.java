
package com.online.course.course_ware.servcie.impl;

import com.online.course.course_ware.dataAccess.CourseDao;
import com.online.course.course_ware.dataAccess.RoleDao;
import com.online.course.course_ware.dataAccess.StudentDao;
import com.online.course.course_ware.dataAccess.UserDao;
import com.online.course.course_ware.entity.Course;
import com.online.course.course_ware.entity.Role;
import com.online.course.course_ware.entity.Student;
import com.online.course.course_ware.entity.User;
import com.online.course.course_ware.servcie.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl  implements  StudentService{
 @Autowired
 private  StudentDao studDao;
 @Autowired
private RoleDao roleDao;
  @Autowired
private PasswordEncoder encoder;

   @Autowired
 private UserDao  userDao;
    @Autowired
  private CourseDao courseDao;
    
    @Override
    public Student saveStudent(Student stud) {
        Student student =null;
        try {
            
            
     student = studDao.save(stud);
           
            
        } catch (Exception e) {
            student =null;
        }
        
        
     return student; 
    }

    @Override
    public Student updatStudent(Long studnetId, Student stud) {
        Student student = studDao.getById(studnetId);
        try {
             student.setFirstName(stud.getFirstName());
             student.setLastName(stud.getLastName());
             student.setEmail(stud.getEmail());
          student = studDao.save(student);
        } catch (Exception e) {
            student =null;
        }
    return student;
    }

    @Override
    public void deleteStudnet(Long studnetId) {
        try {
            studDao.deleteById(studnetId);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Student> listStudents() {
        List<Student> listStud =null;
        try {
            listStud = studDao.findAll();
        } catch (Exception e) {
            listStud = null;
        }
          
return listStud;
    }

    @Override
    public Student enrollToCourse(Student stud,Long courseId) {
          Student student = null;
          Course course = null;
        try {
            student = studDao.findByStudentCode(stud .getStudentCode());
            course = courseDao.getById(courseId);
            student.addCourse(course);
            student = studDao.save(student);
            
            
        } catch (Exception e) {
            
            student =null;
        }
        return  student;
        
    }

    
}
