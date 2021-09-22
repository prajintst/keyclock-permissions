package io.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class KeyClockSpringBootPermissions {

    public static void main(String[] args) {
        new SpringApplication(KeyClockSpringBootPermissions.class).run(args);
    }
}
