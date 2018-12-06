package fr.videoclub;public class TextStatement{private final fr.videoclub.Customer customer;	public TextStatement(fr.videoclub.Customer customer)	{		this.customer = customer;	}public java.lang.String textStatement() {
        java.lang.String result = "Rental Record for " + customer.getName() + "\n";
        for (fr.videoclub.Rental rental : customer.getRentals()) {

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + java.lang.String.valueOf(rental.getCharge()) + "\n";

        }
        // add footer lines
        result += "Amount owed is " + java.lang.String.valueOf(customer.getTotalCharges()) + "\n";
        result += "You earned " + java.lang.String.valueOf(customer.getTotalFrequentRenterPoints())
                + " frequent renter points";

        return result;
    }}