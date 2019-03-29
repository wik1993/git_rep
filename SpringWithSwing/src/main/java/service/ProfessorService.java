package service;

import model.Professor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProfessorService {

    private RestTemplate restTemplate = new RestTemplate();

    public Professor getProfessor(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/profesor/"+id, Professor.class).getBody();
    }

    public List<Professor> getAllProfessors (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Professor>> response = restTemplate.exchange(
                "http://localhost:8080/profesor/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Professor>>(){});
        return response.getBody();
    }

    public void addProfessor(Professor professor){
        restTemplate.postForObject("http://localhost:8080/profesor/add", professor, Professor.class);
    }

    public void updateProfessor(Professor profesor, Integer id){
        restTemplate.put("http://localhost:8080/profesor/"+ id, profesor, Professor.class);
    }

    public void deleteProfessor(Integer id){
        restTemplate.delete("http://localhost:8080/profesor/"+id);
    }
}
