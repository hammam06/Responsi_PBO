package view;

import entity.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MovieView extends JFrame {
    JLabel labeljudul = new JLabel("Judul");
    JLabel labelAlur = new JLabel("Alur");
    JLabel labelPenokohan = new JLabel("Penokohan");
    JLabel labelAkting = new JLabel("Akting");

    public JTextField textJudul = new JTextField();
    public JTextField textAlur = new JTextField();
    public JTextField textPenokohan = new JTextField();
    public JTextField textAkting = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel defaultTableModel;
    JScrollPane scrollPane;
    public String[] columnName = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};
    private int idMovie = 0;

    public MovieView() {
        defaultTableModel = new DefaultTableModel(null, columnName) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel = new JTable(defaultTableModel);
        scrollPane = new JScrollPane(tabel);

        setTitle("Data Movie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700, 400);

        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);

        add(labeljudul);
        labeljudul.setBounds(510, 20, 90, 20);
        add(textJudul);
        textJudul.setBounds(510, 40, 120, 20);

        add(labelAlur);
        labelAlur.setBounds(510, 60, 90, 20);
        add(textAlur);
        textAlur.setBounds(510, 80, 120, 20);

        add(labelPenokohan);
        labelPenokohan.setBounds(510, 100, 90, 20);
        add(textPenokohan);
        textPenokohan.setBounds(510, 120, 120, 20);

        add(labelAkting);
        labelAkting.setBounds(510, 140, 90, 20);
        add(textAkting);
        textAkting.setBounds(510, 160, 120, 20);

        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);

        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);

        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);

        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }

    public String getJudul() {
        return textJudul.getText();
    }

    public String getAlur() {
        return textAlur.getText();
    }

    public String getPenokohan() {
        return textPenokohan.getText();
    }

    public String getAkting() {
        return textAkting.getText();
    }

    public void updateMovie(Movie[] movies) {
        defaultTableModel.setRowCount(0);
        for (Movie movie : movies) {
            Object[] data = {movie.getJudul(), movie.getAlur(), movie.getPenokohan(), movie.getAkting(), movie.getRating()};
            defaultTableModel.addRow(data);
        }

    }

    public void resetForm() {
        textJudul.setText("");
        textAlur.setText("");
        textPenokohan.setText("");
        textAkting.setText("");
    }

    public void updateForm(Movie movie) {
        textJudul.setText(movie.getJudul());
        textAlur.setText(String.valueOf(movie.getAlur()));
        textPenokohan.setText(String.valueOf(movie.getPenokohan()));
        textAkting.setText(String.valueOf(movie.getAkting()));
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}