package ua.kpi.comsys.IO8326.services;

public class BaseService {
    private static MovieService movieService;

    public static MovieService getMovieService() {
        if (movieService == null) {
            movieService = new MovieService();
        }
        return movieService;
    }

    public static void setMovieService(MovieService movieService) {
        BaseService.movieService = movieService;
    }
}
