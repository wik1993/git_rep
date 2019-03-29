package service;

import model.Mark;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MarkService {

    private RestTemplate restTemplate = new RestTemplate();

    public Mark getmark(Integer id) {
        return restTemplate.getForEntity("http://localhost:8080/mark/"+id, Mark.class).getBody();
    }

    public List<Mark> getAllmarks (){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Mark>> response = restTemplate.exchange(
                "http://localhost:8080/mark/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Mark>>(){});
        return response.getBody();
    }

    public void addMark(Mark mark){
        restTemplate.postForObject("http://localhost:8080/mark/add", mark, Mark.class);
    }

    public void updateMark(Mark mark, Integer id){
        restTemplate.put("http://localhost:8080/mark/"+ id, mark, Mark.class);
    }

    public void deleteMark(Integer id){
        restTemplate.delete("http://localhost:8080/mark/"+id);
    }
}
