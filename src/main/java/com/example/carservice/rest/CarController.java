package com.example.carservice.rest;

import com.example.carservice.dto.CarDto;
import com.example.carservice.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @GetMapping("/{id}")
    public Mono<CarDto> getById(@PathVariable("id") String id) {
        return carService.getById(id);
    }

    @GetMapping("/serial/{number}")
    public Mono<CarDto> getBySerial(@PathVariable("number") String number) {

        log.info("Get car bySerial:{}", number);
        return carService.getBySerial(number);
    }

    @PostMapping
    public Mono<CarDto> saveCar(@RequestBody CarDto dto) {
        return carService.save(dto);
    }
}
