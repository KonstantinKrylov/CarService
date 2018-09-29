package com.example.carservice.domain;

import lombok.Data;

@Data
public class PerformanceFiguresEntry {

    private Integer octaneRating;
    private AccelerationEntry acceleration;

}
