package com.noticeme.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String getConverted(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return LocalDateTime.now().format(DATE_TIME_FORMATTER);
        } else {
            return localDateTime.format(DATE_TIME_FORMATTER);
        }
    }
}
