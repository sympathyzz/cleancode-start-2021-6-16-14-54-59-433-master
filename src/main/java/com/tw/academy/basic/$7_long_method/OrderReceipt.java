package com.tw.academy.basic.$7_long_method;

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

    public String printReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(HEADER);
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());

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

            double salesTax = lineItem.getTotalAmount() * .10;
            totalSalesTax += salesTax;

            totalSales += lineItem.getTotalAmount() + salesTax;
        }

        receipt.append(SALES).append(INDENTATION).append(totalSalesTax);

        receipt.append(TOTAL_AMOUNT).append(INDENTATION).append(totalSales);
        return receipt.toString();
    }


}