package ua.kpi.comsys.IO8326.interfaces;

import android.widget.Filter;

import java.util.List;
import ua.kpi.comsys.IO8326.models.Movie;

public interface IMovieService {
    void add(Movie movie);
    void remove(String imdbId);
    Movie get(int position);
    int getCount();
    List<Movie> getMovies();
}
