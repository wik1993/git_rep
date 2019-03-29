package service;


import model.University;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UniversityService {

    private RestTemplate restTemplate = new RestTemplate();

    public University getUniversity(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/univer/"+id, University.class).getBody();
    }

    public List<University> getAllUniversities (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<University>> response = restTemplate.exchange(
                "http://localhost:8080/univer/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<University>>(){});
        return response.getBody();
    }

    public void addUniversity(University university){
        restTemplate.postForObject("http://localhost:8080/univer/add", university, University .class);
    }

    public void updateUniversity (University university, Integer id){
        restTemplate.put("http://localhost:8080/univer/"+ id, university, University .class);
    }

    public void deleteUniversity (Integer id){
        restTemplate.delete("http://localhost:8080/univer/"+id);
    }
}
