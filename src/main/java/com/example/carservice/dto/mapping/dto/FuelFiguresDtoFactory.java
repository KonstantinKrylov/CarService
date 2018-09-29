package com.example.carservice.dto.mapping.dto;

import com.example.carservice.domain.FuelFiguresEntry;
import com.example.carservice.dto.FuelFiguresDto;
import org.springframework.stereotype.Service;

@Service
public class FuelFiguresDtoFactory implements DtoFactory<FuelFiguresDto, FuelFiguresEntry> {


    @Override
    public FuelFiguresDto makeDto(FuelFiguresEntry entry) {
        FuelFiguresDto dto = new FuelFiguresDto();
        dto.setMpg(entry.getMpg());
        dto.setSpeed(entry.getSpeed());
        dto.setUsageDescription(entry.getUsageDescription());
        return dto;
    }
}
