package vn.mikademy.backend.common.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class DateTimeUtil {

    private static final ZoneId UTC = ZoneId.of("UTC");

    private DateTimeUtil() {}

    public static Instant nowUtc() {
        return Instant.now();
    }

    public static ZonedDateTime toUtc(Instant instant) {
        return instant.atZone(UTC);
    }
}