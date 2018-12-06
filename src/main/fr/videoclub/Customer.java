package fr.videoclub;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(rental.getCharge()) + "\n";

        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharges()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    private double getTotalCharges() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        String result = "<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">";
        result += "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        for (Rental each : rentals) {
            //show figures for each rental
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharges()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }
}
