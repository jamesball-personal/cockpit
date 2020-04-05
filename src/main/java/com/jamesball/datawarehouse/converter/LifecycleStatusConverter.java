package com.jamesball.datawarehouse.converter;

import com.jamesball.datawarehouse.enumeration.LifecycleStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class LifecycleStatusConverter implements AttributeConverter<LifecycleStatus, Long> {

    @Override
    public Long convertToDatabaseColumn(LifecycleStatus lifecycleStatus) {
        return lifecycleStatus.getId();
    }

    @Override
    public LifecycleStatus convertToEntityAttribute(Long id) {
        return Stream.of(LifecycleStatus.values())
                .filter(value -> value.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
