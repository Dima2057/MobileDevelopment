package ua.kpi.comsys.IO8326.activities;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.adapters.AdapterStorage;
import ua.kpi.comsys.IO8326.models.Movie;
import ua.kpi.comsys.IO8326.services.BaseService;
import ua.kpi.comsys.IO8326.services.MovieService;

public class AddMoviesActivity extends AppCompatActivity {
    EditText title;
    EditText year;
    EditText type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        title = findViewById(R.id.title_text);
        year = findViewById(R.id.year_text);
        type = findViewById(R.id.type_text);
    }

    public void addMovie(View view) {
        Movie movie = new Movie(
                title.getText().toString(),
                Integer.parseInt(year.getText().toString()), "",
                type.getText().toString(),
                String.valueOf(R.drawable.test));

        BaseService.getMovieService().add(movie);
        AdapterStorage.getMovieAdapter().notifyDataSetChanged();
        finish();
    }
}
