package fr.videoclub;

public class HtmlStatement extends Statement{
    private final Customer customer;

    public HtmlStatement(Customer customer) {
        super(customer);
        this.customer = customer;
    }

    public String htmlStatement() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.headerString());
        String result;
        for (Rental each : customer.getRentals()) {
            //show figures for each rental
            stringBuilder.append(eachRentalString(each));
        }
        //add footer lines
        stringBuilder.append(footerString());
        return new String(stringBuilder);
    }

    @Override
    public String footerString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<P>You owe <EM>");
        stringBuilder.append(String.valueOf(customer.getTotalCharges()));
        stringBuilder.append("</EM><P>\n");
        stringBuilder.append("On this rental you earned <EM>");
        stringBuilder.append(String.valueOf(customer.getTotalFrequentRenterPoints()));
        stringBuilder.append("</EM> frequent renter points<P>");


        return new String(stringBuilder);
    }

    @Override
    public String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
    }

    @Override
    public String headerString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">");
        stringBuilder.append("<H1>Rentals for <EM>");
        stringBuilder.append(customer.getName());
        stringBuilder.append("</EM></ H1><P>\n");
        return new String(stringBuilder);
    }
}