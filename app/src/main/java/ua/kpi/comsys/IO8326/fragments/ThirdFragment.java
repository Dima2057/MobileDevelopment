package ua.kpi.comsys.IO8326.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.activities.AddMoviesActivity;
import ua.kpi.comsys.IO8326.activities.DetailedMovieInfoActivity;
import ua.kpi.comsys.IO8326.adapters.AdapterStorage;
import ua.kpi.comsys.IO8326.adapters.MovieAdapter;
import ua.kpi.comsys.IO8326.models.DetailedMovieInfo;
import ua.kpi.comsys.IO8326.models.Movie;
import ua.kpi.comsys.IO8326.services.BaseService;
import ua.kpi.comsys.IO8326.services.MovieService;

public class ThirdFragment extends Fragment {
    private static final ObjectMapper mapper = new ObjectMapper();
    private SearchView search;
    private MovieAdapter movieAdapter;

    public ThirdFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movies, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResume() {
        super.onResume();
        Activity a = getActivity();
        ImageView addIcon = a.findViewById(R.id.add_icon_id);
        ListView movieList = a.findViewById(R.id.movies);
        search = a.findViewById(R.id.search_movie_id);
        this.getResources();

        if (movieAdapter == null) {
            try {
                InputStream is = Objects.requireNonNull(getContext()).getAssets().open("moviesList.txt");
                MovieService movieService = mapper.readValue(is, MovieService.class);
                movieService = new MovieService(movieService.getMovies());
                BaseService.setMovieService(movieService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Movie> movies = Objects.requireNonNull(BaseService.getMovieService()).getMovies();
        movieAdapter = new MovieAdapter(getContext(), R.layout.item_movie);
        AdapterStorage.setMovieAdapter(movieAdapter);
        movieList.setAdapter(movieAdapter);
        movieAdapter.getFilter().filter("");

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                movieAdapter.getFilter().filter(newText);
                return false;
            }
        });

        addIcon.setOnClickListener(v -> {
            Intent myIntent = new Intent(getActivity(), AddMoviesActivity.class);
            startActivity(myIntent);
        });

        movieList.setOnItemLongClickListener((arg0, view, pos, id) -> {
            DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        TextView titleTextView = view.findViewById(R.id.title_id);
                        movieAdapter.removeMovie(titleTextView.getText().toString());
                        movieAdapter.getFilter().filter(search.getQuery());
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Delete").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
            return true;
        });

        movieList.setOnItemClickListener((parent, view, position, id) -> {
            Intent myIntent = new Intent(getActivity(), DetailedMovieInfoActivity.class);
            String filePath = movies.get(position).getImdbID().concat(".txt");
            try {
                InputStream fileInputStream = getContext().getAssets().open(filePath);
                DetailedMovieInfo detailedMovieInfo = mapper.readValue(fileInputStream, DetailedMovieInfo.class);
                System.out.println(detailedMovieInfo);
                myIntent.putExtra("movieInfo", detailedMovieInfo);
                startActivity(myIntent);
            } catch (IOException e) {
                System.out.println("No such imdbID for the specified movie: " + movies.get(position));
            }
        });
    }
}
