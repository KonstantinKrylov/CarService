package com.example.carservice.rest;

import com.example.carservice.domain.*;
import com.example.carservice.dto.*;
import com.example.carservice.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private CarRepository repository;

    @Before
    public void setUp() {
        client = client
                .mutate()
                .responseTimeout(Duration.ofMillis(30000))
                .build();
    }

    @Test
    public void getById() throws Exception {
        saveTestCar().subscribe(carEntry -> {

            String carId = carEntry.getId();

            client.get().uri("/api/car/{id}", carId)
                    .exchange()
                    .expectStatus().is2xxSuccessful()
                    .expectBody()
                    .jsonPath("id", carId);
        });
    }


    @Test
    public void getBySerial() throws Exception {
        saveTestCar().subscribe(carEntry -> {
            String serialNumber = carEntry.getSerialNumber();

            client.get().uri("/api/car/serial/{number}", serialNumber)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("serialNumber", serialNumber);
        });
    }

    @Test
    public void saveCar() throws Exception {
        CarDto carDto = getCarDto();
        client.post().uri("/api/car")
                .body(Mono.just(carDto), CarDto.class)
                .exchange()
                .expectStatus().isOk();

        CarEntry carEntry = repository.findById(carDto.getId()).block();
        assertNotNull(carEntry);
        assertEquals(carEntry.getId(), carDto.getId());
    }

    private Mono<CarEntry> saveTestCar() {
        CarEntry carEntry = getCarEntry();
        return repository.save(carEntry);
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

    public CarDto getCarDto() throws Exception {
        CarDto dto = new CarDto();
        dto.setId(UUID.randomUUID().toString());

        dto.setOwnerName("testOwner");
        dto.setSerialNumber("123456789");
        dto.setModelYear((short) 2015);
        dto.setCode("code");
        dto.setVehicleCode("vehicleCode");

        EngineDto engine = new EngineDto();
        engine.setNumCylinders((short) 4);
        engine.setMaxRpm(8000);
        engine.setManufacturerCode('B');
        engine.setCapacity(2000);
        dto.setEngine(engine);

        FuelFiguresDto figuresEntry = new FuelFiguresDto();
        figuresEntry.setUsageDescription("testDescription");
        figuresEntry.setSpeed(100);
        figuresEntry.setMpg(2.56f);
        dto.setFuelFigures(figuresEntry);

        PerformanceFiguresDto performanceFiguresDto = new PerformanceFiguresDto();
        performanceFiguresDto.setOctaneRating(98);

        AccelerationDto acceleration = new AccelerationDto();
        acceleration.setSeconds(4.3f);
        acceleration.setMph(60);
        performanceFiguresDto.setAcceleration(acceleration);
        dto.setPerformanceFigures(performanceFiguresDto);

        dto.setManufacturer("testManufacturer");
        dto.setModel("uber");
        dto.setActivationCode("123");
        return dto;
    }
}
