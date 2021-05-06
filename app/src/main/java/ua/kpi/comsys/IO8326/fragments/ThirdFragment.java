package ua.kpi.comsys.IO8326.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.adapters.MovieAdapter;
import ua.kpi.comsys.IO8326.lab3_materials.MovieSearcher;

public class ThirdFragment extends Fragment {
    private static final ObjectMapper mapper = new ObjectMapper();
    public ThirdFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movies, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.getResources();
        MovieSearcher searchResults = null;
        try {
            InputStream is = Objects.requireNonNull(getContext()).getAssets().open("moviesList.txt");
            searchResults = mapper.readValue(is, MovieSearcher.class);
            //Log.i("Checking json", searchResults.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView list = Objects.requireNonNull(getActivity()).findViewById(R.id.movies);
        MovieAdapter adapter = new MovieAdapter(getContext(), R.layout.item_movie, Objects.requireNonNull(searchResults).getMovies());
        list.setAdapter(adapter);
    }
}
