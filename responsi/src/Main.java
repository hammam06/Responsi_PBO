import controller.MovieController;
import entity.Movie;
import model.MovieModel;
import model.MovieModelImpl;
import util.DatabaseUtil;
import view.MovieView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseUtil.getConnection();
        MovieModel movieModel = new MovieModelImpl(connection);
        MovieView movieView = new MovieView();

        new MovieController(movieView, movieModel);

    }
}
