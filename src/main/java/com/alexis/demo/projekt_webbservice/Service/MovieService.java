package com.alexis.demo.projekt_webbservice.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class MovieService {

    @Value("27c8f50ca8a63c8506abdff9ded3114f")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public Map<String, Object> popularMovies(){
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;

        return restTemplate.getForObject(url,Map.class);
    }

}
