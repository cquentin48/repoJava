package fr.videoclub;

public class Movie {

    enum Category {
        CHILDREN {
            @Override
            double getCharge(int daysRented) {
                double result = 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                return result;
            }
        },
        NEW_RELEASE {
            @Override
            double getCharge(int daysRented) {
                return daysRented * 3;
            }

            @Override
            int getFrequentRenterPoints(int daysRented) {
                return (daysRented > 1) ? 2 : 1;
            }
        },
        REGULAR {
            @Override
            double getCharge(int daysRented) {
                double result = 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                return result;
            }
        };

        abstract double getCharge(int daysRented);

        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    }

    private String title;
    private Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return category.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return category.getFrequentRenterPoints(daysRented);
    }
}
