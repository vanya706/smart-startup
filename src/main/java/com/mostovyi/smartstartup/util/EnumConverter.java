package com.mostovyi.smartstartup.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class EnumConverter implements AttributeConverter<Set<DayOfWeek>, String> {

    private static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(Set<DayOfWeek> attribute) {
        if (CollectionUtils.isEmpty(attribute)) {
            return null;
        }
        return attribute.stream()
                .map(Enum::name)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public Set<DayOfWeek> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return Set.of();
        }
        return Arrays.stream(dbData.split(DELIMITER))
                .map(DayOfWeek::valueOf)
                .collect(Collectors.toSet());
    }

}
