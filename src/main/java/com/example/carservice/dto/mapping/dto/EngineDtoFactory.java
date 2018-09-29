package com.example.carservice.dto.mapping.dto;

import com.example.carservice.domain.EngineEntry;
import com.example.carservice.dto.EngineDto;
import org.springframework.stereotype.Service;

@Service
public class EngineDtoFactory implements DtoFactory<EngineDto, EngineEntry> {

    @Override
    public EngineDto makeDto(EngineEntry entry) {
        EngineDto dto = new EngineDto();
        dto.setCapacity(entry.getCapacity());
        dto.setManufacturerCode(entry.getManufacturerCode());
        dto.setMaxRpm(entry.getMaxRpm());
        dto.setNumCylinders(entry.getNumCylinders());
        return dto;
    }
}
