package service;

import model.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;



public class StudentService {

    private RestTemplate restTemplate;

    public StudentService(){
        restTemplate = new RestTemplate();
    }

    public Student getStudent(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/student/"+id, Student.class).getBody();
    }

    public List<Student> getAllStudents (){

        ResponseEntity<List<Student>> response = restTemplate.exchange(
                "http://localhost:8080/student/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});
        return response.getBody();
    }

    public void addStudent(Student student){
        restTemplate.postForObject("http://localhost:8080/student/add", student, Student.class);
    }

    public void updateStudent(Student student, Integer id){
        restTemplate.put("http://localhost:8080/student/"+ id, student, Student.class);
    }

    public void deleteStudent(Integer id){
        restTemplate.delete("http://localhost:8080/student/"+id);
    }
}
