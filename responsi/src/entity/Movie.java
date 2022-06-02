package entity;

public class Movie {
    private String judul;
    private double alur;
    private double penokohan;
    private double akting;
    private double rating;

    public Movie(){}

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public double getAlur() {
        return alur;
    }

    public void setAlur(double alur) {
        this.alur = alur;
    }

    public double getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(double penokohan) {
        this.penokohan = penokohan;
    }

    public double getAkting() {
        return akting;
    }

    public void setAkting(double akting) {
        this.akting = akting;
    }

    public double getRating() {
        return (akting + penokohan + alur) / 3;

    }

}
