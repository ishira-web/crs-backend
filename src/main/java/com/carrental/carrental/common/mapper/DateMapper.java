package com.carrental.carrental.common.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateMapper {

    // ==============================
    // STANDARD DATE FORMATS
    // ==============================
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    // ==============================
    // STRING -> LocalDate
    // ==============================
    public static LocalDate toLocalDate(String date) {
        if (date == null || date.isBlank()) {
            return null;
        }
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    // ==============================
    // LocalDate -> STRING
    // ==============================
    public static String toDateString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DATE_FORMATTER);
    }

    // ==============================
    // STRING -> LocalDateTime
    // ==============================
    public static LocalDateTime toLocalDateTime(String dateTime) {
        if (dateTime == null || dateTime.isBlank()) {
            return null;
        }
        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

    // ==============================
    // LocalDateTime -> STRING
    // ==============================
    public static String toDateTimeString(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    // ==============================
    // PREVENT INSTANTIATION
    // ==============================
    private DateMapper() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }
}
