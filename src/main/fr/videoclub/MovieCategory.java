package fr.videoclub;

enum MovieCategory {
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
