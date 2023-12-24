package com.example.demo.step;

import com.example.demo.SpringBootIntegrationTest;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinition extends SpringBootIntegrationTest {

    @LocalServerPort
    int port;

    private final String BASE_URL = "http://localhost:8080/student";

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    StudentRepo studentRepo;

    Student student;

    List<Student> studentList;

    int studentId;

    @Given("I have proper connection to DB")
    public void checkDBConnection() {
        assertNotNull(studentRepo);
    }

    @When("I make a post request with a student name {string} and age {int}")
    public void saveStudent(String studentName, Integer age) {
        student = new Student(studentName,age);
        student = testRestTemplate.postForObject(BASE_URL, student, Student.class);
        assertNotNull(student);
    }

    @Then("I should be able to save the user")
    public void verifySavedStudent() {
        Optional<Student> student1 = studentRepo.findById(student.getId());
        assertEquals(student1.get().getName(), student.getName());
        assertEquals(student1.get().getId(), student.getId());
    }

    @When("I make a get request to the students api")
    public void getAllStudents(){
        studentList = testRestTemplate.getForObject(BASE_URL, List.class);
    }

    @Then("I should get atleast one student back as response")
    public void verifyStudentsCount(){
        assertTrue(studentList.size() > 1);
    }

    @When("I make a put request to update a student with id {int} ,name {string} and age {int}")
    public void updateStudent(int id, String name, int age) {
        student = new Student(id, name, age);
        testRestTemplate.put(BASE_URL,new Student(id, name, age));
    }

    @Then("I should be able to update the student successfully")
    public void verifyUpdatedStudent(){
        Student student1 = studentRepo.findById(student.getId()).get();
        assertEquals(student1.getName(), student.getName());
        assertEquals(student1.getAge(), student.getAge());
    }

    @When("I make a delete request with a id {int}")
    public void deleteUser(int id) {
        studentId = id;
        testRestTemplate.delete(BASE_URL+"/"+id);
    }

    @Then("I should be able to delete the student")
    public void verifyStudentDelete() {
        assertFalse(studentRepo.findById(studentId).isPresent());
    }
}
