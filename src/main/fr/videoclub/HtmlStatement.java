package fr.videoclub;

public class HtmlStatement extends Statement{
    private final Customer customer;

    public HtmlStatement(Customer customer) {
        super(customer);
        this.customer = customer;
    }

    public String htmlStatement() {
        String result = headerString();
        for (Rental each : customer.getRentals()) {
            //show figures for each rental
            result += eachRentalString(each);
        }
        //add footer lines
        String footer1 = footerString();
        return result;
    }

    @Override
    public String footerString() {
        String footer = "<P>You owe <EM>" + String.valueOf(customer.getTotalCharges()) + "</EM><P>\n"
               + "On this rental you earned <EM>" +
                String.valueOf(customer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return footer;
    }

    @Override
    public String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
    }

    @Override
    public String headerString() {
        return "<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">"
                      + "<H1>Rentals for <EM>" + customer.getName() + "</EM></ H1><P>\n";
    }
}