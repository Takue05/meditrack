package com.takue.meditrack.dto;

import java.time.LocalDate;


public record AddMedicineRequest (
     String productCode,
     String productName,
     double mrp,
      LocalDate expiryDate,
      int quantity
){
}
