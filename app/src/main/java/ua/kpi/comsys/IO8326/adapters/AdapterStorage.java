package ua.kpi.comsys.IO8326.adapters;

import ua.kpi.comsys.IO8326.models.Images;

public class AdapterStorage {
    private static MovieAdapter movieAdapter;
    public static final Images images = new Images();

    public static MovieAdapter getMovieAdapter() {
        return movieAdapter;
    }

    public static void setMovieAdapter(MovieAdapter movieAdapter) {
        AdapterStorage.movieAdapter = movieAdapter;
    }
}
