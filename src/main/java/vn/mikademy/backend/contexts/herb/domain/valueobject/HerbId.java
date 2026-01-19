package vn.mikademy.backend.contexts.herb.domain.valueobject;

import java.util.Objects;

public final class HerbId {

    private final Long value;

    public HerbId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("HerbId must be a positive number");
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    // =====================
    // Value Object contract
    // =====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HerbId herbId)) return false;
        return value.equals(herbId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
