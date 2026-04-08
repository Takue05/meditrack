package com.takue.meditrack.controller;


import com.takue.meditrack.dto.AddMedicineRequest;
import com.takue.meditrack.dto.MedicineDto;
import com.takue.meditrack.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor
public class MedicineController {
    private final MedicineService service;

    @PostMapping
    public ResponseEntity<MedicineDto>addMedicine(@RequestBody AddMedicineRequest request,
                                                  UriComponentsBuilder uriBuilder){
        MedicineDto dto = service.add(request);
        URI uri = uriBuilder.path("/medicines/{id}").buildAndExpand(dto.medicineId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDto> getMedicine(@PathVariable String id) {
      return service.findById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
    }


}
