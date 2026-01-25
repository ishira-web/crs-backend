package com.carrental.carrental.common.constants;

public class ApiConstants {

    // ==============================
    // API BASE PATHS
    // ==============================
    public static final String API_BASE = "/api";
    public static final String API_V1 = API_BASE + "/v1";

    // ==============================
    // DOMAIN PATHS
    // ==============================
    public static final String CARS = API_V1 + "/cars";
    public static final String CUSTOMERS = API_V1 + "/customers";
    public static final String BOOKINGS = API_V1 + "/bookings";
    public static final String PAYMENTS = API_V1 + "/payments";
    public static final String MAINTENANCE = API_V1 + "/maintenance";
    public static final String USERS = API_V1 + "/users";
    public static final String BRANCHES = API_V1 + "/branches";
    public static final String AUTH = API_V1 + "/auth";

    // ==============================
    // COMMON SUB-PATHS
    // ==============================
    public static final String ID = "/{id}";
    public static final String SEARCH = "/search";
    public static final String STATUS = "/status";

    // ==============================
    // BOOKING ACTIONS
    // ==============================
    public static final String CONFIRM = "/{id}/confirm";
    public static final String CANCEL = "/{id}/cancel";
    public static final String PICKUP = "/{id}/pickup";
    public static final String RETURN = "/{id}/return";

    // ==============================
    // HTTP HEADERS
    // ==============================
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_REQUEST_ID = "X-Request-Id";

    // ==============================
    // SECURITY / TOKEN
    // ==============================
    public static final String BEARER_PREFIX = "Bearer ";

    // ==============================
    // PAGINATION DEFAULTS
    // ==============================
    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;

    // ==============================
    // SORT DEFAULTS
    // ==============================
    public static final String DEFAULT_SORT = "createdAt";
    public static final String DEFAULT_SORT_DIR = "DESC";

    // ==============================
    // PREVENT INSTANTIATION
    // ==============================
    private ApiConstants() {
        throw new UnsupportedOperationException("This is a constants class and cannot be instantiated");
    }

}
