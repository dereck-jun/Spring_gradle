package com.example.demo;

import com.example.demo.chap03.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionSampleApplication {

    @Autowired
    Greet greet;

    private void execute()  {
        greet.greeting();
    }

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionSampleApplication.class, args)
                .getBean(DependencyInjectionSampleApplication.class).execute();
    }

}
