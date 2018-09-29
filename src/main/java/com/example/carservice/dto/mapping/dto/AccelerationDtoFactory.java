package com.example.carservice.dto.mapping.dto;

import com.example.carservice.domain.AccelerationEntry;
import com.example.carservice.dto.AccelerationDto;
import org.springframework.stereotype.Service;

@Service
public class AccelerationDtoFactory implements DtoFactory<AccelerationDto, AccelerationEntry> {

    @Override
    public AccelerationDto makeDto(AccelerationEntry entry) {
        AccelerationDto dto = new AccelerationDto();
        dto.setMph(entry.getMph());
        dto.setSeconds(entry.getSeconds());
        return dto;
    }
}
