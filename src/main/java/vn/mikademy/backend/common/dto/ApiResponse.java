package vn.mikademy.backend.common.dto;

import lombok.Getter;

public final class ApiResponse<T> {
    @Getter
    private final boolean success;
    private final T data;
    private final String error;

    private ApiResponse(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> failure(String error) {
        return new ApiResponse<>(false, null, error);
    }

    public boolean isFailure() {
        return !success;
    }

    public T getData() {
        if (!success) {
            throw new IllegalStateException("Cannot get data from failed response");
        }
        return data;
    }

    public String getError() {
        if (success) {
            throw new IllegalStateException("Cannot get error from successful response");
        }
        return error;
    }
}
