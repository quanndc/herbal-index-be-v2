package vn.mikademy.backend.common.exception;

/**
 * NotFoundException đại diện cho các trường hợp
 * tài nguyên không tồn tại trong hệ thống.
 *
 * Ví dụ:
 * - Herb không tồn tại
 * - User không tồn tại
 * - Report không tồn tại
 */
public class NotFoundException extends BaseException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }
}