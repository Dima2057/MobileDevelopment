package ua.kpi.comsys.IO8326.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.IO8326.R;
import ua.kpi.comsys.IO8326.models.Movie;
import ua.kpi.comsys.IO8326.services.BaseService;
import ua.kpi.comsys.IO8326.services.MovieService;

public class MovieAdapter extends ArrayAdapter<Movie> implements Filterable, Serializable {
    private final LayoutInflater inflater;
    private final int layout;
    private MovieFilter filter;
    private TextView defaultMessage;
    private MovieService movieService;

    public MovieAdapter(Context context, int resource) {
        super(context, resource, BaseService.getMovieService().getMovies());
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.movieService = BaseService.getMovieService();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void removeMovie(String movie) {
        movieService.remove(movie);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, parent, false);
        ImageView posterView = view.findViewById(R.id.poster);
        TextView titleView = view.findViewById(R.id.title);
        TextView yearView = view.findViewById(R.id.year);
        TextView typeView = view.findViewById(R.id.type);

        Movie movie = BaseService.getMovieService().get(position);
        posterView.setImageResource(movie.pictureFormatter());
        titleView.setText(movie.getTitle());
        yearView.setText(String.valueOf(movie.getYear()));
        typeView.setText(movie.getType());
        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new MovieFilter();
        }
        return filter;
    }

    @Override
    public int getCount() {
        return movieService.getCount();
    }

    class MovieFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Movie> allMovies = movieService.getMovies();

            if (constraint != null && !constraint.toString().isEmpty()) {
                constraint = constraint.toString().toUpperCase();
                List<Movie> filters = new ArrayList<>();
                for (int i = 0; i < allMovies.size(); i++) {
                    if (allMovies.get(i).getTitle().toUpperCase().contains(constraint)) {
                        filters.add(allMovies.get(i));
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = allMovies.size();
                results.values = allMovies;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movieService.setMovies((List<Movie>) results.values);
            if (defaultMessage != null) {
                if (getCount() != 0) {
                    defaultMessage.setVisibility(View.INVISIBLE);
                }
                defaultMessage.setVisibility(View.VISIBLE);
            }
            notifyDataSetChanged();
        }
    }
}
