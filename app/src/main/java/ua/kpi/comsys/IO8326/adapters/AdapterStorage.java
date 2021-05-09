package ua.kpi.comsys.IO8326.adapters;

public class AdapterStorage {
    private static MovieAdapter movieAdapter;

    public static MovieAdapter getMovieAdapter() {
        return movieAdapter;
    }

    public static void setMovieAdapter(MovieAdapter movieAdapter) {
        AdapterStorage.movieAdapter = movieAdapter;
    }
}
