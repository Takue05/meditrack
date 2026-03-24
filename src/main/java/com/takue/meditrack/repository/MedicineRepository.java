package com.takue.meditrack.repository;

import com.takue.meditrack.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, String> {
    Optional<Medicine> findByMedicineId(String id);
}
