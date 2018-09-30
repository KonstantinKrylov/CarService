package com.example.carservice;

import com.example.carservice.domain.*;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FillerDb implements ApplicationRunner {

    private final CarRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CarEntry carEntry = getCarEntry();
        repository.save(carEntry).subscribe(entry->{}, throwable -> log.error("Exception when save initial data",throwable));
    }


    private CarEntry getCarEntry() {
        CarEntry entry = new CarEntry();
        entry.setId(UUID.randomUUID().toString());
        entry.setOwnerName("testOwner");
        entry.setSerialNumber("123456789");
        entry.setModelYear((short) 2015);
        entry.setCode("code");
        entry.setVehicleCode("vehicleCode");

        EngineEntry engine = new EngineEntry();
        engine.setNumCylinders((short) 4);
        engine.setMaxRpm(8000);
        engine.setManufacturerCode('B');
        engine.setCapacity(2000);
        entry.setEngine(engine);

        FuelFiguresEntry figuresEntry = new FuelFiguresEntry();
        figuresEntry.setUsageDescription("testDescription");
        figuresEntry.setSpeed(100);
        figuresEntry.setMpg(2.56f);
        entry.setFuelFigures(figuresEntry);

        PerformanceFiguresEntry performanceEntry = new PerformanceFiguresEntry();
        performanceEntry.setOctaneRating(98);

        AccelerationEntry accelerationEntry = new AccelerationEntry();
        accelerationEntry.setSeconds(4.3f);
        accelerationEntry.setMph(60);
        performanceEntry.setAcceleration(accelerationEntry);
        entry.setPerformanceFigures(performanceEntry);

        entry.setManufacturer("testManufacturer");
        entry.setModel("uber");
        entry.setActivationCode("123");
        return entry;
    }
}
