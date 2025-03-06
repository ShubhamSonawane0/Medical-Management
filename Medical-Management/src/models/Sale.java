package models;

public class Sale {

	    private int saleId;
	    private String medicineName;
	    private int quantity;
	    private double totalAmount;

	    public Sale(int saleId, String medicineName, int quantity, double totalAmount) {
	        this.saleId = saleId;
	        this.medicineName = medicineName;
	        this.quantity = quantity;
	        this.totalAmount = totalAmount;
	    }

	    public int getSaleId() { return saleId; }
	    public String getMedicineName() { return medicineName; }
	    public int getQuantity() { return quantity; }
	    public double getTotalAmount() { return totalAmount; }
	}



