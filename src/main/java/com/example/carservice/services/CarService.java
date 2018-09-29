package com.example.carservice.services;

import com.example.carservice.domain.CarEntry;
import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.mapping.dto.CarDtoFactory;
import com.example.carservice.dto.mapping.entries.CarEntryFactory;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final CarDtoFactory carDtoFactory;
    private final CarEntryFactory carEntryFactory;

    public Mono<CarDto> getById(String id) {
        return repository.findById(id)
                .map(carDtoFactory::makeDto);
    }

    public Mono<CarDto> save(CarDto carDto){
        CarEntry entry = carEntryFactory.makeEntry(carDto);
        return repository.save(entry)
                .map(carDtoFactory::makeDto);
    }

    public Mono<CarDto> getBySerial(String number) {
        return repository.getBySerialNumber(number)
                .map(carDtoFactory::makeDto);
    }
}
