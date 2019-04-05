package service;

import model.Professor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProfessorService {

    private RestTemplate restTemplate;

    public ProfessorService(){
        restTemplate = new RestTemplate();
    }

    public Professor getProfessor(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/professor/"+id, Professor.class).getBody();
    }

    public List<Professor> getAllProfessors (){

        ResponseEntity<List<Professor>> response = restTemplate.exchange(
                "http://localhost:8080/professor/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Professor>>(){});
        return response.getBody();
    }

    public void addProfessor(Professor professor){
        restTemplate.postForObject("http://localhost:8080/professor/add", professor, Professor.class);
    }

    public void updateProfessor(Professor professor, Integer id){
        restTemplate.put("http://localhost:8080/professor/"+ id, professor, Professor.class);
    }

    public void deleteProfessor(Integer id){
        restTemplate.delete("http://localhost:8080/professor/"+id);
    }
}
