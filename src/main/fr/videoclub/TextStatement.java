package fr.videoclub;

public class TextStatement {
    private final Customer customer;

    public TextStatement(Customer customer) {
        this.customer = customer;
    }

    public String value() {
        String result = headerString();

        for (Rental rental : customer.getRentals()) {
            // show figures for this rental
            result += eachRentalString(rental);
        }

        // add footer lines
        result = footerString(result);

        return result;
    }

    private String footerString(String result) {
        result += "Amount owed is " + String.valueOf(customer.getTotalCharges()) + "\n";
        result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }

    private String eachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rental.getCharge()) + "\n";
    }

    private String headerString() {
        return "Rental Record for " + customer.getName() + "\n";
    }
}