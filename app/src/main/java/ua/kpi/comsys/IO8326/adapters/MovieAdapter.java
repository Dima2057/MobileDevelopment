package ua.kpi.comsys.IO8326.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.models.Movie;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<Movie> movies;

    public MovieAdapter(Context context, int resource, List<Movie> movies){
        super(context, resource, movies);
        this.movies = movies;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, parent, false);
        ImageView posterView = view.findViewById(R.id.poster);
        TextView titleView = view.findViewById(R.id.title);
        TextView yearView = view.findViewById(R.id.year);
        TextView typeView = view.findViewById(R.id.type);

        Movie movie = movies.get(position);
        posterView.setImageResource(movie.pictureFormatter());
        titleView.setText(movie.getTitle());
        yearView.setText(String.valueOf(movie.getYear()));
        typeView.setText(movie.getType());
        return view;
    }
}
