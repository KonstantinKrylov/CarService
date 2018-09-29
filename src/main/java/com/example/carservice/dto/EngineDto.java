package com.example.carservice.dto;

import lombok.Data;

@Data
public class EngineDto {
    private Integer capacity;
    private Short numCylinders;
    private Integer maxRpm;
    private Character manufacturerCode;
}
