package fr.videoclub;

public class TextStatement extends Statement {

    public TextStatement(Customer customer) {
        super(customer);
    }

    @Override
    protected String footerString() {
        String footer = "Amount owed is " + String.valueOf(customer.getTotalCharges()) + "\n";
        footer += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints())
                + " frequent renter points";
        return footer;
    }

    @Override
    protected String eachRentalString(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rental.getCharge()) + "\n";
    }

    @Override
    protected String headerString() {
        return "Rental Record for " + customer.getName() + "\n";
    }
}