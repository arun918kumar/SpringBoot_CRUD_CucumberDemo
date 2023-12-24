package com.example.demo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;

@CucumberContextConfiguration
@SpringBootTest(classes = {DemoApplication.class},  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootIntegrationTest {

    @Bean
    public TestRestTemplate testRestTemplate(){
        return new TestRestTemplate();
    }

}
