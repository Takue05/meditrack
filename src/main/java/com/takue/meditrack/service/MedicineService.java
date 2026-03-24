package com.takue.meditrack.service;

import com.takue.meditrack.dto.AddMedicineRequest;
import com.takue.meditrack.dto.MedicineDto;

import java.util.Optional;

public interface MedicineService {
    MedicineDto add(AddMedicineRequest request);

    Optional<MedicineDto> findById(String id);
}
