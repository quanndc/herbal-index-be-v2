package vn.mikademy.backend.common.dto;

import vn.mikademy.backend.common.response.SuccessCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;
    private String code;
    private String message;
    private T data;

    // SUCCESS
    public static <T> ApiResponse<T> success(T data) {
        return success(SuccessCode.SUCCESS, data);
    }

    public static <T> ApiResponse<T> success(SuccessCode successCode, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .code(successCode.getCode())
                .message(successCode.getMessage())
                .data(data)
                .build();
    }

    public static ApiResponse<Void> success(SuccessCode successCode) {
        return ApiResponse.<Void>builder()
                .success(true)
                .code(successCode.getCode())
                .message(successCode.getMessage())
                .build();
    }

    // ERROR
    public static ApiResponse<Void> error(String code, String message) {
        return ApiResponse.<Void>builder()
                .success(false)
                .code(code)
                .message(message)
                .build();
    }
}