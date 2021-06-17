package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order o;
    static final String HEADER = "======Printing Orders======\n";
    static final String SALES = "Sales Tax";
    static final String TOTAL_AMOUNT = "Total Amount";
    static final String LINE_BREAKS = "\n";
    static final String INDENTATION = "\t";

    public OrderReceipt(Order o) {
        this.o = o;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append(HEADER);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(INDENTATION);
            output.append(lineItem.getPrice());
            output.append(INDENTATION);
            output.append(lineItem.getQuantity());
            output.append(INDENTATION);
            output.append(lineItem.getTotalAmount());
            output.append(LINE_BREAKS);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.getTotalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.getTotalAmount() + salesTax;
        }

        // prints the state tax
        output.append(SALES).append('\t').append(totSalesTx);

        // print total amount
        output.append(TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
    }
}