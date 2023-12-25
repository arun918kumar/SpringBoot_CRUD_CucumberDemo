package com.example.demo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;

import java.net.URI;

@CucumberContextConfiguration
@SpringBootTest(classes = {DemoApplication.class},  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootIntegrationTest {

}
