package com.example.carservice.dto.mapping.entries;

import java.util.List;
import java.util.stream.Collectors;

public interface EntryFactory<T, V> {
    T makeEntry(V dto);

    default List<T> makeEntries(List<V> dtos) {
        return dtos.stream()
                .map(this::makeEntry)
                .collect(Collectors.toList());
    }
}
