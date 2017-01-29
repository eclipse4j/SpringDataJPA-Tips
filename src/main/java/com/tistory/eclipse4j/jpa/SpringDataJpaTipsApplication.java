package com.tistory.eclipse4j.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringDataJpaTipsApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringDataJpaTipsApplication.class, args);
    }
}
