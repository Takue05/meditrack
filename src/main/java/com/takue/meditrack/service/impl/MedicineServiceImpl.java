package com.takue.meditrack.service.impl;

import com.takue.meditrack.dto.AddMedicineRequest;
import com.takue.meditrack.dto.MedicineDto;
import com.takue.meditrack.mapper.MedicineMapper;
import com.takue.meditrack.model.Medicine;
import com.takue.meditrack.repository.MedicineRepository;
import com.takue.meditrack.service.MedicineService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final MedicineMapper medicineMapper;
    private final MedicineRepository medicineRepository;

    public MedicineServiceImpl(MedicineMapper medicineMapper, MedicineRepository medicineRepository) {
        this.medicineMapper = medicineMapper;
        this.medicineRepository = medicineRepository;
    }

    @Override
    public MedicineDto add(AddMedicineRequest request) {
        Medicine medicine = medicineMapper.toEntity(request);
        Medicine saved =medicineRepository.save(medicine);
        return medicineMapper.toDto(saved);
    }

    @Override
    public Optional<MedicineDto> findById(String id){
        return medicineRepository.findByMedicineId(id)
                .map(medicineMapper::toDto);
    }
}
