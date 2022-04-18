/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author mntemnte
 */
@Configuration
@EnableWebMvc
public class ResourceConfig  implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    Path uploadDir = Paths.get("./courses-thumbnail");
    String uploadPath = uploadDir.toFile().getAbsolutePath();
    registry.addResourceHandler("/courses-thumbnail/**")
            .addResourceLocations("file:/" + uploadPath + "/");
    
    }
    

    
    
}
