package com.example.carservice.dto.mapping.dto;

import java.util.List;
import java.util.stream.Collectors;

public interface DtoFactory<T, V> {

    T makeDto(V entry);

    default List<T> makeDtos(List<V> entry){
        return entry.stream()
                .map(this::makeDto)
                .collect(Collectors.toList());
    }
}
