package com.example.carservice.dto.mapping.dto;

import com.example.carservice.domain.PerformanceFiguresEntry;
import com.example.carservice.dto.AccelerationDto;
import com.example.carservice.dto.PerformanceFiguresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceFiguresDtoFactory implements DtoFactory<PerformanceFiguresDto, PerformanceFiguresEntry> {

    private final AccelerationDtoFactory accelerationDtoFactory;

    @Override
    public PerformanceFiguresDto makeDto(PerformanceFiguresEntry entry) {
        PerformanceFiguresDto dto = new PerformanceFiguresDto();
        AccelerationDto accelerationDto = accelerationDtoFactory.makeDto(entry.getAcceleration());
        dto.setAcceleration(accelerationDto);
        dto.setOctaneRating(entry.getOctaneRating());
        return dto;
    }
}
