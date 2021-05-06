package ua.kpi.comsys.IO8326.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

import ua.kpi.comsys.IO8326.R;

public class Movie {
    @JsonProperty(value = "Title")
    private String title;
    @JsonProperty(value = "Year")
    private int year;
    private String imdbID;
    @JsonProperty(value = "Type")
    private String type;
    @JsonProperty(value = "Poster")
    private String posterID;

    public Movie() {
    }

    public Movie(String title, int year, String imdbID, String type, String posterID) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.posterID = posterID;
    }

    public int pictureFormatter(){
        Field field;
        try {
            String picture = posterID.split("\\.")[0].toLowerCase();
            field = R.drawable.class.getDeclaredField(picture);
            return field.getInt(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return R.drawable.test;
        }
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", posterID=" + posterID +
                '}';
    }
}
