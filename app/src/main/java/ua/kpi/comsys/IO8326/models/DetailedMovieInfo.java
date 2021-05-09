package ua.kpi.comsys.IO8326.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.lang.reflect.Field;

import ua.kpi.comsys.IO8326.R;

public class DetailedMovieInfo implements Serializable {
    @JsonProperty(value = "Title")
    private String title;
    @JsonProperty(value = "Year")
    private String year;
    @JsonProperty(value = "Rated")
    private String rated;
    @JsonProperty(value = "Released")
    private String released;
    @JsonProperty(value = "Runtime")
    private String runtime;
    @JsonProperty(value = "Genre")
    private String genre;
    @JsonProperty(value = "Director")
    private String director;
    @JsonProperty(value = "Writer")
    private String writer;
    @JsonProperty(value = "Actors")
    private String actors;
    @JsonProperty(value = "Plot")
    private String plot;
    @JsonProperty(value = "Language")
    private String language;
    @JsonProperty(value = "Country")
    private String country;
    @JsonProperty(value = "Awards")
    private String awards;
    @JsonProperty(value = "Poster")
    private String poster;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    @JsonProperty(value = "Type")
    private String type;
    @JsonProperty(value = "Production")
    private String production;

    public DetailedMovieInfo() {
    }

    public DetailedMovieInfo(String title, String year, String rated,
                             String released, String runtime, String genre,
                             String director, String writer, String actors,
                             String plot, String language, String country,
                             String awards, String poster, String imdbRating,
                             String imdbVotes, String imdbID, String type, String production) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.production = production;
    }

    public int pictureFormatter(){
        Field field;
        try {
            String picture = poster.split("\\.")[0].toLowerCase();
            field = R.drawable.class.getDeclaredField(picture);
            return field.getInt(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return R.drawable.test;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "DetailedMovieInfo{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", production='" + production + '\'' +
                '}';
    }
}
