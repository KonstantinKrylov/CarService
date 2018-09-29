package com.example.carservice.dto.mapping.entries;

import com.example.carservice.domain.EngineEntry;
import com.example.carservice.dto.EngineDto;
import org.springframework.stereotype.Service;

@Service
public class EngineEntryFactory implements EntryFactory<EngineEntry, EngineDto> {
    @Override
    public EngineEntry makeEntry(EngineDto dto) {
        EngineEntry entry = new EngineEntry();
        entry.setCapacity(dto.getCapacity());
        entry.setManufacturerCode(dto.getManufacturerCode());
        entry.setMaxRpm(dto.getMaxRpm());
        entry.setNumCylinders(dto.getNumCylinders());
        return entry;
    }
}
