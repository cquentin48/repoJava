package fr.videoclub;

import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        getRentals().add(arg);
    }

    public String getName() {
        return name;
    }

    public String textStatement() {
        return new TextStatement(this).value();
    }

    public double getTotalCharges() {
        double result = 0;
        for (Rental rental : getRentals()) {
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : getRentals()) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        String result = "<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">";
        result += "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        for (Rental each : getRentals()) {
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

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
