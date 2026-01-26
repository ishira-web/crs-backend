package com.carrental.carrental.common.constants;

public class ErrorMessages {

    // ==============================
    // GENERIC
    // ==============================
    public static final String INTERNAL_SERVER_ERROR =
            "An unexpected error occurred. Please contact support.";
    public static final String INVALID_REQUEST =
            "Invalid request data.";
    public static final String RESOURCE_NOT_FOUND =
            "Requested resource was not found.";
    public static final String UNAUTHORIZED =
            "You are not authorized to perform this action.";
    public static final String FORBIDDEN =
            "Access to this resource is forbidden.";
    public static final String VALIDATION_FAILED =
            "Validation failed for the request.";

    // ==============================
    // AUTH / SECURITY
    // ==============================
    public static final String INVALID_CREDENTIALS =
            "Invalid email or password.";
    public static final String TOKEN_EXPIRED =
            "Authentication token has expired.";
    public static final String TOKEN_INVALID =
            "Invalid authentication token.";
    public static final String ACCOUNT_DISABLED =
            "Your account has been disabled.";
    public static final String ACCOUNT_LOCKED =
            "Your account has been locked.";

    // ==============================
    // CAR DOMAIN
    // ==============================
    public static final String CAR_NOT_FOUND =
            "Car not found.";
    public static final String CAR_NOT_AVAILABLE =
            "Car is not available for the selected dates.";
    public static final String DUPLICATE_PLATE_NUMBER =
            "A car with this plate number already exists.";
    public static final String INVALID_CAR_STATUS =
            "Invalid car status for this operation.";

    // ==============================
    // CUSTOMER DOMAIN
    // ==============================
    public static final String CUSTOMER_NOT_FOUND =
            "Customer not found.";
    public static final String DUPLICATE_CUSTOMER_NIC =
            "A customer with this NIC/Passport already exists.";
    public static final String CUSTOMER_BLOCKED =
            "Customer is blocked and cannot make bookings.";

    // ==============================
    // BOOKING DOMAIN
    // ==============================
    public static final String BOOKING_NOT_FOUND =
            "Booking not found.";
    public static final String BOOKING_DATE_INVALID =
            "Booking end date must be after start date.";
    public static final String BOOKING_OVERLAP =
            "Car is already booked for the selected period.";
    public static final String BOOKING_STATUS_INVALID =
            "Invalid booking status for this action.";
    public static final String BOOKING_ALREADY_CANCELLED =
            "Booking is already cancelled.";
    public static final String BOOKING_ALREADY_RETURNED =
            "Booking is already returned.";

    // ==============================
    // PAYMENT DOMAIN
    // ==============================
    public static final String PAYMENT_NOT_FOUND =
            "Payment not found.";
    public static final String PAYMENT_AMOUNT_INVALID =
            "Invalid payment amount.";
    public static final String PAYMENT_ALREADY_COMPLETED =
            "Payment has already been comple    ted.";
    public static final String PAYMENT_FAILED =
            "Payment processing failed.";

    // ==============================
    // MAINTENANCE DOMAIN
    // ==============================
    public static final String MAINTENANCE_NOT_FOUND =
            "Maintenance record not found.";
    public static final String CAR_IN_MAINTENANCE =
            "Car is currently under maintenance.";

    // ==============================
    // USER / STAFF DOMAIN
    // ==============================
    public static final String USER_NOT_FOUND =
            "User not found.";
    public static final String EMAIL_ALREADY_EXISTS =
            "Email address is already in use.";
    public static final String INVALID_ROLE =
            "Invalid user role.";

    // ==============================
    // PREVENT INSTANTIATION
    // ==============================
    private ErrorMessages() {
        throw new UnsupportedOperationException(
                "This is a constants class and cannot be instantiated");
    }
}
