package services;

import models.Medicine;
import models.Sale;
import java.util.ArrayList;
import java.util.List;

public class SalesService {
    private List<Sale> sales;
    private int saleCounter;

    public SalesService() {
        this.sales = new ArrayList<>();
        this.saleCounter = 1;
    }

    public void sellMedicine(Medicine medicine, int quantity) {
        if (medicine != null && medicine.getQuantity() >= quantity) {
            double totalAmount = medicine.getPrice() * quantity;
            medicine.reduceQuantity(quantity);
            sales.add(new Sale(saleCounter++, medicine.getName(), quantity, totalAmount));
            System.out.println("Sale successful! Total amount: " + totalAmount);
        } else {
            System.out.println("Insufficient stock.");
        }
    }

    public void viewSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
        } else {
            for (Sale sale : sales) {
                System.out.println("Sale ID: " + sale.getSaleId());
                System.out.println("Medicine: " + sale.getMedicineName());
                System.out.println("Quantity: " + sale.getQuantity());
                System.out.println("Total Amount: " + sale.getTotalAmount());
                System.out.println("--------------------");
            }
        }
    }
}


