package com.takue.meditrack.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicineDto {
    private String  medicineId;
    private String productCode;
    private String productName;
    private double mrp;
    private LocalDate expiryDate;
    private int quantity;
}
