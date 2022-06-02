package model;

import entity.Movie;

public interface MovieModel {
    public Movie[] getAllMovies();

    public void addMovie(Movie movie);

    public void updateMovie(Movie movie);

    public void deleteMovie(String judul);

}
