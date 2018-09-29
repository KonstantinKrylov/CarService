package com.example.carservice.dto.mapping.dto;

import com.example.carservice.domain.CarEntry;
import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.EngineDto;
import com.example.carservice.dto.FuelFiguresDto;
import com.example.carservice.dto.PerformanceFiguresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarDtoFactory implements DtoFactory<CarDto, CarEntry> {

    private final EngineDtoFactory engineDtoFactory;
    private final FuelFiguresDtoFactory fuelFiguresEntryFactory;
    private final PerformanceFiguresDtoFactory performanceFiguresDtoFactory;

    @Override
    public CarDto makeDto(CarEntry entry) {
        CarDto dto = new CarDto();
        dto.setId(entry.getId());
        dto.setOwnerName(entry.getOwnerName());
        dto.setSerialNumber(entry.getSerialNumber());
        dto.setModelYear(entry.getModelYear());
        dto.setCode(entry.getCode());
        dto.setVehicleCode(entry.getVehicleCode());

        EngineDto engineDto = engineDtoFactory.makeDto(entry.getEngine());
        dto.setEngine(engineDto);

        FuelFiguresDto fuelFiguresDto = fuelFiguresEntryFactory.makeDto(entry.getFuelFigures());
        dto.setFuelFigures(fuelFiguresDto);

        PerformanceFiguresDto performanceFiguresDto =
                performanceFiguresDtoFactory.makeDto(entry.getPerformanceFigures());
        dto.setPerformanceFigures(performanceFiguresDto);

        dto.setManufacturer(entry.getManufacturer());
        dto.setModel(entry.getModel());
        dto.setActivationCode(entry.getActivationCode());



        return dto;
    }
}
