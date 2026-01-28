package com.carrental.carrental.common.utill;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    // ==============================
    // VALIDATE DATE RANGE
    // ==============================
    public static void validateDateRange(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End date must be after or equal to start date");
        }
    }

    // ==============================
    // CALCULATE RENTAL DAYS
    // ==============================
    // Business rule: Minimum 1 day rental
    public static long calculateRentalDays(LocalDate start, LocalDate end) {
        validateDateRange(start, end);

        long days = ChronoUnit.DAYS.between(start, end);

        // If same day, count as 1 day rental
        if (days == 0) {
            return 1;
        }

        return days;
    }

    // ==============================
    // CHECK DATE OVERLAP
    // ==============================
    // True if two date ranges overlap
    public static boolean isOverlapping(LocalDate start1, LocalDate end1,
                                        LocalDate start2, LocalDate end2) {

        validateDateRange(start1, end1);
        validateDateRange(start2, end2);

        // Overlap logic:
        // (start1 <= end2) && (start2 <= end1)
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }

    // ==============================
    // IS TODAY OR FUTURE
    // ==============================
    public static boolean isTodayOrFuture(LocalDate date) {
        return !date.isBefore(LocalDate.now());
    }

    // ==============================
    // PREVENT INSTANTIATION
    // ==============================
    private DateUtils() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }
}