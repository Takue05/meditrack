package com.takue.meditrack.dto;

import java.time.LocalDate;

public record MedicineDto (String  medicineId,  String productCode, String productName,
     double mrp,  LocalDate expiryDate, int quantity){
}
