package services;


import models.Medicine;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Medicine> medicines;

    public InventoryService() {
        this.medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void updateStock(int medicineId, int quantity) {
        Medicine medicine = findMedicineById(medicineId);
        if (medicine != null) {
            medicine.addQuantity(quantity);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Medicine not found.");
        }
    }

    public Medicine findMedicineById(int id) {
        for (Medicine medicine : medicines) {
            if (medicine.getId() == id) return medicine;
        }
        return null;
    }

    public List<Medicine> getAllMedicines() {
        return medicines;
    }
}


