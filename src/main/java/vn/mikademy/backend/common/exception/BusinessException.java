package vn.mikademy.backend.common.exception;

/**
 * BusinessException đại diện cho các lỗi nghiệp vụ có chủ đích.
 *
 * - Được throw từ Domain / Application
 * - Luôn đi kèm ErrorCode
 * - KHÔNG dùng cho lỗi kỹ thuật (DB, IO, Network)
 */
public class BusinessException extends BaseException {

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String customMessage) {
        super(errorCode, customMessage);
    }
}