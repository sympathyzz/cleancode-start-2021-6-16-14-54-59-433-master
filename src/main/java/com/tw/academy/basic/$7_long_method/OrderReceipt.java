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
        double totalSalesWithoutTax = calculateTotalSalesWithoutTax(order);
        double totalSalesTax = calculateTotalSalesTax(order);
        double totalSales=totalSalesWithoutTax+totalSalesTax;
        StringBuilder salesContent = getSalesContent(order, totalSales, totalSalesTax);
        receipt.append(salesContent);
        return receipt.toString();
    }

    private double calculateTotalSalesWithoutTax(Order order){
        double totalSales=0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSales+=lineItem.getTotalAmount();
        }
        return totalSales;
    }

    private double calculateTotalSalesTax(Order order){
        double totalSalesTax=0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSalesTax+=lineItem.getTotalAmount() * 0.1;
        }
        return totalSalesTax;
    }

    private StringBuilder getSalesContent(Order order,double totalSales,double totalSalesTax){
        StringBuilder salesContent=new StringBuilder();
        for (LineItem lineItem : order.getLineItems()) {
            salesContent.append(lineItem.getDescription());
            salesContent.append(INDENTATION);
            salesContent.append(lineItem.getPrice());
            salesContent.append(INDENTATION);
            salesContent.append(lineItem.getQuantity());
            salesContent.append(INDENTATION);
            salesContent.append(lineItem.getTotalAmount());
            salesContent.append(LINE_BREAKS);
        }
        salesContent.append(SALES).append(INDENTATION).append(totalSalesTax);

        salesContent.append(TOTAL_AMOUNT).append(INDENTATION).append(totalSales);
        return salesContent;
    }


}