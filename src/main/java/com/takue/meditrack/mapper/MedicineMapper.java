package com.takue.meditrack.mapper;

import com.takue.meditrack.dto.AddMedicineRequest;
import com.takue.meditrack.dto.MedicineDto;
import com.takue.meditrack.model.Medicine;
import com.takue.meditrack.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicineMapper {

    @Mapping(target = "medicineId", ignore = true)
    Medicine toEntity(AddMedicineRequest request);

    MedicineDto toDto(Medicine medicine);


}
