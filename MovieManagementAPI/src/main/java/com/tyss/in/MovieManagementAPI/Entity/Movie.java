package com.tyss.in.MovieManagementAPI.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.Year;
import java.util.InputMismatchException;

@Entity
@Table(name = "Movie_Table")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "Director is mandatory")
    private String director;

    @Min(value = 1888, message = "Release year must be after 1887")
    @Max(value = 2100, message = "Release year must be realistic")
    private int releaseYear;
    @NotBlank(message = "Genre is mandatory")
    private String genre;
    @DecimalMin(value = "0.0", message = "Rating must be at least 0")
    @DecimalMax(value = "10.0", message = "Rating must be at most 10")
    private double rating ;

    public Movie(){}
    public Movie(String title, String director, int releaseYear, String genre, double rating) {

            this.title = title;
            this.director = director;
            this.releaseYear = releaseYear;
            this.genre = genre;
            this.rating = rating;


    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {

        if(releaseYear>1887 && releaseYear< Year.now().getValue()) {
            this.releaseYear = releaseYear;
        }
        else {
            System.out.println("Invalid Year");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating>=0|| rating<=10) {
            this.rating = rating;
        }
        else {
            System.out.println("Enter the Movie Rating Between 0-10.");
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
