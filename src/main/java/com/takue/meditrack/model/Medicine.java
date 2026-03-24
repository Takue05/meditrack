package com.takue.meditrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String  medicineId;

   private String productCode;
   private String productName;
   private double mrp;
   private LocalDate expiryDate;
   private int quantity;

}
