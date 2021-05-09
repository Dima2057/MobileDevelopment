package ua.kpi.comsys.IO8326.services;

import android.os.Build;
import android.widget.Filter;

import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import ua.kpi.comsys.IO8326.interfaces.IMovieService;
import ua.kpi.comsys.IO8326.models.Movie;

public class MovieService implements IMovieService {
    @JsonProperty("Search")
    private List<Movie> allMovies;

    private List<Movie> movies;

    public MovieService() {
    }

    public MovieService(List<Movie> movies) {
        this.allMovies = movies;
        this.movies = new ArrayList<>();
    }

    @Override
    public void add(Movie movie) {
        allMovies.add(movie);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void remove(String imdbId) {
        allMovies.removeIf(movie -> movie.getImdbID().equals(imdbId));
    }

    @Override
    public List<Movie> getMovies() {
        return allMovies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public Movie get(int position) {
        return movies.get(position);
    }
}
