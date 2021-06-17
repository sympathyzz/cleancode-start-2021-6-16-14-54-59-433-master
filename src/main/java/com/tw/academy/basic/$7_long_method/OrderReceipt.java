package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order order;
    static final String HEADER = "======Printing Orders======\n";
    static final String SALES = "Sales Tax";
    static final String TOTAL_AMOUNT = "Total Amount";
    static final String LINE_BREAKS = "\n";
    static final String INDENTATION = "\t";

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();

        // print headers
        receipt.append(HEADER);

        // print date, bill no, customer name
//        receipt.append("Date - " + order.getDate();
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
//        receipt.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totalSalesTax = 0d;
        double totalSales = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getDescription());
            receipt.append(INDENTATION);
            receipt.append(lineItem.getPrice());
            receipt.append(INDENTATION);
            receipt.append(lineItem.getQuantity());
            receipt.append(INDENTATION);
            receipt.append(lineItem.getTotalAmount());
            receipt.append(LINE_BREAKS);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.getTotalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalSales += lineItem.getTotalAmount() + salesTax;
        }

        // prints the state tax
        receipt.append(SALES).append('\t').append(totalSalesTax);

        // print total amount
        receipt.append(TOTAL_AMOUNT).append('\t').append(totalSales);
        return receipt.toString();
    }
}