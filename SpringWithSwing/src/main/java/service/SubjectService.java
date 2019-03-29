package service;

import model.Subject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class SubjectService {

    private RestTemplate restTemplate = new RestTemplate();

    public Subject getSubject(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/subject/"+id, Subject.class).getBody();
    }

    public List<Subject> getAllSubjects (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Subject>> response = restTemplate.exchange(
                "http://localhost:8080/subject/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Subject>>(){});
        return response.getBody();
    }

    public void addSubject (Subject subject){
        restTemplate.postForObject("http://localhost:8080/subject/add", subject, Subject.class);
    }

    public void updateSubject(Subject subject, Integer id){
        restTemplate.put("http://localhost:8080/subject/"+ id, subject, Subject.class);
    }

    public void deleteSubject(Integer id){
        restTemplate.delete("http://localhost:8080/subject/"+id);
    }
}
