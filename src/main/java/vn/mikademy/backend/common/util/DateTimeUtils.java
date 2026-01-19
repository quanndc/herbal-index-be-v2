package vn.mikademy.backend.common.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class DateTimeUtils {

    private static final ZoneId UTC = ZoneId.of("UTC");

    private DateTimeUtils() {}

    public static Instant nowUtc() {
        return Instant.now();
    }

    public static ZonedDateTime toUtc(Instant instant) {
        return instant.atZone(UTC);
    }
}