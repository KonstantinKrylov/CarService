package com.example.carservice.domain;

import lombok.Data;

@Data
public class EngineEntry {
    private Integer capacity;
    private Short numCylinders;
    private Integer maxRpm;
    private Character manufacturerCode;
}
