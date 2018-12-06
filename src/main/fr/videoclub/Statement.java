package fr.videoclub;

public abstract class Statement {
    protected final Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }

    public String value() {
        String result = headerString();
        for (Rental rental : customer.getRentals()) {

            // show figures for this rental
            result += eachRentalString(rental);

        }
        result += footerString();

        return result;
    }

    protected abstract String footerString();

    protected abstract String eachRentalString(Rental rental);

    protected abstract String headerString();
}
