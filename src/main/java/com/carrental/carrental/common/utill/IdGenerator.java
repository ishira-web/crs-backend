package com.carrental.carrental.common.utill;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public final class IdGenerator {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd");

    // ==============================
    // BOOKING CODE
    // Example: BK-20260128-482917
    // ==============================
    public static String generateBookingCode() {
        String datePart = LocalDate.now().format(DATE_FORMAT);
        int randomPart = 100000 + RANDOM.nextInt(900000); // 6 digits
        return "BK-" + datePart + "-" + randomPart;
    }

    // ==============================
    // PAYMENT REFERENCE
    // Example: PAY-3f8a1c9b
    // ==============================
    public static String generatePaymentRef() {
        return "PAY-" + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    // ==============================
    // GENERIC SHORT ID
    // Example: ID-A7F3K9Q2
    // ==============================
    public static String generateShortId(String prefix) {
        String random = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8)
                .toUpperCase();
        return prefix + "-" + random;
    }

    // ==============================
    // PREVENT INSTANTIATION
    // ==============================
    private IdGenerator() {
        throw new UnsupportedOperationException(
                "This is a utility class and cannot be instantiated");
    }
}