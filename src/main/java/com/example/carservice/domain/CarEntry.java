package com.example.carservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class CarEntry {

    @Id
    private String id;
    private String ownerName;
    private String serialNumber;
    private Short modelYear;
    private String code;
    private String vehicleCode;
    private EngineEntry engine;
    private FuelFiguresEntry fuelFigures;
    private PerformanceFiguresEntry performanceFigures;
    private String manufacturer;
    private String model;
    private String activationCode;
}
