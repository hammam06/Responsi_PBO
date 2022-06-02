package controller;

import entity.Movie;
import model.MovieModel;
import view.MovieView;

public class MovieController {
    private final MovieView view;
    private final MovieModel model;

    public MovieController(MovieView view, MovieModel model) {
        this.view = view;
        this.model = model;

        Movie[] movies = this.model.getAllMovies();
        this.view.updateMovie(movies);

        this.view.btnTambah.addActionListener(e -> {
            try {

                String judul = this.view.getJudul();
                double alur = Double.parseDouble(this.view.getAlur());
                double penokohan = Double.parseDouble(this.view.getPenokohan());
                double akting = Double.parseDouble(this.view.getAkting());

                this.validateData(alur, penokohan, akting);


                Movie movie = new Movie();
                movie.setJudul(judul);
                movie.setAlur(alur);
                movie.setPenokohan(penokohan);
                movie.setAkting(akting);

                this.model.addMovie(movie);
                this.view.resetForm();
                this.updateMovie();
            } catch (Exception ex) {
                this.view.showErrorMessage(ex.getMessage());
            }
        });

        this.view.tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = view.tabel.getSelectedRow();
                view.textJudul.setText(view.tabel.getValueAt(row, 0).toString());
                view.textAlur.setText(view.tabel.getValueAt(row, 1).toString());
                view.textPenokohan.setText(view.tabel.getValueAt(row, 2).toString());
                view.textAkting.setText(view.tabel.getValueAt(row, 3).toString());
            }
        });

        this.view.btnDelete.addActionListener(e -> {
            try {
                String judul = view.getJudul();

                model.deleteMovie(judul);
                this.updateMovie();
                this.view.resetForm();
            } catch (Exception ex) {
                this.view.showErrorMessage(ex.getMessage());
            }

        });

        this.view.btnReset.addActionListener(e -> {
            this.view.resetForm();
        });

        this.view.btnUpdate.addActionListener(e -> {
            try {
                String judul = view.getJudul();
                double alur = Double.parseDouble(view.getAlur());
                double penokohan = Double.parseDouble(view.getPenokohan());
                double akting = Double.parseDouble(view.getAkting());

                this.validateData(alur, penokohan, akting);

                Movie movie = new Movie();
                movie.setJudul(judul);
                movie.setAlur(alur);
                movie.setPenokohan(penokohan);
                movie.setAkting(akting);

                model.updateMovie(movie);
                this.updateMovie();
                this.view.resetForm();
            } catch (Exception ex) {
                this.view.showErrorMessage(ex.getMessage());
            }
        });
    }

    private void updateMovie() {
        Movie[] movies = this.model.getAllMovies();
        this.view.updateMovie(movies);
    }

    private void validateData(double alur, double penokohan, double akting) throws Exception {
        if (alur < 0) {
            throw new Exception("Alur tidak boleh kurang dari 0");
        }

        if (penokohan < 0) {
            throw new Exception("Penokohan tidak boleh kurang dari 0");
        }

        if (akting < 0) {
            throw new Exception("Akting tidak boleh kurang dari 0");
        }

        if (alur > 5) {
            throw new Exception("Alur tidak boleh lebih dari 5");
        }

        if (penokohan > 5) {
            throw new Exception("Penokohan tidak boleh lebih dari 5");
        }

        if (akting > 5) {
            throw new Exception("Akting tidak boleh lebih dari 5");
        }
    }

}
