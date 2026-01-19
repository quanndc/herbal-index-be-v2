package vn.mikademy.backend.common.util;

public final class StringUtils {
    private StringUtils(){};


    public static boolean isBlank(String value){
        return value == null || value.trim().isEmpty();
    };

    public static String normalize(String value){
        return value == null ? "" : value.trim();
    }

    public static String toUpperSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2")
                .toUpperCase();
    }
}
