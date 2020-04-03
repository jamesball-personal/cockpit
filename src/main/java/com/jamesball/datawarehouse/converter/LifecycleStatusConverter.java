package com.jamesball.datawarehouse.converter;

import com.jamesball.datawarehouse.enumeration.ExecutionStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class LifecycleStatusConverter implements AttributeConverter<ExecutionStatus, Long> {

    @Override
    public Long convertToDatabaseColumn(ExecutionStatus executionStatus) {
        return executionStatus.getId();
    }

    @Override
    public ExecutionStatus convertToEntityAttribute(Long id) {
        return Stream.of(ExecutionStatus.values())
                .filter(value -> value.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}