package com.mastertheboss.springboot.springbootwildfly;

import com.mastertheboss.springboot.springbootwildfly.exception.ResourceNotFoundException;
import com.mastertheboss.springboot.springbootwildfly.model.Usuario;
import com.mastertheboss.springboot.springbootwildfly.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring Boot 2.x
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;

// Spring Boot 1.x
//import org.springframework.boot.web.support.SpringBootServletInitializer;
 
@SpringBootApplication
public class SpringbootwildflyApplication extends SpringBootServletInitializer {
 
    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
 
    private static Class<SpringbootwildflyApplication> applicationClass = SpringbootwildflyApplication.class;
}