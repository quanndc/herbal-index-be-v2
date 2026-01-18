package vn.mikademy.backend.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Quy ước:
 * - Cxxx : Common
 * - Hxxx : Herb
 * - Uxxx : User
 * - Axxx : Auth
 * - Rxxx : Report
 */

public enum ErrorCode {

    // COMMON (Cxxx)
    INTERNAL_SERVER_ERROR(
            "C000",
            "Internal server error",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    INVALID_REQUEST(
            "C001",
            "Invalid request",
            HttpStatus.BAD_REQUEST
    ),

    UNAUTHORIZED(
            "C002",
            "Unauthorized",
            HttpStatus.UNAUTHORIZED
    ),

    FORBIDDEN(
            "C003",
            "Forbidden",
            HttpStatus.FORBIDDEN
    ),

    RESOURCE_NOT_FOUND(
            "C004",
            "Resource not found",
            HttpStatus.NOT_FOUND
    ),

    // HERB (Hxxx)
    HERB_NOT_FOUND(
            "H001",
            "Herb not found",
            HttpStatus.NOT_FOUND
    ),

    HERB_ALREADY_EXISTS(
            "H002",
            "Herb already exists",
            HttpStatus.CONFLICT
    ),

    HERB_INVALID_STATUS(
            "H003",
            "Invalid herb status",
            HttpStatus.BAD_REQUEST
    ),

    // USER (Uxxx)
    USER_NOT_FOUND(
            "U001",
            "User not found",
            HttpStatus.NOT_FOUND
    ),

    USER_ALREADY_EXISTS(
            "U002",
            "User already exists",
            HttpStatus.CONFLICT
    ),

    USER_DISABLED(
            "U003",
            "User is disabled",
            HttpStatus.FORBIDDEN
    ),

    // AUTH (Axxx)
    INVALID_CREDENTIALS(
            "A001",
            "Invalid credentials",
            HttpStatus.UNAUTHORIZED
    ),

    TOKEN_EXPIRED(
            "A002",
            "Token expired",
            HttpStatus.UNAUTHORIZED
    ),

    TOKEN_INVALID(
            "A003",
            "Invalid token",
            HttpStatus.UNAUTHORIZED
    ),

    // REPORT (Rxxx)
    REPORT_NOT_FOUND(
            "R001",
            "Report not found",
            HttpStatus.NOT_FOUND
    ),

    REPORT_ACCESS_DENIED(
            "R002",
            "Access denied to report",
            HttpStatus.FORBIDDEN
    );

    // FIELDS
    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    // GETTERS
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}