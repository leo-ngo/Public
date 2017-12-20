package lec10;

// This class represents a customer renting a movie
class Rental {
    private Movie movie;
    private int daysRented;
    private int frequentRenterPoints = 0;
    public static final double REGULAR_BASE_COST = 2.0;
    public static final double REGULAR_PER_DAY_COST = 1.5;
    public static final double NEW_RELEASE_BASE_COST = 0;
    public static final double NEW_RELEASE_PER_DAY_COST = 3.0;
    public static final double CHILDREN_BASE_COST = 1.5;
    public static final double CHILDREN_PER_DAY_COST = 1.5;


    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        frequentRenterPoints++;
    }

    public double getRentalCost() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += REGULAR_BASE_COST;
                if (daysRented > 2) thisAmount += (daysRented - 2) * REGULAR_PER_DAY_COST;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * NEW_RELEASE_PER_DAY_COST;
                frequentRenterPoints++;
                break;
            case Movie.CHILDREN:
                thisAmount += CHILDREN_BASE_COST;
                if (daysRented > 3) thisAmount += (daysRented - 3) * CHILDREN_PER_DAY_COST;
                break;
        }
        return thisAmount;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
