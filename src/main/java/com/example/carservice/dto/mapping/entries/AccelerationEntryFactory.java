package com.example.carservice.dto.mapping.entries;

import com.example.carservice.domain.AccelerationEntry;
import com.example.carservice.dto.AccelerationDto;
import org.springframework.stereotype.Service;

@Service
public class AccelerationEntryFactory implements EntryFactory<AccelerationEntry, AccelerationDto> {

    @Override
    public AccelerationEntry makeEntry(AccelerationDto dto) {
        AccelerationEntry entry = new AccelerationEntry();
        entry.setMph(dto.getMph());
        entry.setSeconds(dto.getSeconds());
        return entry;
    }
}
