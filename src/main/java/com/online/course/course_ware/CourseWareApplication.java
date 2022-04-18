package com.online.course.course_ware;

import com.online.course.course_ware.dataAccess.RoleDao;
import com.online.course.course_ware.dataAccess.UserDao;
import com.online.course.course_ware.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class CourseWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWareApplication.class, args);
	}
        
  @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
       
  @Autowired
  private RoleDao roleDao;
    public void run(String... args) throws Exception {
            Role role = new Role();
            role.setRoleName("Admin");
            roleDao.save(role);
        }
    

    }
  


