package com.alexis.demo.projekt_webbservice.Controller;

import com.alexis.demo.projekt_webbservice.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MoviesController {

    private final MovieService movieService;

    public MoviesController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showMovieDatabase(Model model){
        Map<String, Object> movies = movieService.popularMovies();
        model.addAttribute("movies",movies.get("results"));
        return "moviespage.html";
    }

}
