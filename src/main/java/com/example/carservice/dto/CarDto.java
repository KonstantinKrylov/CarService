package com.example.carservice.dto;


import lombok.Data;

@Data
public class CarDto {
    private String id;
    private String ownerName;
    private String serialNumber;
    private Short modelYear;
    private String code;
    private String vehicleCode;
    private EngineDto engine;
    private FuelFiguresDto fuelFigures;
    private PerformanceFiguresDto performanceFigures;
    private String manufacturer;
    private String model;
    private String activationCode;


}