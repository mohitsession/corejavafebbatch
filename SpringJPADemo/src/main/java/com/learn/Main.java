package com.learn;

import com.learn.config.AppConfig;
import com.learn.model.Student;
import com.learn.repository.StudentRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Spring Context...");
        
        // 1. Manually start the Spring Container using our configuration class
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Spring Context Started!");

        // 2. Ask the Spring Container to give us the StudentRepository implementation
        StudentRepository repository = context.getBean(StudentRepository.class);

        // 3. Perform database operations
        System.out.println("Saving new student via Spring Data JPA...");
        Student newStudent = new Student("Alice", "alice@example.com", "Spring", 95.5);
        repository.save(newStudent);

        System.out.println("Success! Saved student with ID: " + newStudent.getId());
        
        System.out.println("Find by Studnet by ID : "+repository.findById(10));

        // 4. Close the context to release database connections cleanly
        context.close();
    }
}