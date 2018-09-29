package com.example.carservice.repository;

import com.example.carservice.domain.CarEntry;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends ReactiveMongoRepository<CarEntry, String> {

    Mono<CarEntry> getBySerialNumber(String serialNumber);

}
