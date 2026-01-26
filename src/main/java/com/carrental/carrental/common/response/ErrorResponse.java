package com.carrental.carrental.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    // ==============================
    // BASIC ERROR INFO
    // ==============================
    private boolean success;     // always false
    private String message;      // user-friendly message
    private String errorCode;    // machine-readable code
    private int status;          // HTTP status code
    private String path;         // request path
    private LocalDateTime timestamp;

    // ==============================
    // VALIDATION ERRORS (OPTIONAL)
    // ==============================
    private List<FieldError> fieldErrors;

    // ==============================
    // NESTED FIELD ERROR CLASS
    // ==============================
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String message;
    }

    // ==============================
    // STATIC FACTORY METHODS
    // ==============================

    public static ErrorResponse of(int status,
                                   String message,
                                   String errorCode,
                                   String path) {
        return ErrorResponse.builder()
                .success(false)
                .status(status)
                .message(message)
                .errorCode(errorCode)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static ErrorResponse withFieldErrors(int status,
                                                String message,
                                                String errorCode,
                                                String path,
                                                List<FieldError> fieldErrors) {
        return ErrorResponse.builder()
                .success(false)
                .status(status)
                .message(message)
                .errorCode(errorCode)
                .path(path)
                .fieldErrors(fieldErrors)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
