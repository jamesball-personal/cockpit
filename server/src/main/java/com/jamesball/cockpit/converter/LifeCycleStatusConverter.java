package com.jamesball.cockpit.converter;

import com.jamesball.cockpit.enumeration.LifeCycleStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class LifeCycleStatusConverter implements AttributeConverter<LifeCycleStatus, Long> {

    @Override
    public Long convertToDatabaseColumn(LifeCycleStatus lifeCycleStatus) {
        return lifeCycleStatus.getId();
    }

    @Override
    public LifeCycleStatus convertToEntityAttribute(Long id) {
        return Stream.of(LifeCycleStatus.values())
                .filter(value -> value.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
