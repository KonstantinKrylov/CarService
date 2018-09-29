package com.example.carservice.dto.mapping.entries;

import com.example.carservice.domain.AccelerationEntry;
import com.example.carservice.domain.PerformanceFiguresEntry;
import com.example.carservice.dto.PerformanceFiguresDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceFiguresFactory implements EntryFactory<PerformanceFiguresEntry, PerformanceFiguresDto> {

    private final AccelerationEntryFactory accelerationEntryFactory;

    @Override
    public PerformanceFiguresEntry makeEntry(PerformanceFiguresDto dto) {
        PerformanceFiguresEntry entry = new PerformanceFiguresEntry();
        entry.setOctaneRating(dto.getOctaneRating());

        AccelerationEntry accelerationEntry = accelerationEntryFactory.makeEntry(dto.getAcceleration());
        entry.setAcceleration(accelerationEntry);

        return entry;
    }
}
