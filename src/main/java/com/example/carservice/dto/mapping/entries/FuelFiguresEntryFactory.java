package com.example.carservice.dto.mapping.entries;

import com.example.carservice.domain.FuelFiguresEntry;
import com.example.carservice.dto.FuelFiguresDto;
import org.springframework.stereotype.Service;

@Service
public class FuelFiguresEntryFactory implements EntryFactory<FuelFiguresEntry, FuelFiguresDto> {

    @Override
    public FuelFiguresEntry makeEntry(FuelFiguresDto dto) {
        FuelFiguresEntry entry = new FuelFiguresEntry();
        entry.setMpg(dto.getMpg());
        entry.setSpeed(dto.getSpeed());
        entry.setUsageDescription(dto.getUsageDescription());
        return entry;
    }
}
