package model;

import entity.Movie;

import java.sql.*;
import java.util.ArrayList;

public class MovieModelImpl implements MovieModel {
    private final Connection connection;

    public MovieModelImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Movie[] getAllMovies() {
        String sql = "SELECT * FROM movie";
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setJudul(resultSet.getString("judul"));
                movie.setAlur(resultSet.getDouble("alur"));
                movie.setPenokohan(resultSet.getDouble("penokohan"));
                movie.setAkting(resultSet.getDouble("akting"));

                movies.add(movie);
            }
            return movies.toArray(new Movie[movies.size()]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addMovie(Movie movie) {
        String sql = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movie.getJudul());
            preparedStatement.setDouble(2, movie.getAlur());
            preparedStatement.setDouble(3, movie.getPenokohan());
            preparedStatement.setDouble(4, movie.getAkting());
            preparedStatement.setDouble(5, movie.getRating());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateMovie(Movie movie) {
        String sql = "UPDATE movie SET alur = ?, penokohan = ?, akting = ?, nilai = ? WHERE judul = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, movie.getAlur());
            preparedStatement.setDouble(2, movie.getPenokohan());
            preparedStatement.setDouble(3, movie.getAkting());
            preparedStatement.setDouble(4, movie.getRating());
            preparedStatement.setString(5, movie.getJudul());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMovie(String judul) {
        String sql = "DELETE FROM movie WHERE judul = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, judul);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

