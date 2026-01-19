package vn.mikademy.backend.contexts.herb.domain.valueobject;

import vn.mikademy.backend.common.exception.BusinessException;
import vn.mikademy.backend.common.exception.ErrorCode;
import vn.mikademy.backend.common.util.SlugUtils;
import vn.mikademy.backend.common.util.StringUtils;

import java.util.Objects;

/**
 * Slug là public identifier cho Herb.
 * - Immutable
 * - URL-friendly
 * - Sinh từ tên dược liệu
 */
public final class Slug {

    private final String value;

    public Slug(String rawText) {
        if (StringUtils.isBlank(rawText)) {
            throw new BusinessException(
                    ErrorCode.INVALID_REQUEST,
                    "Slug source text must not be blank"
            );
        }

        String slug = SlugUtils.toSlug(rawText);

        if (StringUtils.isBlank(slug)) {
            throw new BusinessException(
                    ErrorCode.INVALID_REQUEST,
                    "Generated slug must not be empty"
            );
        }
        this.value = slug;
    }

    public String getValue() {
        return value;
    }

    // =====================
    // Value Object contract
    // =====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slug)) return false;
        Slug slug = (Slug) o;
        return value.equals(slug.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}