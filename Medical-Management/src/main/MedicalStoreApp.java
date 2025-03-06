package main;

import models.Medicine;
import services.InventoryService;
import services.SalesService;
import utils.InputHelper;

public class MedicalStoreApp {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        SalesService sales = new SalesService();
        int choice;

        do {
            System.out.println("\nMedical Store Management System");
            System.out.println("1. Add Medicine");
            System.out.println("2. Update Stock");
            System.out.println("3. View Medicines");
            System.out.println("4. Sell Medicine");
            System.out.println("5. View Sales");
            System.out.println("6. Exit");

            choice = InputHelper.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int id = InputHelper.getInt("Enter Medicine ID: ");
                    String name = InputHelper.getString("Enter Medicine Name: ");
                    double price = InputHelper.getDouble("Enter Medicine Price: ");
                    int quantity = InputHelper.getInt("Enter Medicine Quantity: ");
                    inventory.addMedicine(new Medicine(id, name, price, quantity));
                    System.out.println("Medicine added successfully.");
                    break;

                case 2:
                    int updateId = InputHelper.getInt("Enter Medicine ID to update stock: ");
                    int updateQuantity = InputHelper.getInt("Enter quantity to add: ");
                    inventory.updateStock(updateId, updateQuantity);
                    break;

                case 3:
                    System.out.println("Available Medicines:");
                    for (Medicine medicine : inventory.getAllMedicines()) {
                        System.out.println("ID: " + medicine.getId() + ", Name: " + medicine.getName() +
                                ", Price: " + medicine.getPrice() + ", Quantity: " + medicine.getQuantity());
                    }
                    break;

                case 4:
                    int sellId = InputHelper.getInt("Enter Medicine ID to sell: ");
                    int sellQuantity = InputHelper.getInt("Enter quantity to sell: ");
                    Medicine medicineToSell = inventory.findMedicineById(sellId);
                    sales.sellMedicine(medicineToSell, sellQuantity);
                    break;

                case 5:
                    sales.viewSales();
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}
