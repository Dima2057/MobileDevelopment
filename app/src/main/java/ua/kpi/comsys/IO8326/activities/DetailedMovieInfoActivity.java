package ua.kpi.comsys.IO8326.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.models.DetailedMovieInfo;
import ua.kpi.comsys.IO8326.models.Movie;

import static android.text.TextUtils.concat;


public class DetailedMovieInfoActivity extends AppCompatActivity {
    private static final String TAG = "DetailedMovieInfoActivity";
    private TextView titleTxtView;
    private TextView yearTxtView;
    private TextView ratedTxtView;
    private TextView releasedTxtView;
    private TextView runtimeTxtView;
    private TextView genreTxtView;
    private TextView directorTxtView;
    private TextView writerTxtView;
    private TextView actorsTxtView;
    private TextView plotTxtView;
    private TextView languageTxtView;
    private TextView countryTxtView;
    private TextView awardsTxtView;
    private ImageView posterTxtView;
    private TextView imdbRatingTxtView;
    private TextView imdbVotesTxtView;
    private TextView imdbIDTxtView;
    private TextView typeTxtView;
    private TextView productionTxtView;

    @SuppressLint({"LongLogTag", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        DetailedMovieInfo info =  ((DetailedMovieInfo) getIntent().getSerializableExtra("movieInfo"));
        Log.i(TAG,  String.format("movieInfo: %s", info.toString()));

        titleTxtView = findViewById(R.id.title_id);
        yearTxtView = findViewById(R.id.year_id);
        ratedTxtView = findViewById(R.id.rated_id);
        releasedTxtView = findViewById(R.id.released_id);
        runtimeTxtView = findViewById(R.id.runtime_id);
        genreTxtView = findViewById(R.id.genre_id);
        directorTxtView = findViewById(R.id.director_id);
        writerTxtView = findViewById(R.id.writer_id);
        actorsTxtView = findViewById(R.id.actors_id);
        plotTxtView = findViewById(R.id.plot_id);
        languageTxtView = findViewById(R.id.language_id);
        countryTxtView = findViewById(R.id.country_id);
        awardsTxtView = findViewById(R.id.awards_id);
        posterTxtView = findViewById(R.id.poster_id);
        imdbRatingTxtView = findViewById(R.id.imdb_rating_id);
        imdbVotesTxtView = findViewById(R.id.imdb_votes_id);
        imdbIDTxtView = findViewById(R.id.imdb_id);
        typeTxtView = findViewById(R.id.type_id);
        productionTxtView = findViewById(R.id.production_id);

        titleTxtView.setText(info.getTitle());
        yearTxtView.setText("Year:    " + info.getYear());
        ratedTxtView.setText("Rated:    " + info.getRated());
        releasedTxtView.setText("Released:    " + info.getReleased());
        runtimeTxtView.setText("Runtime:    " + info.getRuntime());
        genreTxtView.setText("Genre:    " + info.getGenre());
        directorTxtView.setText("Director:    " + info.getDirector());
        writerTxtView.setText("Writer:    " + info.getWriter());
        actorsTxtView.setText("Actors:    " + info.getActors());
        plotTxtView.setText("Plot:    " + info.getPlot());
        languageTxtView.setText("Language:    " + info.getLanguage());
        countryTxtView.setText("Country:    " + info.getCountry());
        awardsTxtView.setText("Awards:    " + info.getAwards());
        posterTxtView.setImageResource(info.pictureFormatter());
        imdbRatingTxtView.setText("imdb rating:    " + info.getImdbRating());
        imdbVotesTxtView.setText("imdb voted:    " + info.getImdbVotes());
        typeTxtView.setText("Type:    " + info.getType());
        productionTxtView.setText("Production:    " + info.getProduction());
    }
}
