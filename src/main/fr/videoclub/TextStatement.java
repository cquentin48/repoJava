package fr.videoclub;

public class TextStatement extends Statement {

    public TextStatement(Customer customer) {
        super(customer);
    }

    @Override
    protected String footerString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Amount owed is ");
        stringBuilder.append(String.valueOf(customer.getTotalCharges()));
        stringBuilder.append("\n");
        stringBuilder.append("You earned ");
        stringBuilder.append(String.valueOf(customer.getTotalFrequentRenterPoints()));
        stringBuilder.append(" frequent renter points");

        return new String(stringBuilder);
    }

    @Override
    protected String eachRentalString(Rental rental) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t");
        stringBuilder.append(rental.getMovie().getTitle());
        stringBuilder.append("\t");
        stringBuilder.append(String.valueOf(rental.getCharge()));
        stringBuilder.append("\n");
        return new String(stringBuilder);
    }

    @Override
    protected String headerString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Rental Record for ");
        stringBuilder.append(customer.getName());
        stringBuilder.append("\n");

        return new String(stringBuilder);
    }
}