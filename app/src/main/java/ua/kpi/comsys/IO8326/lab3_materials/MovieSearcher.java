package ua.kpi.comsys.IO8326.lab3_materials;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import ua.kpi.comsys.IO8326.models.Movie;

public class MovieSearcher {
    private List<Movie> movies;

    public MovieSearcher() {
    }

    @JsonProperty("Search")
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieSearcher{" +
                "movies=" + movies +
                '}';
    }
}