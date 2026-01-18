package vn.mikademy.backend.common.response;

/**
 * SuccessCode là mã trạng thái thành công của API.
 * Đối xứng với ErrorCode.
 */
public enum SuccessCode {

    SUCCESS("SUCCESS", "Success"),
    CREATED("CREATED", "Created successfully"),
    UPDATED("UPDATED", "Updated successfully"),
    DELETED("DELETED", "Deleted successfully");

    private final String code;
    private final String message;

    SuccessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}