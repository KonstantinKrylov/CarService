package com.example.carservice.dto.mapping.entries;

import com.example.carservice.domain.CarEntry;
import com.example.carservice.domain.EngineEntry;
import com.example.carservice.domain.FuelFiguresEntry;
import com.example.carservice.domain.PerformanceFiguresEntry;
import com.example.carservice.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarEntryFactory implements EntryFactory<CarEntry, CarDto> {

    private final EngineEntryFactory engineEntryFactory;
    private final FuelFiguresEntryFactory fuelFiguresEntryFactory;
    private final PerformanceFiguresFactory performanceFiguresFactory;

    @Override
    public CarEntry makeEntry(CarDto dto) {
        CarEntry entry = new CarEntry();
        entry.setId(dto.getId());

        entry.setOwnerName(dto.getOwnerName());
        entry.setSerialNumber(dto.getSerialNumber());
        entry.setModelYear(dto.getModelYear());
        entry.setCode(dto.getCode());
        entry.setVehicleCode(dto.getVehicleCode());

        EngineEntry engineEntry = engineEntryFactory.makeEntry(dto.getEngine());
        entry.setEngine(engineEntry);

        FuelFiguresEntry fuelFiguresEntry = fuelFiguresEntryFactory.makeEntry(dto.getFuelFigures());
        entry.setFuelFigures(fuelFiguresEntry);

        PerformanceFiguresEntry performanceFiguresEntry =
                performanceFiguresFactory.makeEntry(dto.getPerformanceFigures());
        entry.setPerformanceFigures(performanceFiguresEntry);

        entry.setManufacturer(dto.getManufacturer());
        entry.setModel(dto.getModel());
        entry.setActivationCode(dto.getActivationCode());
        return entry;
    }
}
