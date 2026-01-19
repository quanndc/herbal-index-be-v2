package vn.mikademy.backend.common.valueobject;

import vn.mikademy.backend.common.exception.BusinessException;
import vn.mikademy.backend.common.exception.ErrorCode;

import java.util.Objects;

/**
 * Base class cho các Value Object dạng String.
 *
 * - Immutable
 * - Validate trong constructor
 * - So sánh theo value
 */
public abstract class AbstractStringValueObject {

    protected final String value;

    protected AbstractStringValueObject(
            String value,
            boolean allowNull,
            int maxLength,
            String fieldName
    ) {
        if (value == null || value.trim().isEmpty()) {
            if (allowNull) {
                this.value = null;
                return;
            }
            throw new BusinessException(
                    ErrorCode.INVALID_REQUEST,
                    fieldName + " must not be blank"
            );
        }

        String normalized = value.trim();

        if (normalized.length() > maxLength) {
            throw new BusinessException(
                    ErrorCode.INVALID_REQUEST,
                    fieldName + " must not exceed " + maxLength + " characters"
            );
        }

        this.value = normalized;
    }

    public String getValue() {
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    // =====================
    // Value Object contract
    // =====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractStringValueObject that = (AbstractStringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}