package fr.videoclub;

public class Movie {

    private String title;
    private MovieCategory movieCategory;

    public Movie(String title, MovieCategory movieCategory) {
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return movieCategory.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return movieCategory.getFrequentRenterPoints(daysRented);
    }
}
