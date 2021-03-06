/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.online.course.course_ware.config;

import com.online.course.course_ware.filter.CustomAuthenticationFilter;
import com.online.course.course_ware.filter.CustomAuthorizationFilter;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


/**
 *
 * @author mntemnte
 */
@Configuration
@EnableWebSecurity

public class webSecurity extends WebSecurityConfigurerAdapter{
      
 @Autowired
    @Qualifier("userDetailService")
	private UserDetailsService onUserDetailsService;


        
      	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            BCryptPasswordEncoder encoder =	new BCryptPasswordEncoder( );
	 auth.userDetailsService(onUserDetailsService).passwordEncoder(encoder);
		
                        }
      
      
      
    @Override
   protected void configure(HttpSecurity http) throws Exception{
       CustomAuthenticationFilter customAuthentication = new CustomAuthenticationFilter(authenticationManagerBean());
       customAuthentication.setFilterProcessesUrl("/api/login");
            http.cors()
            .configurationSource(corsConfigurationSource()).and().csrf().disable();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//            http.authorizeRequests().antMatchers("/api/login/**","/api/courses/**", "/api/topics/**","/api/students/**","/api/users/save/**").permitAll();
//            http.authorizeRequests().antMatchers(GET,"/api/courses/**").permitAll();
//
//            http.authorizeRequests().antMatchers("/api/checktoken/**","/api/courses/image/**","/api/roles/**","/api/user/requests/**").permitAll();
//             http.authorizeRequests().antMatchers(GET,"/api/categories/**").permitAll();
//            http.authorizeRequests().antMatchers(GET,"/api/users/**").hasAnyAuthority("Admin");
//            http.authorizeRequests().antMatchers(GET,"/api/requests/**").hasAnyAuthority("Admin");
//       http.authorizeRequests().antMatchers(GET,"/api/your/courses/**").hasAnyAuthority("Teacher");
//       http.authorizeRequests().antMatchers(GET,"/api/course/requests/**").hasAnyAuthority("Admin");
//       http.authorizeRequests().antMatchers(GET,"/api/user/requests/**").hasAnyAuthority("Admin");
//       http.authorizeRequests().antMatchers(PUT,"/api/courses/**").hasAnyAuthority("Teacher");
//       http.authorizeRequests().antMatchers(POST,"/api/course/upload/**","/api/roles/**").hasAnyAuthority("Student");
//
//     http.authorizeRequests().antMatchers(POST,"/api/requests/approve/**").hasAnyAuthority("Admin");
//              // http.authorizeRequests().antMatchers(POST,"/api/users/**").hasAnyAuthority("Teacher","Admin");
            http.authorizeRequests().anyRequest().permitAll();
           http.addFilter(customAuthentication);
        //http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
 
   }
   
   	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    @Bean
CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
          configuration.setAllowCredentials(true);
          configuration.addAllowedOriginPattern("*");
//      configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
 
}
